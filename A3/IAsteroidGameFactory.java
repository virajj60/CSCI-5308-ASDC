import java.util.ArrayList;

// This is the abstract factory requirement.
// It needs to create their squares, buildings, shields and asteroids.
public interface IAsteroidGameFactory
{
	public BoardComponent MakeSquare();
	public Building MakeBuilding();
	public Asteroid MakeAsteroid(int height);
	public ArrayList<ArrayList<BoardComponent>> MakeBoard(int height, int width);
	public Command MakeCommand(String commandLine);
	public BoardComponent MakeShield(BoardComponent boardComponent);	
}