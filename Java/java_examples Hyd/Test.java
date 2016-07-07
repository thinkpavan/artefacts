class  Test
{
	public static void main(String[] args) 
	{
		 InitialContext initCtx = null;
    try {
			  initCtx = new InitialContext();
			  DataSource ds = (javax.sql.DataSource) initCtx.lookup("sls"); // look up for object in jndi tree
			  ds.getConnection();
		  }
	catch(NamingException ne) {
			System.out.println(ne);
			throw new EJBException(ne);
    } finally {
	  try {
				if(initCtx != null) initCtx.close();
			}
	  catch(NamingException ne) 
		{
			throw new EJBException(ne);
		}
    }
	}
}
