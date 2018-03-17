import java.util.ArrayList;
import java.util.List;

public  class Subject extends ConcreteSubject {
	private List<Observer> observers;

	
	public Subject(String state,String message) {
		observers = new ArrayList<>();
		this.state=state;
		this.message=message;
		att=new ArrayList<>();
		
		
	}
	public void setState(String state) {
		this.state=state;
		att.add(state);
		notifyall();
		
	}
	public String getState() {
		return this.state;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message=message;
		att.add(message);
		notifyall();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	public void disregisterObserver(Observer o) {
		observers.remove(observers.indexOf(o));
	}
	public void notifyall() {
		for(Observer o :observers) {
			o.notify(this,att);
		}
		att.clear();
		att=new ArrayList<>();
	}
	
	
}
