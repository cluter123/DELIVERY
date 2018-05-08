package characters;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

import main.Character;
import main.MapComponent;
import main.Position;

public class Box extends Character {

	int framesTest;

	public Box(Position pos, int initialPoints) {
		super(pos, initialPoints);
		framesTest = 0;
	}

	@Override
	public void update() 
	{
		getPosition().addX(getPosition().getXVelocity());
		getPosition().addY(getPosition().getYVelocity());
		
		if(getPosition().getY() > (MapComponent.HEIGHT  - getPosition().getYHeight()))
		{
			getPosition().setY(MapComponent.HEIGHT - getPosition().getYHeight());
			getPosition().setYVelocity(-1);
		}
		if (getPosition().getY() - getPosition().getYHeight() < 0)
		{
			getPosition().setY(getPosition().getYHeight());
			getPosition().setYVelocity(1);
		}
		if(getPosition().getX() > (MapComponent.WIDTH - getPosition().getXLength()))
		{
			getPosition().setX(MapComponent.WIDTH - getPosition().getXLength());
			getPosition().setXVelocity(-1);
		}
		if(getPosition().getX() < 0)
		{
			getPosition().setX(0);
			getPosition().setXVelocity(1);
		}
		framesTest++;
	}

	@Override
	public void draw(Graphics2D gr) 
	{
		// delete after everyone recognizes the superior code
		gr.setColor(Color.BLACK);
		gr.drawString("Red: Conor's code that he copied from the internet" , 0, MapComponent.HEIGHT / 2);
		
		gr.setColor(Color.black);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = gr.getFontRenderContext();
		String s = "T: " + framesTest / 60;
		TextLayout layout = new TextLayout(s, font, frc);
		getPosition().setXLength((int)layout.getBounds().getWidth());
		getPosition().setYHeight((int)layout.getBounds().getHeight());
		layout.draw(gr, (getPosition().getX()), getPosition().getY());
		
		//better code just make bounding rectangle this one
		gr.setColor(Color.RED);
		Rectangle2D bounds = layout.getBounds();
		bounds.setRect(bounds.getX()+getPosition().getX(),
                bounds.getY()+getPosition().getY(),
                bounds.getWidth(),
                bounds.getHeight());
		gr.draw(bounds);
		
		// lesser code
		gr.setColor(Color.BLUE);
		gr.draw(getPosition().getBoundingReactangle());
	}

}
