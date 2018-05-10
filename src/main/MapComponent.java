package main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import characters.Box;
import characters.Player;
import obstacles.Platform;

public class MapComponent extends Canvas {

	public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9; // magic number 
	private Handler handler;
	
	/**Creates a Map with a collection of all of the characters 
	 * 
	 */
	public MapComponent() 
	{
		handler = new Handler();
		setFocusable(true); //I don't know what this method does but it made the code work
		addKeyListener(new KeyInput(handler));
		new MapViewer(WIDTH, HEIGHT, "Game", this);
		
		//adding characters to the window
		handler.addPlayer(new Player(WIDTH / 2, HEIGHT / 2, handler));
		handler.addCharacter(new Box(WIDTH/2, HEIGHT/2));
		handler.addObstacle(new Platform(new Position(0, HEIGHT / 3, 0, 0)));
	}
	
	/**Calls the handler's update method which updates all of the characters
	 * 
	 */
	public void update()
	{
		handler.update();
	}
	
	/**Creates a bufferStrategy if there is none
	 * each time it is called it creates a new Graphics that draws the graphics
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
		
		Graphics2D gr = (Graphics2D) bs.getDrawGraphics();
		
		// this is where we will draw the background
		gr.setColor(Color.white);
		gr.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.draw(gr);
		
		gr.dispose();
		bs.show();
	}
	

}
