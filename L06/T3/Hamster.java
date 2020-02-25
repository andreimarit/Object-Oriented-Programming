
public class Hamster extends Rodent {
	
	Hamster(String h_name, double weight){
		super(h_name, weight);
	}
	
	void eat() {
		System.out.println("Hamster " + super.name + " is eating");
	}
	
	void sleep() {
		System.out.println("Hamster " + super.name + " is sleeping");
	}
	
	void info() {
		System.out.println("Hamster name is " + super.name + " and it wights " + super.weight + " grams");
	}

}
