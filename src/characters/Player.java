package characters;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.Character;
import main.MapComponent;
import main.Position;

public class Player extends Character {
	
	private static int PLAYER_ID = 1;
	private final int ID;

	public Player(Position pos, int initialPoints) {
		super(pos, initialPoints);
		ID = PLAYER_ID++;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 50));

		g.drawString("W", getPosition().getX(), getPosition().getY());
		g.setColor(Color.RED);
		g.drawRect(getPosition().getX(), getPosition().getY() - 30, getPosition().getXLength(), getPosition().getYHeight());
		
	}

	@Override
	public void update() {
		getPosition().addX(getPosition().getXVelocity());
		if(getPosition().getYVelocity() > 0)
			getPosition().addYVelocity(2);
		else
			getPosition().addYVelocity(1);
		
		getPosition().addY(getPosition().getYVelocity());
		
		if(getPosition().getY() > (MapComponent.HEIGHT  - getPosition().getYHeight() - 10))
		{
			getPosition().setY(MapComponent.HEIGHT - getPosition().getYHeight() - 10);
			getPosition().setYVelocity(0);
		}
		if(getPosition().getY() < 0)
		{
			getPosition().setY(0);
			getPosition().setYVelocity(25);
		}
		if(getPosition().getX() > (MapComponent.WIDTH - getPosition().getXLength()))
		{
			getPosition().setX(MapComponent.WIDTH - getPosition().getXLength());
			getPosition().setXVelocity(-25);
		}
		if(getPosition().getX() < 0)
		{
			getPosition().setX(0);
			getPosition().setXVelocity(25);
		}
		
	}
	
	public int getID()
	{
		return ID;
	}

}
