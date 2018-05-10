package main;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public abstract class Obstacle {
	
	protected int x;
	public int y;
	protected int velX;
	protected int velY;
	private Position position;
	private Rectangle2D bounds;

	public Obstacle(int x, int y) {
		this.x = x;
		this.y = y;
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
