package main;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public abstract class Obstacle {
	
	private Position position;
	private Rectangle2D bounds;

	public Obstacle(Position pos) {
		position = pos;
		bounds = new Rectangle(0,0,0,0);
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
	
	public void setBoundingRectangle(Rectangle2D bounds)
	{
		this.bounds = bounds;
	}
	
	public Rectangle2D getBoundingRectangle()
	{
		return bounds;
	}

	public abstract void draw(Graphics2D gr);
}
