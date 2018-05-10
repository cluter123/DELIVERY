package main;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public abstract class Character {
	
	protected int x, y, velX, velY;
	private int points;
	private Rectangle2D bounds;
	
	public Character(int x, int y) 
	{
		this.x = x;
		this.y = y;
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
