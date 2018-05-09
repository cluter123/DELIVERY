/** 
 *  An obstacle in the game with a position
 *  that stops characters. Can be drawn
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-14-18
 */
package main;
import java.awt.Graphics2D;

public abstract class Obstacle 
{
	private Position position;
	
	/** Creates a new obstacle with a given postion
	 *  @param pos initial postion
	 */
	public Obstacle(Position pos) 
	{
		position = pos;
	}
	
	/** Resets position with given position
	 *  @param p new position
	 */
	public void setPosition(Position p)
	{
		position = p;
	}
	
	/** Returns position
	 * @return position of obstacle
	 */
	public Position getPosition()
	{
		return position;
	}
	
	/** Changes position by a given x and y amount 
	 * @param xAmt amount to change x by
	 * @param yAmt amount to change y by
	 */
	public void movePosition(int xAmt, int yAmt)
	{
		position.addX(xAmt);
		position.addY(yAmt);
	}
	
	/** Draws the obstacle
	 *  @param gr the Graphics2D Object to draw with
	 */
	public abstract void draw(Graphics2D gr);

}
