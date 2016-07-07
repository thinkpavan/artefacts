
class Singleton {

	static Singleton obj ;

	private Singleton ()
	{

	}
	public static Singleton  create()
	{
		if( obj == null )
		{
			obj = new  Singleton();
		}
		return obj ;
	}

	void foo()
	{
		System.out.println("This is foo");
	}

}

public class Test
{
	public static void main(String[] args) {
		System.out.println(Singleton.create());
		System.out.println(Singleton.create());
		System.out.println(Singleton.create());
	}
}













