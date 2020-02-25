
public class Ex4 {

	public static void g(String day) throws WrongDayException{
		if(day.equals("Sambata") || day.equals("Duminica")){
			throw new WrongDayException("Can't do it on the weekend");
		}
	}
	
	public static void f(int hour, String day) throws WrongHourException{
		try {
			g(day);
		}
		catch(WrongDayException e) {
			System.out.println("" + e.getMessage());
			if(hour > 20) {
				throw new WrongHourException("Can't do it after 8");
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			f(21, "Sambata");
		}
		catch(WrongHourException e) {
			System.out.println("" + e.getMessage());
		}
	}
}
