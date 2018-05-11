package obstacles;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

import main.Obstacle;
import main.Position;

public class WallSegment extends Obstacle {

	private int width, height;
	
	public WallSegment(int x, int y) 
	{
		super(x, y);
		width = 0;
		height = 0;
		setBoundingRectangle(new Rectangle(getX(), getY(), width, height));
	}

	@Override
	public void draw(Graphics2D gr) 
	{
		// TODO Auto-generated method stub
		gr.setColor(Color.GRAY);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout W = new TextLayout("W", font, frc);
		TextLayout A = new TextLayout("A", font, frc);
		TextLayout L = new TextLayout("L", font, frc);
		TextLayout L2 = new TextLayout("L", font, frc);
		width = (int)L2.getBounds().getWidth();
		height = (int)W.getBounds().getHeight() 
				+ (int)A.getBounds().getHeight()
				+ (int)L.getBounds().getHeight()
				+ (int)L2.getBounds().getHeight();
		
		W.draw(gr, getX(), getY() - (int)L2.getBounds().getHeight() - (int)L2.getBounds().getHeight()- (int)L2.getBounds().getHeight());
		A.draw(gr, getX(), getY() - (int)L2.getBounds().getHeight() - (int)L2.getBounds().getHeight());
		L.draw(gr, getX(), getY() - (int)L2.getBounds().getHeight());
		L2.draw(gr, getX(), getY());

		gr.setColor(Color.RED);
		
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
		gr.draw(getBoundingRectangle());
	}

}
