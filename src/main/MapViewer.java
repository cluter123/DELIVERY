/** 
 *  A MapViewer that creates the frame for the game.
 *  Displays and continuously updates the game
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-18-18
 */
package main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MapViewer extends Canvas
{
	public static final double FRAME_RATIO = .75;
	public static final int WIDTH = 1000;  
	public static final int HEIGHT = (int) (WIDTH * FRAME_RATIO);
	
	private static Timer drawTimer;
	
	/** Creates a new Map
	 */
	public static void main(String[] args) 
	{
		new MapViewer(WIDTH, HEIGHT, "Delivery Delivery : Special Delivery", 
				new MapComponent());
	}
	
	/** Creates a new frame with the given width, height, and game
	 *  @param width the width of the frame
	 *  @param height the height of the frame
	 *  @param title the name of the game
	 *  @param map the map component containing and controlling the game's variables
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
		frame.setLocationRelativeTo(null);
		
		//adds the game to the frame
		frame.add(map);
		
		//makes it so that we can see it
		frame.setVisible(true);
		
		//tutorial
		JOptionPane.showOptionDialog(null, 
				"Use W, A, D, Space, or arrow keys to move. Hold jump for an extra boost!", 
				"Tutorial", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				new String[]{"Start!"}, null);
		
		/** An advance timer listener that updates and draws the map
		 *  based on a timer
		 */
		class AdvanceTimerListener implements ActionListener
		{
			/** Updates and draws the map when the timer moves
			 *  @param e the action of the timer moving
			 */
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
