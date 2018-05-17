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
	
	@Override
	public void update() 
	{
		if (!isOdd())
			setX(MapViewer.WIDTH - width);
		setY(MapViewer.HEIGHT /  5);
	}

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

		gr.setColor(Color.RED);
		
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
//		gr.draw(getBoundingRectangle());
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
	 * @return true if open, false if else
	 */
	public boolean isOpen() 
	{
		if(status.equals(OPEN))
			return true;
		return false;
	}
	
	public boolean isOdd()
	{
		if (id % 2 == 0)
			return false;
		return true;
	}
}
