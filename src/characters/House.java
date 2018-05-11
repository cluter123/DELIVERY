package characters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

import main.Character;

public class House extends Character 
{

	private int width, height;
	private Color hue;
	private String status;
	private static final String CLOSED = "|X|";
	private static final String OPEN = "|O|";
	
	public House(int x, int y, Color color)
	{
		super(x,y);
		hue = color;
		status = OPEN;
		width = 0;
		height = 0;
		setPoints(100);
		setBoundingRectangle(new Rectangle(getX(), getY(), width, height));
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(Graphics2D gr) {
		// TODO Auto-generated method stub
		
		gr.setColor(hue);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout layoutRoof = new TextLayout("/^\\", font, frc);
		TextLayout layoutWalls = new TextLayout(status, font, frc);
		width = (int)layoutRoof.getBounds().getWidth();
		height = (int)layoutRoof.getBounds().getHeight() + (int)layoutWalls.getBounds().getHeight();
		layoutRoof.draw(gr, getX(), getY() - (int)layoutWalls.getBounds().getHeight());
		layoutWalls.draw(gr, getX(), getY());

		gr.setColor(Color.RED);
		
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
		gr.draw(getBoundingRectangle());

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

	public boolean isOpen() 
	{
		if(status.equals(OPEN))
			return true;
		return false;
	}
}
