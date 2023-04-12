public abstract class ShieldDecorator extends BoardComponent {
	
	protected BoardComponent boardComponent;
	
	public ShieldDecorator(BoardComponent boardComponent) {
		this.boardComponent = boardComponent;
	}
	
	@Override
	public void Operation() {
		boardComponent.Operation();
	}

	@Override
	public void Add(BoardComponent child) {
		boardComponent.Add(child);
	}

	@Override
	public void Remove(BoardComponent child) {
		boardComponent.Remove(child);
	}	
}
