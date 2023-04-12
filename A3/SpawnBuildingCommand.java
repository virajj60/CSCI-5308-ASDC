public class SpawnBuildingCommand extends Command{

	public SpawnBuildingCommand(Object receiver, String[] args) {
		super(receiver, args);
	}

	@Override
	public void Execute() {
		BoardComponent boardComponent = (BoardComponent) receiver;
		IAsteroidGameFactory factory = GameBoard.Instance().GetFactory();
		Building building = factory.MakeBuilding();
		boardComponent.Add(building);
		System.out.println("Spawning Building at (" + args[0] + "," + args[1] + ")");
		//Add the square in which the building is spawned to the observers list.
		boardComponent.GetSubject().attach((IObserver) building.parent);
		GameBoard.Instance().IncrementBuildingCount();
	}
}
