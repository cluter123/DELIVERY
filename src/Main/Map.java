package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Map extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1285670934175365101L;
	public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	
	/**Creates a Map with a collection of all of the characters 
	 * 
	 */
	public Map() 
	{
		// TODO Auto-generated constructor stub
		handler = new Handler();
		this.setFocusable(true); //I don't know what this method does but it made the code work
		this.addKeyListener(new KeyInput(handler));
		new MapViewer(WIDTH, HEIGHT, "Game", this);
		//Add objects back to front so less important stuff first and more important stuff last
		handler.addObject(new Box(0, 0, 2));
		//this will be Player 1 if the ID is 1 it is the player character
		handler.addObject(new Player(WIDTH / 2 ,HEIGHT / 2, 1));
	}
	
	/**Starts the the thread
	 * 
	 */
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		//while the game is running we need to update the characters and draws the game
		while(running)
		{
			update(); 
			draw();
		}
		stop();
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
		
		Graphics g = bs.getDrawGraphics();
		
		// this is where we will draw the background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.draw(g);
		
		g.dispose();
		bs.show();
	}
	
	/**Ends the thread
	 * 
	 */
	public synchronized void stop()
	{
		try
		{
			thread.join();
			running = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	/**Creates a new Map
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Map();
	}

}
