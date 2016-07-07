package com.oreilly.struts.storefront.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import org.odmg.*;
import ojb.odmg.*;
import com.oreilly.struts.storefront.businessobjects.CustomerBO;
import com.oreilly.struts.storefront.businessobjects.ItemBO;
import com.oreilly.struts.storefront.catalog.view.ItemDetailView;
import com.oreilly.struts.storefront.catalog.view.ItemSummaryView;
import com.oreilly.struts.storefront.customer.view.UserView;
import com.oreilly.struts.storefront.framework.exceptions.AccountLockedException;
import com.oreilly.struts.storefront.framework.exceptions.DatastoreException;
import com.oreilly.struts.storefront.framework.exceptions.ExpiredPasswordException;
import com.oreilly.struts.storefront.framework.exceptions.InvalidLoginException;

/**
 * This is a simple Session Bean implementation of the Storefront service
 */
public class StorefrontBean implements SessionBean, IStorefront {
  private SessionContext ctx;
  private Implementation odmg = null;
  private Database db = null;


  public UserView authenticate( String email, String password )
   throws InvalidLoginException, ExpiredPasswordException,
   AccountLockedException, DatastoreException {

      // Query the database for a user that matches the credentials
      List results = null;
      try{
        OQLQuery query = odmg.newOQLQuery();
        // Set the OQL select statement
        String queryStr = "select customer from " + CustomerBO.class.getName();
        queryStr += " where email = $1 and password = $2";
        query.create(queryStr);

        // Bind the input parameters
        query.bind( email );
        query.bind( password );

        // Retrieve the results
        results = (List)query.execute();
      }catch( Exception ex ){
        ex.printStackTrace();
        throw DatastoreException.datastoreError(ex);
      }

      // If no results were found, must be an invalid login attempt
      if ( results.isEmpty() ){
        throw new InvalidLoginException();
      }

      // Should only be a single customer that matches the parameters
      CustomerBO customer  = (CustomerBO)results.get(0);

      // Make sure the account is not locked
      String accountStatusCode = customer.getAccountStatus();
      if ( accountStatusCode != null && accountStatusCode.equals( "L" ) ){
        throw new AccountLockedException();
      }

      // Populate the Value Object from the Customer business object
      UserView userView = new UserView();
      userView.setId( customer.getId().toString() );
      userView.setFirstName( customer.getFirstName() );
      userView.setLastName( customer.getLastName() );
      userView.setEmailAddress( customer.getEmail() );
      userView.setCreditStatus( customer.getCreditStatus() );

      return userView;
  }

  public List getFeaturedItems() throws DatastoreException {
    List results = null;
    try{
      OQLQuery query = odmg.newOQLQuery();
      // Set the OQL select statement
      query.create( "select featuredItems from " + ItemBO.class.getName() );
      results = (List)query.execute();
    }catch( Exception ex ){
      ex.printStackTrace();
      throw DatastoreException.datastoreError(ex);
    }
    List items = new ArrayList();
    Iterator iter = results.iterator();
    while (iter.hasNext()){
      ItemBO itemBO = (ItemBO)iter.next();
      ItemSummaryView newView = new ItemSummaryView();
      newView.setId( itemBO.getId().toString() );
      newView.setName( itemBO.getDisplayLabel() );
      newView.setUnitPrice( itemBO.getBasePrice() );
      newView.setSmallImageURL( itemBO.getSmallImageURL() );
      newView.setProductFeature( itemBO.getFeature1() );
      items.add( newView );
    }
    return items;
  }

  public ItemDetailView getItemDetailView( String itemId )
   throws DatastoreException {
      List results = null;
      try{
        OQLQuery query = odmg.newOQLQuery();

        // Set the OQL select statement
        String queryStr = "select item from " + ItemBO.class.getName();
        queryStr += " where id = $1";
        query.create(queryStr);
        query.bind(itemId);

        // Execute the query
        results = (List)query.execute();
      }catch( Exception ex ){
        ex.printStackTrace();
        throw DatastoreException.datastoreError(ex);
      }

      //
      if (results.isEmpty() ){
        throw DatastoreException.objectNotFound();
      }

      ItemBO itemBO = (ItemBO)results.get(0);

      // Build a ValueObject for the Item
      ItemDetailView view = new ItemDetailView();
      view.setId( itemBO.getId().toString() );
      view.setDescription( itemBO.getDescription() );
      view.setLargeImageURL( itemBO.getLargeImageURL() );
      view.setName( itemBO.getDisplayLabel() );
      view.setProductFeature( itemBO.getFeature1() );
      view.setUnitPrice( itemBO.getBasePrice() );
      view.setTimeCreated( new Timestamp(System.currentTimeMillis() ));
      view.setModelNumber( itemBO.getModelNumber() );
      return view;
  }

  /**
   * Opens the database and prepares it for transactions
   */
  private void init() throws DatastoreException {
    // get odmg facade instance
    odmg = OJB.getInstance();
    db = odmg.newDatabase();
    //open database
    try{
      db.open("repository.xml", Database.OPEN_READ_WRITE);
    }catch( ODMGException ex ){
      throw DatastoreException.datastoreError(ex);
    }
  }

  public void ejbCreate() throws CreateException {
    try {
      init();
    }catch ( DatastoreException e ) {
      throw new CreateException(e.getMessage());
    }
  }

  public void ejbRemove() {
    try {
      if (db != null) {
        db.close();
      }
    }catch ( ODMGException e ) {}
  }

  public void setSessionContext( SessionContext assignedContext ) {
    ctx = assignedContext;
  }

  public void ejbActivate() {
    // nothing to do for a stateless bean
  }

  public void ejbPassivate() {
    // nothing to do for a stateless bean
  }

}
