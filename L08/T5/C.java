
public class C extends B{

	public void test(String msg) throws ExceptionC{
		if(msg.equals("crash")) {
			throw new ExceptionC("we are throwing exception C");
		}
	}
}
