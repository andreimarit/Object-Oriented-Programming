
public class WrongOrderException extends Exception {
	
	String msg;
	
	public WrongOrderException() {};
	
	public WrongOrderException(String msg) {
		this.msg = msg;
	}
	
	public void printMsg() {
		System.out.println("" + this.msg);
	}

	public static void main(String[] args) {

	}

}
