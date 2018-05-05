import java.awt.Graphics2D;

public abstract class Obstacle {
	
	private Position position;

	public Obstacle(Position pos) {
		position = pos;
	}
	
	public void setPosition(Position p)
	{
		position = p;
	}
	
	public Position getPosition()
	{
		return position;
	}
	
	public void movePosition(int xAmt, int yAmt)
	{
		position.addX(xAmt);
		position.addY(yAmt);
	}
	
	public abstract void draw(Graphics2D gr);

}
