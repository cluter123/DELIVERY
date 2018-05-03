import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;

public class Map extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1285670934175365101L;

	public static final int WIDTH = 1000, HEIGHT = 1000;
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
	public Map() 
	{
		// TODO Auto-generated constructor stub
		handler = new Handler();
		new MapViewer(WIDTH, HEIGHT, "Game", this);
		handler.addObject(new Player(new Position(20, 20, 0, 0), 0));
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public void run()
	{
		while(running)
		{
			update();
			render();
		}
		stop();
	}
	
	private void update()
	{
		handler.update();
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render((Graphics2D)g);
		
		g.dispose();
		bs.show();
	}
	
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

	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Map();
	}

}