/** 
 *  A Platform made up of the letter "P". Can be drawn.
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
import java.awt.geom.Rectangle2D;

import main.Obstacle;

public class Platform extends Obstacle 
{
	public static final String PLATFORM_SYMBOL = "P";
	
	private int width;
	private int height;
	private String platform;
	
	/** Creates a new platform with a given position and size
	 *  @param x the initial x position 
	 *  @param y the initial y position
	 *  @param size the length of the platform
	 */
	public Platform(int x, int y, int size) 
	{
		super(x, y);
		this.width = 0;
		this.height = 0;
		platform = "";
		for (int k = 0; k < size; k++)
			platform += PLATFORM_SYMBOL;
		setBoundingRectangle(new Rectangle(x, y, width, height));
	}
	
	/** Draws the platform
	 *  @param gr the Graphics2D Object to draw with
	 */
	@Override
	public void draw(Graphics2D gr) 
	{
		gr.setColor(Color.GRAY);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout layout = new TextLayout(platform, font, frc);
		layout.draw(gr, getX(), getY());
		
		Rectangle2D bounds = layout.getBounds();
		height = (int) bounds.getHeight();
		width = (int) bounds.getWidth();
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
	}

}
