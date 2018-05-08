/** 
 *  Creates a Player character to be controlled by the user
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-14-18
 */
package characters;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.Character;
import main.MapComponent;
import main.Position;

public class Player extends Character 
{
	
	private static int PLAYER_ID = 1;
	private final int ID;
	
	/** Creates a Player character with an intial position, points, and a unique id
	 *  @param pos the intial position of the player
	 *  @param initialPoints the initial points of the player
	 */
	public Player(Position pos, int initialPoints) 
	{
		super(pos, initialPoints);
		ID = PLAYER_ID++;
	}
	
	/** Draws the player
	 *  @param g the Graphics2D object to draw the player with 
	 */
	@Override
	public void draw(Graphics2D g) 
	{
		g.setColor(Color.black);
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 50));

		g.drawString("W", getPosition().getX(), getPosition().getY());
		g.setColor(Color.RED);
		g.drawRect(getPosition().getX(), getPosition().getY() - 30, getPosition().getXLength(), getPosition().getYHeight());
	}
	
	/** Updates the player's position depending on where it is in the frame
	 */
	@Override
	public void update()
	{
		// Gravity
		getPosition().addX(getPosition().getXVelocity());
		if (getPosition().getYVelocity() > 0)
			getPosition().addYVelocity(2);
		else
			getPosition().addYVelocity(1);
		
		getPosition().addY(getPosition().getYVelocity());
		
		// Bounds the player within the frame
		if (getPosition().getY() > (MapComponent.HEIGHT  - getPosition().getYHeight()))
		{
			getPosition().setY(MapComponent.HEIGHT - getPosition().getYHeight());
			getPosition().setYVelocity(0);
		}
		if (getPosition().getY() < 0)
		{
			getPosition().setY(0);
			getPosition().setYVelocity(0);
		}
		if (getPosition().getX() > (MapComponent.WIDTH - getPosition().getXLength()))
		{
			getPosition().setX(MapComponent.WIDTH - getPosition().getXLength());
			getPosition().setXVelocity(0);
		}
		if (getPosition().getX() < 0)
		{
			getPosition().setX(0);
			getPosition().setXVelocity(0);
		}
	}
	
	/** Returns the player's id
	 *  @return the player's id
	 */
	public int getID()
	{
		return ID;
	}

}
