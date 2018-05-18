/** 
 *  An abstract class for all the obstacles in the game
 *  that stops characters. Can be drawn and position can be updated
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-18-18
 */
package main;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public abstract class Obstacle 
{
	private int x;
	private int y;
	private int velX;
	private int velY;
	private Rectangle2D bounds;
	
	/** Creates a new obstacle with a given position
	 *  @param x the initial x coordinate
	 *  @param y the initial y coordinate
	 */
	public Obstacle(int x, int y) 
	{
		this.setX(x);
		this.setY(y);
	}
	
	/** Sets the bounding rectangle of the obstacle
	 *  @param bounds the new bounding rectangle of the obstacle
	 */
	public void setBoundingRectangle(Rectangle2D bounds)
	{
		this.bounds = bounds;
	}

	/** Returns the bounding rectangle of the obstacle
	 *  @return the bounding rectangle of the obstacle
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
	
	/** Draws the character
	 *  @param gr the Graphics2D Object to draw with
	 */
	public abstract void draw(Graphics2D gr);
}
