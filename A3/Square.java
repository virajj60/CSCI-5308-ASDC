import java.util.ArrayList;

// Square is a composite, making up the Composite pattern (contains components)
public class Square extends BoardComponent implements IObserver
{
	private final ArrayList<BoardComponent> children;
	/* private BoardComponent parent; */
	public ISubject subject;
	
	public Square()
	{
		super();
		children = new ArrayList<BoardComponent>();
		subject  = new AsteroidImpact();
	}

	@Override
	public void Operation()
	{
		ArrayList<BoardComponent> childrenCopy = new ArrayList<BoardComponent>(children);
		for (int i = 0; i < childrenCopy.size(); i++)
		{
			BoardComponent child = childrenCopy.get(i);
			child.Operation();
		}
	}

	@Override
	public void Add(BoardComponent child)
	{
		// I am now this child's parent.
		children.add(child);
		child.SetParent(this);
	}

	@Override
	public void Remove(BoardComponent child)
	{
		children.remove(child);
	}

	@Override
	public ISubject GetSubject() {
		return subject;		
	}

	@Override
	public void update() {
		ArrayList<BoardComponent> childrenCopy = new ArrayList<BoardComponent>(children);
		for (int i = 0; i < childrenCopy.size(); i++)
		{
			BoardComponent child = childrenCopy.get(i);
			IObserver childObs = (IObserver) child;
			childObs.update();
		}
	}
}