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
import main.MapViewer;
import main.Obstacle;
import main.Position;
import obstacles.Platform;

public class Player extends Character 
{
	private static final int ID = 1;
	private int height;
	private int width;
	private boolean hasLetter;
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
		hasLetter = false;
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
		// if it falls off the bottom it is no longer alive
		if(getY() - height > MapViewer.HEIGHT)
			alive = false;
		boolean needLetter = false;
		
		for(Character tempCharacter : handler.getCharacters())
		{
			if(getBoundingRectangle().intersects(tempCharacter.getBoundingRectangle()))
			{
				// what happens when it hits the box
				if(tempCharacter instanceof Box)
				{
					//code that would happen if you hit something
					
					((Box)tempCharacter).setFramesTest(0);
				}
				// what happens when it hits the monster
				if(tempCharacter instanceof Monster)
				{
					alive = false;
				}
				// what happens when it hits the house 
				if(tempCharacter instanceof House)
				{
					if(((House)tempCharacter).isOpen() && hasLetter)
					{
						addPoints(tempCharacter.getPoints());
						((House)tempCharacter).close();
						hasLetter = false;
						needLetter = true;
					}
				}
				if(tempCharacter instanceof Letter)
				{
					handler.removeCharacter(tempCharacter);
					addPoints(tempCharacter.getPoints());
					hasLetter = true;
					Letter l = (Letter)tempCharacter;
					for (House house : handler.getHouses())
					{
						if ((house.isOdd() && l.isOdd()) || (!house.isOdd() && !l.isOdd()))
							house.open();
					}
				}
			}
		}
		
		if (needLetter && Letter.getOrder() < Letter.ABC_ARRAY.length)
		{
			int randX = (int) (Math.random() * (MapViewer.WIDTH - 30));
			int randY = (int) (Math.random() * (MapViewer.HEIGHT / 2)) + 30;
			handler.addCharacter(new Letter(randX, randY));
		}
			
		for(Obstacle tempObstacle : handler.getObstacles())
		{
			if(getBoundingRectangle().intersects(tempObstacle.getBoundingRectangle()))
				obstacleHit(tempObstacle);
		}
	}
	
	/** Stops player when it hits an obstacle
	 *  @param o the obstacle that was hit
	 */
	private void obstacleHit(Obstacle o)
	{
		// when it hits the platform
		if(o instanceof Platform)
		{
			//code that would happen if you hit something
			// if it is under the platform
			if(getVelY() > 0)
			{
				setVelY(0);
				setY((int) (o.getY() - o.getBoundingRectangle().getHeight()));
				setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
			}
			// if it is over the platform
			if(getVelY() < 0)
			{
				setVelY(0);
				setY((int) (o.getY() + o.getBoundingRectangle().getHeight()));
				setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
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
			gr.setColor(Color.BLACK);
			gr.fillRect(0, 0, MapViewer.WIDTH, MapViewer.HEIGHT);
			gr.setColor(Color.RED);
			gr.drawString("GAME OVER", MapViewer.WIDTH / 2, MapViewer.HEIGHT / 2);
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
