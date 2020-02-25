package classes;
import interfaces.FastFood;

class Meal{
	Meal() { System.out.println("Meal()"); }
}
class Bread{
	String name = "Bread";
	Bread() { System.out.println("Bread()"); }
}
class Cheese{
	String name = "Cheese";
	Cheese() { System.out.println("Cheese()"); }
}
class Lettuce{
	String name = "Lettuce";
	Lettuce() { System.out.println("Lettuce()"); }
}
class Lunch extends Meal{
	Lunch() { System.out.println("Lunch()"); }
}

class PortableLunch extends Lunch{
	PortableLunch() { System.out.println("PortableLunch()");}
}

public class Sandwich extends PortableLunch implements FastFood
{
	private Bread b = new Bread();
	private Cheese c = new Cheese();
	private Lettuce l = new Lettuce();
	
	public Sandwich(){
		System.out.println("Sandwich()");
	}
	
	public void command() {
		System.out.println("Here is your order. It has " + this.b.name + ", " + this.c.name + ", " + this.l.name);
	}

	public int pay() {
		return 15;
	}

	public void greet(boolean flag) {
		if(flag) {
			System.out.println("Welcome to our fast-food!");
		}
		else {
			System.out.println("Bye, have a good day!");
		}
	}

	public static void main(String[] args){
		boolean enter = true;
		boolean leave = false;

		Sandwich s = new Sandwich();
		
		s.greet(enter);
		s.command();
		System.out.println("you have to pay " + s.pay() + " ron");
		s.greet(leave);
	}
}
