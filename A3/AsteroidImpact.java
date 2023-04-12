import java.util.ArrayList;
import java.util.Iterator;

public class AsteroidImpact implements ISubject {
	
	public ArrayList<IObserver> observers = new ArrayList<IObserver>();

	public void attach(IObserver observer) {
		if(!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	public void detach(IObserver observer) {
		observers.remove(observer);
	}

	public void notifyAllObservers() {
		ArrayList<IObserver> copyObservers = observers;
		for (Iterator<IObserver> itr = copyObservers.iterator(); itr.hasNext();) {
			itr.next().update();
			if(copyObservers.size() ==0) {
				break;
			}
		}
	}
}
