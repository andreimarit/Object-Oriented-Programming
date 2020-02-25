
public class Dog extends Animal {
	
	public void sleeps() {
		System.out.println("Dog is sleeping");
	}

	public static void doesSomething() {
		Animal Bethoveen = new Dog();
	//	((Dog)Bethoveen).sleeps();   -- this is for when we don't have an abstract method
		Bethoveen.sleeps();
		System.out.println("Dog does something");
	}
	
	public static void main(String[] args) {
		
	//	Dog.doesSomething();
	}
	
}
