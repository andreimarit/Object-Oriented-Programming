package classes;

import interfaces.Pet;

public class Dog implements Pet{
	
	String name;
	
	public Dog() {
		this.name = "Rex";
	}
	
	public Dog(String name) {
		this.name = name;
	}
	
	public void eats() {
		System.out.println(this.name + " is eating");
	}
	
	public void sleeps() {
		System.out.println(this.name + " is sleeping");
	}
	
	public void plays() {
		System.out.println(this.name + " is playing");
	}
	
	public static void main(String args[])
	{
		Dog pupper = new Dog("Fluffy");
		pupper.eats();
		pupper.sleeps();
		pupper.plays();
	}

}
