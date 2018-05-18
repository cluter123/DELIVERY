/** 
 *  A mail package represented by letters of the alphabet.
 *  Can be drawn, be updated, and return the letter. Every
 *  new letter is the next letter in the alphabet.
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

public class Letter extends Character
{
	public static final int LETTER_POINTS = 50;
	public static final String[] ABC_ARRAY = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	private static int order = 0;
	private String letter;
	private int height;
	private int width;
	
	/** Creates a letter with a given position
	 * @param x the initial x coordinate
	 * @param y the initial y coordinate
	 */
	public Letter(int x, int y)
	{
		super(x, y);
		width = 0;
		height = 0;
		setPoints(LETTER_POINTS);
		if (order < ABC_ARRAY.length)
			letter = ABC_ARRAY[order];
		order++;
	}
	
	/** Returns the next letter's position in the alphabet
	 *  @return the next letter's position in the alphabet
	 */
	public static int getOrder()
	{
		return order;
	}
	
	/** Returns whether the letter's position is odd
	 *  @return true if the position is odd, false if else
	 */
	public boolean isOdd()
	{
		if ((order - 1) % 2 == 0)
			return false;
		return true;
	}
	
	/** Returns the letter as a String
	 *  @return the letter as a String
	 */
	public String getLetter()
	{
		return letter;
	}
	
	/** Updates letter
	 */
	@Override
	public void update()
	{
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
	}
	
	/** Draws the letter
	 *  @param gr the Graphics2D Object to draw with
	 */
	@Override
	public void draw(Graphics2D gr)
	{
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		gr.setFont(font);

		gr.setColor(Color.GREEN);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout layout = new TextLayout(letter, font, frc);
		layout.draw(gr, getX(), getY());
		Rectangle2D bounds = layout.getBounds();

		height = (int) bounds.getHeight();
		width = (int) bounds.getWidth();
		setBoundingRectangle(bounds);
	}
}
