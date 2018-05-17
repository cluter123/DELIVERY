/** 
a *  Displays and continuously updates the game
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-14-18
 */
package main;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MapViewer extends Canvas
{
	private static Timer drawTimer;
	public static final double FRAME_RATIO = .75;
	public static final int WIDTH = 1000;  
	public static final int HEIGHT = (int) (WIDTH * FRAME_RATIO);
	
	/** Creates a new Map
	 */
	public static void main(String[] args) 
	{
		new MapViewer(WIDTH, HEIGHT, "Game", new MapComponent());
	}
	
	/**Creates a new frame with the given width height and game
	 * @param width the width of the frame
	 * @param height the height of the frame
	 * @param title the name of the game
	 * @param map the map component containing and controlling the game's variables
	 */
	public MapViewer(int width, int height, String title, MapComponent map) 
	{
		JFrame frame = new JFrame(title);
		
		//makes a new frame with all of the given dimension
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		//makes sure that it closes when we want it to
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//can't change the size of the frame
		frame.setResizable(false);
		
		//starts at the center of the screen 
		//(because its the most important thing that is happening)
		frame.setLocationRelativeTo(null);
		
		//adds the game to the frame
		frame.add(map);
		
		//makes it so that we can see it
		frame.setVisible(true);
		
		/** Class comment here
		 * 
		 */
		class AdvanceTimerListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				drawTimer.stop();
				map.update();
				drawTimer.start();
				map.draw();
			}
		}
		
		ActionListener advanceListener = new AdvanceTimerListener();
		
		final int FPS = 60; // this is the fps
		drawTimer = new Timer(1000 / FPS, advanceListener);
		drawTimer.start();
	}
}
