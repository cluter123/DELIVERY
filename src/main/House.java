
package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;

public class House 
{
	private Position position;
	private int points;
	private Color hue;
	private String status;
	private Rectangle2D bounds;
	private static final String CLOSED = "|X|";
	private static final String OPEN = "|O|";
	
	public House(Position pos, int initialPoints, Color color)
	{
		position = pos;
		points = initialPoints;
		hue = color;
		status = CLOSED;
		bounds = null;
	}
	
	/** Returns position
	 * @return position of house
	 */
	public Position getPosition()
	{
		return position;
	}
	
	/** Returns amount of points house owns
	 *  @return points house owns 
	 */
	public int getPoints()
	{
		return points;
	}
	
	/** Returns color of house
	 *  @return color of house 
	 */
	public Color getColor()
	{
		return hue;
	}
	
	/** Draws the house
	 *  @param gr the Graphics2D Object to draw with
	 */
	public void draw(Graphics2D gr) 
	{
		Position p = getPosition();
		
		gr.setColor(hue);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout layoutRoof = new TextLayout("/^\\", font, frc);
		TextLayout layoutWalls = new TextLayout(status, font, frc);
		p.setXLength((int)layoutRoof.getBounds().getWidth());
		p.setYHeight((int)layoutRoof.getBounds().getHeight() + (int)layoutWalls.getBounds().getHeight());
		layoutRoof.draw(gr, p.getX(), p.getY() - (int)layoutWalls.getBounds().getHeight());
		layoutWalls.draw(gr, p.getX(), p.getY());

		gr.setColor(Color.RED);
		
		bounds = new Rectangle(p.getX(), p.getY() - p.getYHeight(), p.getXLength(), p.getYHeight());
		gr.draw(bounds);
	}
	
	/** Changes status of house
	 */
	public void update()
	{
		if (isOpen())
			status = CLOSED;
		else
			status = OPEN;
	}
	
	/** Returns bounding rectangle
	 *  @return the house's bounding rectangle
	 */
	public Rectangle2D getBoundingRectangle()
	{
		return bounds;
	}
	
	/** Closes house
	 */
	public void close()
	{
		status = CLOSED;
	}
	
	/** Opens house
	 */
	public void open()
	{
		status = OPEN;
	}
	
	/** Returns status of house
	 * @return true is open, false if else
	 */
	public boolean isOpen()
	{
		if (status.equals(OPEN)) 
		{
			return true;
		}
		return false;
	}
	
	
	
}
