import java.awt.Graphics2D;

public abstract class Character {
	
	private Position position;
	private int points;
	
	public Character(Position pos, int initialPoints) 
	{
		position = pos;
		points = initialPoints;
		
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
	
	public int getPoints()
	{
		return points;
	}
	
	public abstract void draw(Graphics2D gr);
	
	public abstract void update();
	

}
