package main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import characters.Player;

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
		handler.addPlayer(new Player(new Position (WIDTH/2, HEIGHT/2, 28, 30, 2, 2), 0));
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
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		// this is where we will draw the background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.draw(g);
		
		g.dispose();
		bs.show();
	}
	

	/**Creates a new Map
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new MapComponent();
	}

}
