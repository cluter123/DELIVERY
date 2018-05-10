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
import main.Obstacle;
import main.Position;
import obstacles.Platform;

public class Player extends Character 
{
	private static final int ID = 1;
	private int height = 31;
	private int width = 30;
	Handler handler;
	TextLayout layout;
	
	/** Creates a Player character with an initial position, points, and a unique id
	 *  @param pos the initial position of the player
	 *  @param initialPoints the initial points of the player
	 */
	public Player(int x, int y, Handler handle) 
	{
		super(x, y);
		this.handler = handle;
	}
	/** Updates the player's position depending on where it is in the frame
	 */
	@Override
	public void update()
	{
		// Gravity
		x += velX;
		
		if (velY > 0)
			velY += 2;
		else
			velY += 1;
		
		y += velY;
		
		setBoundingRectangle(new Rectangle(x, y - height, width, height));
		checkCollisions();
		
		//Needs to be removed because all computers make different windows for some reason
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
					//code that would happen if you hit something
					((Box)tempCharacter).setFramesTest(0);
				}
			}
		}
		for(Obstacle tempObstacle : handler.obstacles)
		{
			if(getBoundingRectangle().intersects(tempObstacle.getBoundingRectangle()))
			{
				if(tempObstacle instanceof Platform)
				{
					System.out.println("Hit a Platform!");
					//code that would happen if you hit something
					if(velY > 0)
					{
						System.out.println("Changed Velocity");
						velY = 0;
						y = (tempObstacle.getPosition().getY());
						setBoundingRectangle(new Rectangle(x, y - height, width, height));
					}
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
		layout.draw(gr, x, y);
		
		Rectangle2D bounds = layout.getBounds();
		
		height = (int) bounds.getHeight();
		width = (int) bounds.getWidth();
		
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
