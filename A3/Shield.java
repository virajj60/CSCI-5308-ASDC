import java.util.ArrayList;

public class Shield extends ShieldDecorator implements IObserver{

	private int shieldHealth;
	
	public Shield(BoardComponent boardComponent) {
		super(boardComponent);
		setShieldHealth(2);
		boardComponent.SetParent(this);
	}
	
	public void setShieldHealth(int shieldHealth) {
		this.shieldHealth = shieldHealth;
	}
	
	public int getShieldHealth() {
		return shieldHealth;
	}
 	
	@Override
	public void Add(BoardComponent child) {
		super.Add(child);
	}
	
	@Override
	public void update() {
		decrementShieldHealth();
		if(getShieldHealth() == 0) {
			//Remove the shield from the square.
			boardComponent.SetParent(null);
			//Remove the shield from the observer's list
			boardComponent.GetSubject().detach(this);
			//Add the square back to the observers list
			boardComponent.GetSubject().attach((IObserver) boardComponent);
			//Shield is destroyed. Replace it back with the sqaure in the game board
			reAttachSqaure();
		}
	}
	
	public void decrementShieldHealth() {
		shieldHealth -=1;
	}

	public void reAttachSqaure() {
		int x=-1,y=-1;
		ArrayList<ArrayList<BoardComponent>> board = GameBoard.Instance().GetBoard();
		for (int i = 0; i < board.size(); i++)
		{
			y=i;
			ArrayList<BoardComponent> row = board.get(i);
			for (int j = 0; j < row.size(); j++)
			{
				if(this.equals(row.get(j))){
					x=j;
					break;
				}
			}
			if(x!=-1) {
				break;
			}
		}
		board.get(y).remove(x);
		board.get(y).add(x, boardComponent);
	}
	
	@Override
	public ISubject GetSubject() {
		return boardComponent.GetSubject();
	}
}