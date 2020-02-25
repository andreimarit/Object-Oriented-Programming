
public class TestDriveABC {

	public static void main(String[] args) {
		
		C test = new C();
		
		try {
			((A)test).test("crash");
		}
		catch(ExceptionC e) {
			System.out.println("" + e.getMessage());
		}
		catch(ExceptionB e) {
			System.out.println("" + e.getMessage());
		}
		catch(ExceptionA e) {
			System.out.println("" + e.getMessage());
		}
	}

}
