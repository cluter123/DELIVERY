package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Player extends Character 
{
	
	private int gravityGoingUp = 1;
	private int gravityFalling = 2;
	private int playerHeight;
	private int playerWidth;
	/**Creates a new player
	 * @param x
	 * @param y
	 * @param id
	 */
	public Player(int x, int y, int id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
//		setVelY(-1);
		playerHeight = 30;
		playerWidth = 28;
	}
	
	/* (non-Javadoc)
	 * @see Main.Character#update()
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
//		int oldVelY = getVelY();
//		setVelY(oldVelY + gravity);
		x += velX;
		if(velY > 0)
			velY += gravityFalling;
		else
			velY += gravityGoingUp;
		y += velY;
//		
		// if it hits a side set the position to the max position and
		if(y > (Map.HEIGHT  - playerHeight - 10))
		{
//			System.out.println("bot");
			y = Map.HEIGHT - playerHeight - 10;
			velY = 0;
		}
		if(y < 0)
		{
//			System.out.println("top");
			y = 0;
			velY = 25;
		}
		if(x > (Map.WIDTH - playerWidth))
		{
			x = Map.WIDTH - playerWidth;
			velX = -25;
		}
		if(x < 0)
		{
			x = 0;
			velX = 25;
		}
		System.out.println(x + " " + y);
	}
	
	/* (non-Javadoc)
	 * @see Main.Character#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) 
	{
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 50));

		g.drawString("W", x, y);
		g.setColor(Color.RED);
		g.drawRect(x, y - 30, playerWidth, playerHeight);
	}
}
