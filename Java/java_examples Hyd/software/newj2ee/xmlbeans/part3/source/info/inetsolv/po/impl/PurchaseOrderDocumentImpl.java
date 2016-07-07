/*
 * An XML document type.
 * Localname: purchase-order
 * Namespace: http://inetsolv.info/po
 * Java type: info.inetsolv.po.PurchaseOrderDocument
 *
 * Automatically generated - do not modify.
 */
package info.inetsolv.po.impl;
/**
 * A document containing one purchase-order(@http://inetsolv.info/po) element.
 *
 * This is a complex type.
 */
public class PurchaseOrderDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements info.inetsolv.po.PurchaseOrderDocument
{
    
    public PurchaseOrderDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PURCHASEORDER$0 = 
        new javax.xml.namespace.QName("http://inetsolv.info/po", "purchase-order");
    
    
    /**
     * Gets the "purchase-order" element
     */
    public info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder getPurchaseOrder()
    {
        synchronized (monitor())
        {
            check_orphaned();
            info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder target = null;
            target = (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder)get_store().find_element_user(PURCHASEORDER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "purchase-order" element
     */
    public void setPurchaseOrder(info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder purchaseOrder)
    {
        synchronized (monitor())
        {
            check_orphaned();
            info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder target = null;
            target = (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder)get_store().find_element_user(PURCHASEORDER$0, 0);
            if (target == null)
            {
                target = (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder)get_store().add_element_user(PURCHASEORDER$0);
            }
            target.set(purchaseOrder);
        }
    }
    
    /**
     * Appends and returns a new empty "purchase-order" element
     */
    public info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder addNewPurchaseOrder()
    {
        synchronized (monitor())
        {
            check_orphaned();
            info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder target = null;
            target = (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder)get_store().add_element_user(PURCHASEORDER$0);
            return target;
        }
    }
    /**
     * An XML purchase-order(@http://inetsolv.info/po).
     *
     * This is a complex type.
     */
    public static class PurchaseOrderImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder
    {
        
        public PurchaseOrderImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CUSTOMER$0 = 
            new javax.xml.namespace.QName("http://inetsolv.info/po", "customer");
        private static final javax.xml.namespace.QName LINEITEM$2 = 
            new javax.xml.namespace.QName("http://inetsolv.info/po", "line-item");
        
        
        /**
         * Gets the "customer" element
         */
        public info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer getCustomer()
        {
            synchronized (monitor())
            {
                check_orphaned();
                info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer target = null;
                target = (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer)get_store().find_element_user(CUSTOMER$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "customer" element
         */
        public void setCustomer(info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer customer)
        {
            synchronized (monitor())
            {
                check_orphaned();
                info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer target = null;
                target = (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer)get_store().find_element_user(CUSTOMER$0, 0);
                if (target == null)
                {
                    target = (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer)get_store().add_element_user(CUSTOMER$0);
                }
                target.set(customer);
            }
        }
        
        /**
         * Appends and returns a new empty "customer" element
         */
        public info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer addNewCustomer()
        {
            synchronized (monitor())
            {
                check_orphaned();
                info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer target = null;
                target = (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer)get_store().add_element_user(CUSTOMER$0);
                return target;
            }
        }
        
        /**
         * Gets array of all "line-item" elements
         */
        public info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem[] getLineItemArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(LINEITEM$2, targetList);
                info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem[] result = new info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "line-item" element
         */
        public info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem getLineItemArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem target = null;
                target = (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem)get_store().find_element_user(LINEITEM$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "line-item" element
         */
        public int sizeOfLineItemArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(LINEITEM$2);
            }
        }
        
        /**
         * Sets array of all "line-item" element
         */
        public void setLineItemArray(info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem[] lineItemArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(lineItemArray, LINEITEM$2);
            }
        }
        
        /**
         * Sets ith "line-item" element
         */
        public void setLineItemArray(int i, info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem lineItem)
        {
            synchronized (monitor())
            {
                check_orphaned();
                info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem target = null;
                target = (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem)get_store().find_element_user(LINEITEM$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(lineItem);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "line-item" element
         */
        public info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem insertNewLineItem(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem target = null;
                target = (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem)get_store().insert_element_user(LINEITEM$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "line-item" element
         */
        public info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem addNewLineItem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem target = null;
                target = (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem)get_store().add_element_user(LINEITEM$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "line-item" element
         */
        public void removeLineItem(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(LINEITEM$2, i);
            }
        }
        /**
         * An XML customer(@http://inetsolv.info/po).
         *
         * This is a complex type.
         */
        public static class CustomerImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer
        {
            
            public CustomerImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName NAME$0 = 
                new javax.xml.namespace.QName("http://inetsolv.info/po", "name");
            private static final javax.xml.namespace.QName ADDRESS$2 = 
                new javax.xml.namespace.QName("http://inetsolv.info/po", "address");
            private static final javax.xml.namespace.QName AGE$4 = 
                new javax.xml.namespace.QName("", "age");
            private static final javax.xml.namespace.QName SA$6 = 
                new javax.xml.namespace.QName("", "sa");
            
            
            /**
             * Gets the "name" element
             */
            public java.lang.String getName()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$0, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "name" element
             */
            public org.apache.xmlbeans.XmlString xgetName()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$0, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "name" element
             */
            public void setName(java.lang.String name)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NAME$0);
                    }
                    target.setStringValue(name);
                }
            }
            
            /**
             * Sets (as xml) the "name" element
             */
            public void xsetName(org.apache.xmlbeans.XmlString name)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NAME$0);
                    }
                    target.set(name);
                }
            }
            
            /**
             * Gets the "address" element
             */
            public java.lang.String getAddress()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESS$2, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "address" element
             */
            public org.apache.xmlbeans.XmlString xgetAddress()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESS$2, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "address" element
             */
            public void setAddress(java.lang.String address)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESS$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ADDRESS$2);
                    }
                    target.setStringValue(address);
                }
            }
            
            /**
             * Sets (as xml) the "address" element
             */
            public void xsetAddress(org.apache.xmlbeans.XmlString address)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESS$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ADDRESS$2);
                    }
                    target.set(address);
                }
            }
            
            /**
             * Gets the "age" attribute
             */
            public int getAge()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGE$4);
                    if (target == null)
                    {
                      return 0;
                    }
                    return target.getIntValue();
                }
            }
            
            /**
             * Gets (as xml) the "age" attribute
             */
            public org.apache.xmlbeans.XmlInt xgetAge()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInt target = null;
                    target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(AGE$4);
                    return target;
                }
            }
            
            /**
             * True if has "age" attribute
             */
            public boolean isSetAge()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(AGE$4) != null;
                }
            }
            
            /**
             * Sets the "age" attribute
             */
            public void setAge(int age)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(AGE$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(AGE$4);
                    }
                    target.setIntValue(age);
                }
            }
            
            /**
             * Sets (as xml) the "age" attribute
             */
            public void xsetAge(org.apache.xmlbeans.XmlInt age)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInt target = null;
                    target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(AGE$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(AGE$4);
                    }
                    target.set(age);
                }
            }
            
            /**
             * Unsets the "age" attribute
             */
            public void unsetAge()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(AGE$4);
                }
            }
            
            /**
             * Gets the "sa" attribute
             */
            public int getSa()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SA$6);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(SA$6);
                    }
                    if (target == null)
                    {
                      return 0;
                    }
                    return target.getIntValue();
                }
            }
            
            /**
             * Gets (as xml) the "sa" attribute
             */
            public org.apache.xmlbeans.XmlInt xgetSa()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInt target = null;
                    target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(SA$6);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlInt)get_default_attribute_value(SA$6);
                    }
                    return target;
                }
            }
            
            /**
             * True if has "sa" attribute
             */
            public boolean isSetSa()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(SA$6) != null;
                }
            }
            
            /**
             * Sets the "sa" attribute
             */
            public void setSa(int sa)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SA$6);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SA$6);
                    }
                    target.setIntValue(sa);
                }
            }
            
            /**
             * Sets (as xml) the "sa" attribute
             */
            public void xsetSa(org.apache.xmlbeans.XmlInt sa)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInt target = null;
                    target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(SA$6);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(SA$6);
                    }
                    target.set(sa);
                }
            }
            
            /**
             * Unsets the "sa" attribute
             */
            public void unsetSa()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(SA$6);
                }
            }
        }
        /**
         * An XML line-item(@http://inetsolv.info/po).
         *
         * This is a complex type.
         */
        public static class LineItemImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem
        {
            
            public LineItemImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName DESCRIPTION$0 = 
                new javax.xml.namespace.QName("http://inetsolv.info/po", "description");
            private static final javax.xml.namespace.QName PRICE$2 = 
                new javax.xml.namespace.QName("http://inetsolv.info/po", "price");
            private static final javax.xml.namespace.QName QUANTITY$4 = 
                new javax.xml.namespace.QName("http://inetsolv.info/po", "quantity");
            
            
            /**
             * Gets the "description" element
             */
            public java.lang.String getDescription()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$0, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "description" element
             */
            public org.apache.xmlbeans.XmlString xgetDescription()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$0, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "description" element
             */
            public void setDescription(java.lang.String description)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DESCRIPTION$0);
                    }
                    target.setStringValue(description);
                }
            }
            
            /**
             * Sets (as xml) the "description" element
             */
            public void xsetDescription(org.apache.xmlbeans.XmlString description)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DESCRIPTION$0);
                    }
                    target.set(description);
                }
            }
            
            /**
             * Gets the "price" element
             */
            public java.math.BigDecimal getPrice()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PRICE$2, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getBigDecimalValue();
                }
            }
            
            /**
             * Gets (as xml) the "price" element
             */
            public org.apache.xmlbeans.XmlDecimal xgetPrice()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(PRICE$2, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "price" element
             */
            public void setPrice(java.math.BigDecimal price)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PRICE$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PRICE$2);
                    }
                    target.setBigDecimalValue(price);
                }
            }
            
            /**
             * Sets (as xml) the "price" element
             */
            public void xsetPrice(org.apache.xmlbeans.XmlDecimal price)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(PRICE$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(PRICE$2);
                    }
                    target.set(price);
                }
            }
            
            /**
             * Gets the "quantity" element
             */
            public java.math.BigInteger getQuantity()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(QUANTITY$4, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getBigIntegerValue();
                }
            }
            
            /**
             * Gets (as xml) the "quantity" element
             */
            public org.apache.xmlbeans.XmlInteger xgetQuantity()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInteger target = null;
                    target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(QUANTITY$4, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "quantity" element
             */
            public void setQuantity(java.math.BigInteger quantity)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(QUANTITY$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(QUANTITY$4);
                    }
                    target.setBigIntegerValue(quantity);
                }
            }
            
            /**
             * Sets (as xml) the "quantity" element
             */
            public void xsetQuantity(org.apache.xmlbeans.XmlInteger quantity)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInteger target = null;
                    target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(QUANTITY$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlInteger)get_store().add_element_user(QUANTITY$4);
                    }
                    target.set(quantity);
                }
            }
        }
    }
}
