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

	private int width;
	private int height;
	private String platform;

	public Platform(int x, int y, int size) 
	{
		super(x, y);
		this.width = 0;
		this.height = 0;
		platform = "";
		for (int k = 0; k < size; k++)
			platform += "P";
		setBoundingRectangle(new Rectangle(x, y, width, height));
	}

	@Override
	public void draw(Graphics2D gr) 
	{
		gr.setColor(Color.GRAY);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout layout = new TextLayout(platform, font, frc);
		layout.draw(gr, getX(), getY());

		gr.setColor(Color.RED);
		
		Rectangle2D bounds = layout.getBounds();
		height = (int) bounds.getHeight();
		width = (int) bounds.getWidth();
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
		
		gr.draw(getBoundingRectangle());
	}

}
