/**
 *  An abstract class modeling game variables that update.
 *  Keeps track of position, velocity, points, and bounding
 *  rectangles. Can be drawn and updated.
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-18-18
 */
package main;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public abstract class Character 
{
	private int x;
	private int y;
	private int velX;
	private int velY;
	private int points;
	private Rectangle2D bounds;
	
	/** Creates a Character with a given position
	 * @param x the initial x coordinate of the character
	 * @param y the initial y coordinate of the character
	 */
	public Character(int x, int y) 
	{
		this.setX(x);
		this.setY(y);
	}
	
	/** Returns the points the character contains
	 *  @return the points the character contains
	 */
	public int getPoints()
	{
		return points;
	}
	
	/** Sets the points of the character
	 * @param points the new amount of points the character has
	 */
	public void setPoints(int points)
	{
		this.points = points;
	}
	
	/** Adds points to the character
	 *  @param points the points to be added to the character
	 */
	public void addPoints(int points)
	{
		this.points += points;
	}
	
	/** Sets the bounding rectangle of the character
	 *  @param bounds the new bounding rectangle of the character
	 */
	public void setBoundingRectangle(Rectangle2D bounds)
	{
		this.bounds = bounds;
	}

	/** Returns the bounding rectangle of the character
	 *  @return the bounding rectangle of the character
	 */
	public Rectangle2D getBoundingRectangle()
	{
		return bounds;
	}
	
	/** Returns the y velocity
	 *  @return the y velocity
	 */
	public int getVelY() 
	{
		return velY;
	}

	/** Sets the y velocity
	 *  @param velY the new y velocity to set to
	 */
	public void setVelY(int velY) 
	{
		this.velY = velY;
	}

	/** Returns the x velocity
	 *  @return the x velocity
	 */
	public int getVelX() 
	{
		return velX;
	}

	/** Sets the x velocity
	 *  @param velx the new x velocity to set to
	 */
	public void setVelX(int velX) 
	{
		this.velX = velX;
	}

	/** Returns the y coordinate
	 *  @return the y coordinate
	 */
	public int getY() 
	{
		return y;
	}

	/** Sets the y coordinate
	 *  @param y the new y coordinate to set to
	 */
	public void setY(int y) 
	{
		this.y = y;
	}

	/** Returns the x coordinate
	 *  @return the x coordinate
	 */
	public int getX() 
	{
		return x;
	}

	/** Sets the x coordinate
	 *  @param x the new x coordinate to set to
	 */
	public void setX(int x) 
	{
		this.x = x;
	}
	
	/** Updates the character
	 */
	public abstract void update();
	
	/** Draws the character
	 *  @param gr the Graphics2D Object to draw with
	 */
	public abstract void draw(Graphics2D gr);
}
