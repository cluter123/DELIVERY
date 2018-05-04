package Main;

import java.awt.Graphics;

public abstract class Character {

	protected int x,y;
	protected int id;
	protected int velX;
	protected int velY;
	
	/**Creates the Character given the x and y values and determines the 
	 * @param x the initial x coordinate of the the character
	 * @param y the initial y coordinate of the the character
	 * @param id the type of character that has been created
	 */
	public Character(int x, int y, int id)
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}

	/**Time moves forward and instance variables change. This is where the change 
	 * happens.
	 */
	public abstract void update();
	
	/**This draws the character when it is called
	 * @param g the graphics that will be drawing the character
	 */
	public abstract void draw(Graphics g);
	
	/**Changes the x value of the Character
	 * @param x
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**Changes the y value of the Character
	 * @param y
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**Gets the x value of the Character
	 * @return
	 */
	public int getX()
	{
		return x;
	}
	
	/**Gets the y value of the Character
	 * @return
	 */
	public int getY()
	{
		return y;
	}
	
	/**This will probably be deleted soon
	 * @param id
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	/**This will probably be deleted soon
	 * @return
	 */
	public int getId()
	{
		return id;
	}
	
	/**Changes the velX
	 * @param velX
	 */
	public void setVelX(int velX)
	{
		this.velX = velX;
	}
	
	/**Changes the velY
	 * @param velY
	 */
	public void setVelY(int velY)
	{
		this.velY = velY;
	}
	
	/**Gets the velX
	 * @return
	 */
	public int getVelX()
	{
		return velX;
	}
	
	/**Gets the velY
	 * @return
	 */
	public int getVelY()
	{
		return velY;
	}
	
}
