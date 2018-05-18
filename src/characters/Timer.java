/**
 *  A Timer that runs based off the game's frame rate.
 *  Can be drawn and updated. Can set and return frame rate test
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-18-18
 */
package characters;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

import main.Character;
import main.MapViewer;

public class Timer extends Character 
{
	private int framesTest;
	private int height;
	private int width;
	
	/** Creates a new Timer with a given position
	 * @param x the initial x position
	 * @param y the initial y position
	 */
	public Timer(int x, int y) 
	{
		super(x, y);
		framesTest = 0;
		height = 0;
		width = 0;
	}
	
	/** Returns the current frame
	 *  @return the current frame
	 */
	public int getFramesTest()
	{
		return framesTest;
	}
	
	/** Sets the current frame
	 *  @param frame the new frame to set to
	 */
	public void setFramesTest(int frame)
	{
		framesTest = frame;
	}
	
	/** Advances the timer and updates timer's position
	 */
	@Override
	public void update() 
	{
		int xMargin = 20;
		int yMargin = 2;
		setX(MapViewer.WIDTH - width - xMargin);
		setY(height + yMargin);
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
		framesTest++;
	}
	
	/** Draws the timer
	 *  @param gr the Graphics2D Object to draw with
	 */
	@Override
	public void draw(Graphics2D gr) 
	{
		gr.setColor(Color.BLACK);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		FontRenderContext frc = gr.getFontRenderContext();
		int seconds = 60;
		int secondsPassed = (int) (framesTest / seconds) % seconds;
		int minutesPassed = (int) (framesTest / (seconds * seconds));
		String s = String.format("%02d:%02d", minutesPassed, secondsPassed);
		TextLayout layout = new TextLayout(s, font, frc);
		layout.draw(gr, getX(), getY());
		
		Rectangle2D bounds = layout.getBounds();
		if ((int) bounds.getWidth() > width)
			width = (int) bounds.getWidth();
		height = (int) bounds.getHeight();
	}
}
