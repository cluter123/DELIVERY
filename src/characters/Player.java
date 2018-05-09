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
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

import main.Character;
import main.Handler;
import main.Position;

public class Player extends Character 
{
	private static final int ID = 1;
	Handler handler;
	TextLayout layout;
	
	/** Creates a Player character with an initial position, points, and a unique id
	 *  @param pos the initial position of the player
	 *  @param initialPoints the initial points of the player
	 */
	public Player(Position pos, Handler handle) 
	{
		super(pos);
		this.handler = handle;
		Rectangle2D rect = new Rectangle(0, 0, 0, 0);
		setBoundingRectangle(rect);
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
		
		checkCollisions();
//		// Bounds the player within the frame
//		if (getPosition().getY() > (MapComponent.HEIGHT  - getPosition().getYHeight()))
//		{
//			getPosition().setY(MapComponent.HEIGHT - getPosition().getYHeight());
//			getPosition().setYVelocity(0);
//		}
//		if (getPosition().getY() - getPosition().getYHeight() < 0)
//		{
//			getPosition().setY(getPosition().getYHeight());
//			getPosition().setYVelocity(0);
//		}
//		if (getPosition().getX() + getPosition().getXLength() > (MapComponent.WIDTH))
//		{
//			getPosition().setX(MapComponent.WIDTH - getPosition().getXLength());
//			getPosition().setXVelocity(0);
//		}
//		if (getPosition().getX() < 0)
//		{
//			getPosition().setX(0);
//			getPosition().setXVelocity(0);
//		}
	}

	private void checkCollisions()
	{
		for(Character tempCharacter : handler.characters)
		{
			if(getBoundingRectangle().intersects(tempCharacter.getBoundingRectangle()))
			{
				if(tempCharacter instanceof Box)
				{
					
						((Box)tempCharacter).setFramesTest(0);
				}
			}
		}
	}
	
	@Override
	public void draw(Graphics2D gr) 
	{
		gr.setColor(Color.BLACK);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout layout = new TextLayout("W", font, frc);
		layout.draw(gr, (getPosition().getX()), getPosition().getY());
		
		Rectangle2D bounds = layout.getBounds();
		bounds.setRect(bounds.getX()+getPosition().getX(),
                bounds.getY()+getPosition().getY(),
                bounds.getWidth(),
                bounds.getHeight());
		
		setBoundingRectangle(bounds);
		
		gr.setColor(Color.RED);
		gr.draw(getBoundingRectangle());
	}
	
	/** Returns the player's id
	 *  @return the player's id
	 */
	public int getID()
	{
		return ID;
	}

}
