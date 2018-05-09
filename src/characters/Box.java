package characters;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

import main.Character;
import main.MapComponent;
import main.Position;

public class Box extends Character {

	private int framesTest;

	public Box(Position pos) {
		super(pos);
		framesTest = 0;
		Rectangle2D rect = new Rectangle(0, 0, 0, 0);
		setBoundingRectangle(rect);
	}

	@Override
	public void update() 
	{
		getPosition().addX(getPosition().getXVelocity());
		getPosition().addY(getPosition().getYVelocity());
		
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
		layout.draw(gr, (getPosition().getX()), getPosition().getY());
		
		//better code just make bounding rectangle this one
		gr.setColor(Color.RED);
		Rectangle2D bounds = layout.getBounds();
		bounds.setRect(bounds.getX()+getPosition().getX(),
                bounds.getY()+getPosition().getY(),
                bounds.getWidth(),
                bounds.getHeight());
		gr.draw(bounds);
		
		//sets the bounding rectangle to the rectangle
		setBoundingRectangle(bounds);
	}

	public void setFramesTest(int frame)
	{
		framesTest = frame;
	}
}
