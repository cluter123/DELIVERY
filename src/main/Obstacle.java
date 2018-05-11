package main;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public abstract class Obstacle {
	
	private int x, y, velX, velY;
	private Rectangle2D bounds;

	public Obstacle(int x, int y) 
	{
		this.setX(x);
		this.setY(y);
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

	/**
	 * @return the velY
	 */
	public int getVelY() {
		return velY;
	}

	/**
	 * @param velY the velY to set
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}

	/**
	 * @return the velX
	 */
	public int getVelX() {
		return velX;
	}

	/**
	 * @param velX the velX to set
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
}
