
public class Rodent {
	
	protected String name;
	protected double weight;
	
	Rodent(){
		this.name = "Jon Doe";
		this.weight = 11.11;
	}
	
	Rodent(String name, double w){
		this.name = name;
		this.weight = w;
	}

	void eat() {
		System.out.println("Rodent " + this.name + " is eating");
	}
	
	void sleep() {
		System.out.println("Rodent " + this.name + " is sleeping");
	}
	
	void info() {
		System.out.println("Rodent name is " + this.name + " and it wights " + this.weight + " grams");
	}
	
}
