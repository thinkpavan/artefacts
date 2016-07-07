/* shows about policy object used for security
Author : Team -J
Version : 1.0 */
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Policy;
import java.util.Enumeration;
class PolicyServer{
	public static void main(String args[]) throws Exception{
	System.out.println(Policy.getPolicy().getClass());
	//System.setSecurityManager( new java.rmi.RMISecurityManager());

	System.out.println(Policy.getPolicy().getClass());
	Policy ap = Policy.getPolicy();
	PermissionCollection  pc = ap.getPermissions(new CodeSource(null,null));
	Enumeration e = pc.elements();
	while(e.hasMoreElements() ){
		System.out.println(e.nextElement());
	}
}
}

