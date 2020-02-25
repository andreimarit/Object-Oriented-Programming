
public class Ex3 {

	public static void main(String[] args) {
		
		DogEx3 doggo = null;
		try {
			doggo.barks();
		}
		catch(NullPointerException e) {
			doggo = new DogEx3();
			doggo.barks();
		}

	}

}
