package characters;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

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
		if(getPosition().getY() < 0)
		{
			getPosition().setY(0);
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
	public void draw(Graphics2D gr) {
		// TODO Auto-generated method stub
		gr.setColor(Color.black);
		gr.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 50));

		String s = "" + framesTest;
		gr.drawString(s, getPosition().getX(), getPosition().getY());
		
	}

}
