
public class B extends A{
	
	public void test(String msg) throws ExceptionB{
		if(msg.equals("crash")) {
			throw new ExceptionB("we are throwing exception B");
		}
	}

}
