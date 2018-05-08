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
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

import main.Character;
import main.MapComponent;
import main.Position;

public class Player extends Character 
{
	
	private static int PLAYER_ID = 1;
	private final int ID;
	
	/** Creates a Player character with an initial position, points, and a unique id
	 *  @param pos the initial position of the player
	 *  @param initialPoints the initial points of the player
	 */
	public Player(Position pos, int initialPoints) 
	{
		super(pos, initialPoints);
		ID = PLAYER_ID++;
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

	@Override
	public void draw(Graphics2D g) 
	{
		g.setColor(Color.black);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = g.getFontRenderContext();
		TextLayout layout = new TextLayout("W", font, frc);
		getPosition().setXLength((int)layout.getBounds().getWidth());
		getPosition().setYHeight((int)layout.getBounds().getHeight());
		layout.draw(g, (getPosition().getX()), getPosition().getY());

		g.setColor(Color.BLUE);
		g.draw(getPosition().getBoundingReactangle());
	}
	
	/** Returns the player's id
	 *  @return the player's id
	 */
	public int getID()
	{
		return ID;
	}

}
