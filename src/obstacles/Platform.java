package obstacles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

import main.Obstacle;
import main.Position;

public class Platform extends Obstacle 
{

	public Platform(Position pos) 
	{
		super(pos);
	}

	@Override
	public void draw(Graphics2D gr) 
	{	
		gr.setColor(Color.GRAY);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout layout = new TextLayout("_____", font, frc);
		getPosition().setXLength((int)layout.getBounds().getWidth());
		getPosition().setYHeight((int)layout.getBounds().getHeight());
		layout.draw(gr, (getPosition().getX()), getPosition().getY());

		gr.setColor(Color.RED);
		
		Rectangle2D bounds = layout.getBounds();
		bounds.setRect(bounds.getX()+getPosition().getX(),
                bounds.getY()+getPosition().getY(),
                bounds.getWidth(),
                bounds.getHeight());
		gr.draw(bounds);
	}
}
