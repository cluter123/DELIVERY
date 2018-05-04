/**
 * 
 */
package Main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Conor Mai
 *
 */
public class Box extends Character {

	private Integer timesUpdated;
	/**
	 * @param x
	 * @param y
	 * @param id
	 */
	public Box(int x, int y, int id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		velX = 1;
		velY = 1;
		timesUpdated = 0;
	}

	/* (non-Javadoc)
	 * @see Main.Character#update()
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		if(y > Map.HEIGHT)
		{
//			System.out.println("bot");
			y = Map.HEIGHT;
			velY = -1;
		}
		if(y < 0)
		{
//			System.out.println("top");
			y = 0;
			velY = 1;
		}
		if(x > Map.WIDTH)
		{
			x = Map.WIDTH;
			velX = -1;
		}
		if(x < 0)
		{
			x = 0;
			velX = 1;
		}
		timesUpdated++;
	}

	/* (non-Javadoc)
	 * @see Main.Character#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.fillRect(x, y, 25, 25);
		g.setColor(Color.black);
		g.drawString(timesUpdated.toString(), x, y);
	}

}
