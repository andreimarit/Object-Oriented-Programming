
public class Mouse extends Rodent {
	
	
	Mouse(String m_name, double weight){
		super(m_name, weight);
	}
	
	void eat() {
		System.out.println("Mouse " + super.name + " is eating");
	}
	
	void sleep() {
		System.out.println("Mouse " + super.name + " is sleeping");
	}
	
	void info() {
		System.out.println("Mouse name is " + super.name + " and it wights " + super.weight + " grams");
	}

}
