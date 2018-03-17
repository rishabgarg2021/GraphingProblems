import java.util.ArrayList;
import java.util.List;

public abstract class ConcreteSubject {
    ArrayList<String> att;
	String state;
    String message;
    List<Observer> observers;

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void registerObserver(Observer o) {
		
	}
	public void disregisterObserver(Observer o) {
	
	}
	public void notifyall() {
		
	}
}
