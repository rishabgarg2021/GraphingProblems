import java.util.ArrayList;
import java.util.List;

public class Collecton {

	public static  class Animal{
//		public void bark() {
//			System.out.println("animal");
//		}
	}
	public static class Dog extends Animal{
		public void bark() {
			System.out.println("dog");
		}
		
	}
	public static void main(String[] args) {
	
		Animal a = new Dog();
		Dog b=(Dog)a;
		b.bark();

	}

}
