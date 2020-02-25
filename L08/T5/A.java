
public class A {

	public void test(String msg) throws ExceptionA{
		if(msg.equals("crash")) {
			throw new ExceptionA("we are throwing exception A");
		}
	}
}
