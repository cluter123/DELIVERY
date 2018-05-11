/** 
 *  Creates all game variables like characters and obstacles.
 *  Can update and draw all of them
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-14-18
 */
package main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import characters.Box;
import characters.Player;
import obstacles.Platform;

public class MapComponent extends Canvas 
{
	
	private static final double FRAME_RATIO = .75;
	public static final int WIDTH = 1000;  
	public static final int HEIGHT = (int) (WIDTH * FRAME_RATIO);
	private Handler handler;
	
	/** Creates a Map with a collection of all of the characters 
	 */
	public MapComponent() 
	{
		handler = new Handler();
		setFocusable(true); //I don't know what this method does but it made the code work
		addKeyListener(new KeyInput(handler));
		new MapViewer(WIDTH, HEIGHT, "Game", this);
		handler.addPlayer(new Player(new Position(WIDTH / 2, HEIGHT / 2, 28, 30, 0, 0), 0));
		handler.addCharacter(new Box(new Position(WIDTH / 2, HEIGHT / 2, 28, 30, 2, 2), 0));
		handler.addObstacle(new Platform(new Position(WIDTH / 2, HEIGHT/2, 28, 30, 0, 0)));
		handler.addHouse(new House(new Position(0, HEIGHT / 3, 30, 30, 0, 0), 0, Color.RED));
	}
	
	/** Calls the handler's update method which updates all of the characters
	 * 
	 */
	public void update()
	{
		handler.update();
	}
	
	/** Creates a bufferStrategy if there is none.
	 *  Each time it is called, it creates a new Graphics2D that draws the graphics
	 * 
	 */
	public void draw()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		// this is where we will draw the background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.draw(g);
		
		g.dispose();
		bs.show();
	}
}
