import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

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
		getPosition().addY(getPosition().getYVelocity());
		if(getPosition().getY() > (Map.HEIGHT  - getPosition().getYHeight() - 10))
		{
			getPosition().setY(Map.HEIGHT - getPosition().getYHeight() - 10);
			getPosition().setYVelocity(0);
		}
		if(getPosition().getY() < 0)
		{
			getPosition().setY(0);
			getPosition().setYVelocity(25);
		}
		if(getPosition().getX() > (Map.WIDTH - getPosition().getXLength()))
		{
			getPosition().setX(Map.WIDTH - getPosition().getXLength());
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
