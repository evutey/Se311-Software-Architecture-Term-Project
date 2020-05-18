//Evren Utku Güney
//Sýla Tekcan
//Gökay Gök
//Ceren Delibaþ
//Virus Tracking Application
import java.util.ArrayList;
import java.util.List;

public class ConditionInfoObserver {

	private List<Observer> observers = new ArrayList<Observer>();
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}

abstract class Observer {
	protected ConditionInfoObserver conditionInfo;

	public abstract void update();
}

class IphoneObserver extends Observer {

	public IphoneObserver(ConditionInfoObserver conditionInfo) {
		this.conditionInfo = conditionInfo;
		this.conditionInfo.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Enter your condition info again");
		PhoneMaker.getPhoneInstance().createPhoneUser(conditionInfo.getState());
		System.err.println("\nYour information updated");
	}
}

class SamsungObserver extends Observer {

	public SamsungObserver(ConditionInfoObserver conditionInfo) {
		this.conditionInfo = conditionInfo;
		this.conditionInfo.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Enter your condition info again");
		PhoneMaker.getPhoneInstance().createPhoneUser(conditionInfo.getState());
		System.err.println("\nYour information updated");
	}
}