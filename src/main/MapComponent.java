package main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import characters.Box;
import characters.House;
import characters.Letter;
import characters.Monster;
import characters.Player;
import obstacles.Platform;
import obstacles.WallSegment;

public class MapComponent extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 582455343476691375L;
	
	private Handler handler;
	
	/**Creates a Map with a collection of all of the characters 
	 * 
	 */
	public MapComponent() 
	{
		handler = new Handler();
		setFocusable(true); //I don't know what this method does but it made the code work
		addKeyListener(new KeyInput(handler));
		
		//adding characters to the window
		handler.addPlayer(new Player(MapViewer.WIDTH / 2, MapViewer.HEIGHT / 2, handler));
//		handler.addCharacter(new Box(MapViewer.WIDTH/2, MapViewer.HEIGHT/2));
		for(int k = 0; k < 4; k++)
			handler.addObstacle(new Platform(MapViewer.WIDTH * k / 4, MapViewer.HEIGHT * 3 / 4, 8));
		
		handler.addCharacter(new House(0, MapViewer.HEIGHT /  2, Color.RED));
		handler.addCharacter(new House(MapViewer.WIDTH * 3 / 4, MapViewer.HEIGHT /  2, Color.BLUE));
		handler.addCharacter(new Letter(MapViewer.WIDTH / 4, MapViewer.HEIGHT /  2));
		handler.addCharacter(new Monster(0, 0, handler));
		handler.addObstacle(new WallSegment(MapViewer.WIDTH / 2, MapViewer.HEIGHT /  2));
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
		gr.fillRect(0, 0, MapViewer.WIDTH, MapViewer.HEIGHT);
		
		handler.draw(gr);
		
		gr.dispose();
		bs.show();
	}
	

}
