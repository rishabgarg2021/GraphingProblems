
public class Tut1 {
	
	
	
	
	public static void main(String [] args) {
		Observer o1 = new ActiveObserver();
		ConcreteSubject s1= new Subject("1","fire alarm not working");
		ConcreteSubject s2= new Subject("1","water availaible");
		s1.registerObserver(o1);
		s2.registerObserver(o1);
		s1.setMessage("fire alarm active");
		s2.setMessage("water not availaible");
		
		
		
		
	}

}
