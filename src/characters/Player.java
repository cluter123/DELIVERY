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
	private int height;
	private int width;
	private boolean alive;
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
		alive = true;
	}
	/** Updates the player's position depending on where it is in the frame
	 */
	@Override
	public void update()
	{
		// Gravity
		if(alive)
		{
			setX(getX() + getVelX());
			
			if (getVelY() > 0)
				setVelY(getVelY() + 2);
			else
				setVelY(getVelY() + 1);
			
			setY(getY() + getVelY());
			
			setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
			checkCollisions();
		}
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
					setPoints(getPoints() + ((Box)tempCharacter).getFramesTest());
					((Box)tempCharacter).setFramesTest(0);
				}
				if(tempCharacter instanceof Monster)
				{
					alive = false;
				}
			}
		}
	
		for(Obstacle tempObstacle : handler.obstacles)
		{
			if(getBoundingRectangle().intersects(tempObstacle.getBoundingRectangle()))
			{
				if(tempObstacle instanceof Platform)
				{
					//code that would happen if you hit something
					if(getVelY() > 0)
					{
						setVelY(0);
						setY((int) (tempObstacle.getY() - tempObstacle.getBoundingRectangle().getHeight()));
						setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
					}
					if(getVelY() < 0)
					{
						setVelY(0);
						setY((int) (tempObstacle.getY() + tempObstacle.getBoundingRectangle().getHeight()));
						setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
					}
				}
			}
		}
	}
	
	@Override
	public void draw(Graphics2D gr) 
	{
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		gr.setFont(font);
		
		if(alive)
		{
			gr.setColor(Color.BLACK);
			FontRenderContext frc = gr.getFontRenderContext();
			TextLayout layout = new TextLayout("W", font, frc);
			layout.draw(gr, getX(), getY());
			gr.drawString("Points: " + getPoints(), 0, 35);
			Rectangle2D bounds = layout.getBounds();

			height = (int) bounds.getHeight();
			width = (int) bounds.getWidth();

			gr.setColor(Color.GREEN);
			gr.draw(getBoundingRectangle());
		}
		else
		{
			gr.setColor(Color.RED);
			gr.drawString("GAME OVER", 500, 500);
			setBoundingRectangle(null);
		}
		gr.drawString("Points: " + getPoints(), 0, 35);
	}
	
	/** Returns the player's id
	 *  @return the player's id
	 */
	public int getID()
	{
		return ID;
	}

}
