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
import java.awt.geom.Rectangle2D;

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
		Position p = getPosition();
		
		// Gravity
		p.addX(p.getXVelocity());
		
		if (p.getYVelocity() > 0)
			p.addYVelocity(2);
		else
			p.addYVelocity(1);
		
		p.addY(p.getYVelocity());
		
		// Bounds the player within the frame
		if (p.getY() > (MapComponent.HEIGHT  - p.getYHeight()))
		{
			p.setY(MapComponent.HEIGHT - p.getYHeight());
			p.setYVelocity(0);
		}
		if (p.getY() - p.getYHeight() < 0)
		{
			p.setY(p.getYHeight());
			p.setYVelocity(0);
		}
		if (p.getX() + p.getXLength() > (MapComponent.WIDTH))
		{
			p.setX(MapComponent.WIDTH - p.getXLength());
			p.setXVelocity(0);
		}
		if (p.getX() < 0)
		{
			p.setX(0);
			p.setXVelocity(0);
		}
	}
	
	/** Draws the player
	 *  @param gr the Graphics2D Object to draw with
	 */
	@Override
	public void draw(Graphics2D gr) 
	{
		Position p = getPosition();
		
		gr.setColor(Color.black);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout layout = new TextLayout("W", font, frc);
		p.setXLength((int)layout.getBounds().getWidth());
		p.setYHeight((int)layout.getBounds().getHeight());
		layout.draw(gr, (p.getX()), p.getY());

		gr.setColor(Color.RED);
		
		Rectangle2D bounds = layout.getBounds();
		bounds.setRect(bounds.getX()+p.getX(),
                bounds.getY()+p.getY(),
                bounds.getWidth(),
                bounds.getHeight());
		gr.draw(bounds);
		
		gr.setColor(Color.BLUE);
		gr.draw(p.getBoundingReactangle());
	}
	
	/** Returns the player's id
	 *  @return the player's id
	 */
	public int getID()
	{
		return ID;
	}

}
