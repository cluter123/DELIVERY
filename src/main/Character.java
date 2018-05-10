/** 
 *  A Character with a given amount of points and a position
 *  Points and position can be updated, and character can be drawn
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-14-18
 */
package main;
import java.awt.Graphics2D;

public abstract class Character 
{
	
	private Position position;
	private int points;
	
	/** Creates a new character with a given position and 
	 *  amount of points
	 *  @param pos initial position
	 *  @param initialPoints initial points
	 */
	public Character(Position pos, int initialPoints) 
	{
		position = pos;
		points = initialPoints;
		
	}
	
	/** Resets position with given position
	 *  @param p new position
	 */
	public void setPosition(Position p)
	{
		position = p;
	}
	
	/** Returns position
	 * @return position of character
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
	
	/** Returns amount of points character owns
	 *  @return points character owns 
	 */
	public int getPoints()
	{
		return points;
	}
	
	/** Updates character's position
	 */
	public abstract void update();
	
	/** Draws the player
	 *  @param gr the Graphics2D Object to draw with
	 */
	public abstract void draw(Graphics2D gr);
	

}
