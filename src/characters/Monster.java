/** 
 *  A monster that follows the player. Can be drawn
 *  and updated.
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-18-18
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

public class Monster extends Character 
{
	private static final int MONSTER_SIZE = 20;
	private static final int UPDATE_DIRECTION_TIME = 100;
	private static final int SPEED = 5;
	private static final String MONSTER_SYMBOL = "©";
	private int timer;
	private Handler handler;
	private int width, height;
	
	/** Creates a monster with a given position and handler
	 *  @param x the initial x coordinate
	 *  @param y the initial y coordinate
	 *  @param handler the handler of all game variables
	 */
	public Monster(int x, int y, Handler handler) 
	{
		super(x, y);
		this.handler = handler;
		timer = 0;
		width = 0;
		height = 0;
	}
	
	/** Updates monster's position in the direction of the player
	 */
	@Override
	public void update() 
	{
		//find the Player1 position and move in the direction of it
		setX(getX() + getVelX());
		setY(getY() + getVelY());
		
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
		
		if(timer == UPDATE_DIRECTION_TIME)
		{
			Player p1 = handler.getPlayer(1);
			if(!(p1.getBoundingRectangle() == null))
			{
				double angle = Math.atan2(p1.getY() - getY(), p1.getX() - getX());
				setVelY((int) (SPEED * Math.sin(angle)));
				setVelX((int) (SPEED * Math.cos(angle)));
			}
			else
			{
				setVelX(0);
				setVelY(0);
			}
			timer = 0;
		}
		timer++;
	}
	
	/** Draws the monster
	 *  @param gr the Graphics2D Object to draw with
	 */
	@Override
	public void draw(Graphics2D gr) 
	{
		gr.setColor(Color.BLACK);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, MONSTER_SIZE);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout layout = new TextLayout(MONSTER_SYMBOL, font, frc);
		layout.draw(gr, getX(), getY());
		
		Rectangle2D bounds = layout.getBounds();
		height = (int) bounds.getHeight();
		width = (int) bounds.getWidth();
	}

}
