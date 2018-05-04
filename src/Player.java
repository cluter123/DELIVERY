import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Player extends Character {

	public Player(Position pos, int initialPoints) {
		super(pos, initialPoints);
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
//		if(velY > 0)
//			velY += gravityFalling;
//		else
//			velY += gravityGoingUp;
		getPosition().addY(getPosition().getYVelocity());
//		
		// if it hits a side set the position to the max position and
		if(getPosition().getY() > (Map.HEIGHT  - getPosition().getYHeight() - 10))
		{
//			System.out.println("bot");
			getPosition().setY(Map.HEIGHT - getPosition().getYHeight() - 10);
			getPosition().setYVelocity(0);
		}
		if(getPosition().getY() < 0)
		{
//			System.out.println("top");
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
		//System.out.println(x + " " + y);
		
	}

}
