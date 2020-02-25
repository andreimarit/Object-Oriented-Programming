
public class TDRodent {

	 public static void main(String[] args) {
		Rodent[] r = new Rodent[3];
		
		r[0] = new Mouse("Jerry", 155.4);
		r[1] = new Hamster("Hernandez", 275.7);
		r[2] = new Squirrel("Dave", 350);
		
		for(int i = 0; i < r.length; i++) {
			r[i].info();
		}
		System.out.println("");
		for(int i = 0; i < r.length; i++) {
			r[i].sleep();
		}
		System.out.println("");
		for(int i = 0; i < r.length; i++) {
			r[i].eat();
		}
		System.out.println("");

	}
	
}
