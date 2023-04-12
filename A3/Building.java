// Building is the leaf node for the composite pattern, Square's can have MULTIPLE Buildings
// Buildings cannot have children.
public class Building extends BoardComponent implements IObserver {
	private int buildingHealth;
	
	public Building() {
		super();
		buildingHealth = 2;
	}

	public int getBuildingHealth() {
		return buildingHealth;
	}

	@Override
	public void Operation() {
		// Buildings just stand there, they don't do anything.
	}

	@Override
	public void Add(BoardComponent child) {
		// Do nothing, I'm a leaf.
	}

	@Override
	public void Remove(BoardComponent child) {
		// Do nothing, I'm a leaf.
	}

	@Override
	public void update() {
			decrementBuildingHealth();
			if (getBuildingHealth() == 0) {
				//Building is destyored.It is no longer part of the square composite.
				parent.Remove(this);
				GameBoard.Instance().DecrementBuildingCount();
			}
	}

	public void decrementBuildingHealth() {
		buildingHealth -= 1;
	}

	@Override
	public ISubject GetSubject() {
		return null;
	}
}