/**
 *  A house with a given position and color. Can open,
 *  close, be drawn, and be updated.
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

import main.Character;
import main.MapViewer;

public class House extends Character 
{
	public static final int HOUSE_POINTS = 100;
	public static final String ROOF = "/^\\";
	public static final String CLOSED = "|X|";
	public static final String OPEN = "|O|";
	
	private static int identity = 1;
	private int width; 
	private int height;
	private Color hue;
	private String status;
	private int id;

	/**
	 *  Creates a house with a given x and y coordinates
	 *  and a color
	 *  @param x initial x coordinate
	 *  @param y initial y coordinate
	 *  @param color the color of the house 
	 */
	public House(int x, int y, Color color)
	{
		super(x,y);
		hue = color;
		width = 0;
		height = 0;
		id = identity++;
		status = CLOSED;
		setPoints(HOUSE_POINTS);
		setBoundingRectangle(new Rectangle(getX(), getY(), width, height));
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
	 *  @return true if open, false if else
	 */
	public boolean isOpen() 
	{
		if(status.equals(OPEN))
			return true;
		return false;
	}
	
	/** Returns whether the id of the house is odd or even
	 *  @return true is odd, false if else
	 */
	public boolean isOdd()
	{
		if (id % 2 == 0)
			return false;
		return true;
	}
	
	/** Updates house's position
	 */
	@Override
	public void update() 
	{
		if (!isOdd())
			setX(MapViewer.WIDTH - width);
		setY(MapViewer.HEIGHT /  5);
	}
	
	/** Draws the house
	 *  @param gr the Graphics2D Object to draw with
	 */
	@Override
	public void draw(Graphics2D gr) 
	{
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout layoutRoof = new TextLayout(ROOF, font, frc);
		TextLayout layoutWalls = new TextLayout(status, font, frc);
		width = (int)layoutRoof.getBounds().getWidth() + 15;
		height = (int)layoutRoof.getBounds().getHeight() + (int)layoutWalls.getBounds().getHeight();
		
		gr.setColor(hue);
		layoutRoof.draw(gr, getX(), getY() - (int)layoutWalls.getBounds().getHeight());
		layoutWalls.draw(gr, getX(), getY());

		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
	}
}
