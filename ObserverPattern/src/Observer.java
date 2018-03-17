import java.util.ArrayList;

public abstract class Observer {
	public abstract void notify(ConcreteSubject subject,ArrayList<String> change);
}
