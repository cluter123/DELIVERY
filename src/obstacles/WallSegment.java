/** 
 *  A WallSegment made up of the letter "W". Can be drawn.
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-18-18
 */
package obstacles;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

import main.Obstacle;

public class WallSegment extends Obstacle 
{
	public static final String WALL_SYMBOL = "W";
	
	private int width;
	private int height;
	private int length;
	
	/** Creates a new wall segment with a given position and size
	 *  @param x the initial x position 
	 *  @param y the initial y position
	 *  @param length the length of the platform
	 */
	public WallSegment(int x, int y, int length) 
	{
		super(x, y);
		width = 0;
		height = 0;
		this.length = length;
		setBoundingRectangle(new Rectangle(getX(), getY(), width, height));
	}
	
	/** Draws the wall segment
	 *  @param gr the Graphics2D Object to draw with
	 */
	@Override
	public void draw(Graphics2D gr) 
	{
		gr.setColor(Color.GRAY);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout[] wall = new TextLayout[length];
		for (int k = 0; k < length; k++)
			wall[k] = new TextLayout(WALL_SYMBOL, font, frc);

		width = (int) wall[0].getBounds().getWidth();
		height = (int) (wall[0].getBounds().getHeight() * length); 
		
		for (int k = 0; k < length; k++)
		{
			wall[k].draw(gr, getX(), 
					getY() - ((length - k - 1) * (int) wall[k].getBounds().getHeight()));
		}
		
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
	}

}
