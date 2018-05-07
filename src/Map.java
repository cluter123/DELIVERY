import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

public class Map extends Canvas {

	public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9; // magic number
	private boolean running;
	private Handler handler;
	private static LinkedList<Player> playerList;
	
	/**Creates a Map with a collection of all of the characters 
	 * 
	 */
	public Map() 
	{
		// TODO Auto-generated constructor stub
		handler = new Handler();
		running = false;
		setFocusable(true); //I don't know what this method does but it made the code work
		addKeyListener(new KeyInput(handler));
		new MapViewer(WIDTH, HEIGHT, "Game", this);
		playerList = new LinkedList<>();
		//Add objects back to front so less important stuff first and more important stuff last
		//handler.addObject(new Box(0, 0, 2));
		//this will be Player 1 if the ID is 1 it is the player character
		playerList.add(new Player(new Position (WIDTH/2, HEIGHT/2, 28, 30, 2, 2) , 0));
		handler.addObject(playerList.getFirst());
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
	
	public static Player getPlayer(int num)
	{
		return playerList.get(num - 1);
	}

	/**Creates a new Map
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Map();
		System.out.println("CONOR FIX YOUR GITHUB");
	}

}
