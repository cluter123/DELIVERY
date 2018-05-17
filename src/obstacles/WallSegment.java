package obstacles;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

import main.Obstacle;

public class WallSegment extends Obstacle {

	private int width;
	private int height;
	private int length;
	public static final String WALL_SYMBOL = "W";
	
	public WallSegment(int x, int y, int length) 
	{
		super(x, y);
		width = 0;
		height = 0;
		this.length = length;
		setBoundingRectangle(new Rectangle(getX(), getY(), width, height));
	}

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
			wall[k].draw(gr, getX(), getY() - ((length - k - 1) * (int) wall[k].getBounds().getHeight()));
		}

		gr.setColor(Color.RED);
		
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
		gr.draw(getBoundingRectangle());
	}

}
