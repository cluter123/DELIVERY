package main;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public abstract class Character {
	
	private Position position;
	private int points;
	private Rectangle2D bounds;
	
	public Character(Position pos) 
	{
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
	
	public int getPoints()
	{
		return points;
	}
	
	public void setBoundingRectangle(Rectangle2D bounds)
	{
		this.bounds = bounds;
	}

	public Rectangle2D getBoundingRectangle()
	{
		return bounds;
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics2D gr);
	

}
