package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MapViewer extends Canvas{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6818686894060817625L;
	private static Timer drawTimer;
	/**Creates a new frame with the given width height and game
	 * @param width
	 * @param height
	 * @param title
	 * @param game
	 */
	public MapViewer(int width, int height, String title, Map game) 
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
		frame.add(game);
		
		//makes it so that we can see it
		frame.setVisible(true);
		
//		//starts the game
//		game.start();
		class AdvanceTimerListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				drawTimer.stop();
				game.update();
				drawTimer.start();
				game.draw();
			}
		}
		
		ActionListener advanceListener = new AdvanceTimerListener();
		
		final int FPS = 60; // Milliseconds between timer ticks
		drawTimer = new Timer(1000/ FPS, advanceListener);
		drawTimer.start();
	}

}