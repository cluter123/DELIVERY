/** 
 *  Position class maintains where in the game's frame an object is.
 *  Maintains x and y coordinates, an object's bounding box dimensions,
 *  and the object's x and y velocities. All factors are updatable.
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-14-18
 */
package main;
import java.awt.Rectangle;

public class Position {
	
	private int xPos;
	private int yPos;
	private int length;
	private int height;
	private int xVel;
	private int yVel;
	
	/**
	 * Creates a new position from given x, y, length, height, and velocities
	 * @param xPosition initial x coordinate
	 * @param yPosition initial y coordinate
	 * @param xLength the horizontal length of the object
	 * @param yHeight the vertical height of the object
	 * @param xVelocity initial x velocity
	 * @param yVelocity initial y velocity
	 */
	public Position(int xPosition, int yPosition, int xLength, int yHeight, int xVelocity, int yVelocity) {
		xPos = xPosition;
		yPos = yPosition;
		length = xLength;
		height = yHeight;
		xVel = xVelocity;
		yVel = yVelocity;
	}
	
	/** Returns x coordinate
	 * @return the x coordinate
	 */
	public int getX()
	{
		return xPos;
	}
	
	/** Returns y coordinate
	 * @return the y coordinate
	 */
	public int getY()
	{
		return yPos;
	}
	
	/** Returns object's bounding box length
	 * @return the object's bounding box length
	 */
	public int getXLength()
	{
		return length;
	}
	
	/** Returns object's bounding box height
	 * @return the object's bounding box height
	 */
	public int getYHeight()
	{
		return height;
	}
	
	/** Sets the x coordinate
	 *  @param x the new x coordinate
	 */
	public void setX(int x)
	{
		xPos = x;
	}

	/** Sets the y coordinate
	 *  @param y the new y coordinate
	 */
	public void setY(int y)
	{
		yPos = y;
	}
	
	/** Sets the bounding box length
	 *  @param xLength the new bounding box length
	 */
	public void setXLength(int xLength)
	{
		length = xLength;
	}

	/** Sets the bounding box height
	 *  @param yHeight the new bounding box height
	 */
	public void setYHeight(int yHeight)
	{
		height = yHeight;
	}
	
	/** Adds to the x coordinate a given amount
	 * @param x the amount to add
	 */
	public void addX(int x)
	{
		xPos += x;
	}
	
	/** Adds to the y coordinate a given amount
	 * @param y the amount to add
	 */
	public void addY(int y)
	{
		yPos += y;
	}

	/** Adds to the bounding box length a given amount
	 * @param xLength the amount to add
	 */
	public void addXLength(int xLength)
	{
		length += xLength;
	}

	/** Adds to the bounding box height a given amount
	 * @param yHeight the amount to add
	 */
	public void addYHeight(int yHeight)
	{
		height += yHeight;
	}
	
	/** Returns the x velocity
	 * @return the x velocity
	 */
	public int getXVelocity()
	{
		return xVel;
	}

	/** Returns the y velocity
	 * @return the y velocity
	 */
	public int getYVelocity()
	{
		return yVel;
	}
	
	/** Sets the x velocity
	 *  @param xVelocity the new x velocity
	 */
	public void setXVelocity(int xVelocity)
	{
		xVel = xVelocity;
	}
	
	/** Sets the y velocity
	 *  @param yVelocity the new y velocity
	 */
	public void setYVelocity(int yVelocity)
	{
		yVel = yVelocity;
	}
	
	/** Adds to the x velocity a given amount
	 * @param xVelocity the amount to add
	 */
	public void addXVelocity(int xVelocity)
	{
		xVel += xVelocity;
	}

	/** Adds to the y velocity a given amount
	 * @param yVelocity the amount to add
	 */
	public void addYVelocity(int yVelocity)
	{
		yVel += yVelocity;
	}
	
	/** Returns the position's bounding rectangle
	 * @return the position's bounding rectangle
	 */
	public Rectangle getBoundingReactangle()
	{
		// this has been changed for strings that draw from bottom left
		return new Rectangle(xPos, yPos - height, length, height);
	}
}
