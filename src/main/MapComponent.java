/** 
 *  Creates all game variables like characters and obstacles.
 *  Can update and draw all of them
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-18-18
 */
package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import characters.Timer;
import characters.House;
import characters.Letter;
import characters.Monster;
import characters.Player;
import obstacles.Platform;

public class MapComponent extends Canvas 
{	
	private Handler handler;
	
	/** Creates a MapComponent and adds all the game variables 
	 */
	public MapComponent() 
	{
		handler = new Handler();
		setFocusable(true);
		addKeyListener(new KeyInput(handler));
		
		//adding characters to the window
		handler.addPlayer(new Player(MapViewer.WIDTH / 2, MapViewer.HEIGHT / 2, handler));
		handler.addTimer(new Timer(MapViewer.WIDTH, 0));

		handler.addObstacle(new Platform(0, MapViewer.HEIGHT * 24 / 25, 34));
		handler.addObstacle(new Platform(0, MapViewer.HEIGHT * 1 / 4, 3));
		handler.addObstacle(new Platform(MapViewer.WIDTH * 30 / 33, MapViewer.HEIGHT * 1 / 4, 3));
		
		handler.addObstacle(new Platform(MapViewer.WIDTH * 3 / 8, MapViewer.HEIGHT * 3 / 4, 8));
		handler.addObstacle(new Platform(MapViewer.WIDTH * 1 / 8, MapViewer.HEIGHT * 1 / 2, 8));
		handler.addObstacle(new Platform(MapViewer.WIDTH * 5 / 8, MapViewer.HEIGHT * 1 / 2, 8));
		handler.addObstacle(new Platform(MapViewer.WIDTH * 3 / 8, MapViewer.HEIGHT * 1 / 4, 8));
		
		handler.addCharacter(new House(0, 0, Color.RED));
		handler.addCharacter(new House(0, 0, Color.BLUE));
		
		handler.addCharacter(new Letter(MapViewer.WIDTH / 4, MapViewer.HEIGHT * 3 / 4));
		handler.addCoin();
		
		handler.addCharacter(new Monster(0, 0, handler));
		
//		handler.addObstacle(new WallSegment(MapViewer.WIDTH / 2, MapViewer.HEIGHT * 23 / 25, 8));
	}
	
	/** Calls the handler's update method which updates all of the characters
	 */
	public void update()
	{
		handler.update();
	}
	
	/** Creates a bufferStrategy if there is none
	 *  each time it is called it creates a new Graphics that draws the graphics
	 */
	public void draw()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics2D gr = (Graphics2D) bs.getDrawGraphics();
		
		// this is where we will draw the background
		gr.setColor(Color.white);
		gr.fillRect(0, 0, MapViewer.WIDTH, MapViewer.HEIGHT);
		
		handler.draw(gr);
		
		gr.dispose();
		bs.show();
	}
}
