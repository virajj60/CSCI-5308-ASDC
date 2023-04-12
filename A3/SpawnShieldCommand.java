public class SpawnShieldCommand extends Command {

	public SpawnShieldCommand(Object receiver, String[] args) {
		super(receiver, args);
	}

	@Override
	public void Execute() {
		Square square = (Square) receiver;
		IAsteroidGameFactory factory = GameBoard.Instance().GetFactory();
		BoardComponent shield = factory.MakeShield(square);
		//When a shield is spawned replace the square object with the shield in the board.
		GameBoard.Instance().GetBoard().get(Integer.parseInt(args[1])).remove(Integer.parseInt(args[0]));
		GameBoard.Instance().GetBoard().get(Integer.parseInt(args[1])).add(Integer.parseInt(args[0]),
				shield);
		System.out.println("Spawning Shield at (" + args[0] + "," + args[1] + ")");
		//If the square is attached to the observers list, remove it.
		square.GetSubject().detach(square);
		//Add the shield to the observers list.
		square.GetSubject().attach((IObserver) shield);
	}
}
