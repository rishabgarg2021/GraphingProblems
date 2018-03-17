import java.util.ArrayList;

public class ActiveObserver extends Observer{
	public ActiveObserver() {
		
	}

	@Override
	public void notify(ConcreteSubject subject, ArrayList<String> change) {
		for(String s:change) {
			System.out.println(subject.getClass()+ "its attribute changed  to "+ s);
			
		}
	}
}
