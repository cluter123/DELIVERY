/** A model of a coin that contains points and is 
 *  represented by the symbol "$".
 *  Can be drawn and updated.
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

public class Coin extends Character 
{
	public static final int COIN_POINTS = 25;
	public static final String COIN_SYMBOL = "$";
	private int height;
	private int width;
	
	/** Creates a coin with a given position
	 *  @param x the initial x coordinate
	 *  @param y the initial y coordinate
	 */
	public Coin(int x, int y)
	{
		super(x, y);
		width = 0;
		height = 0;
		setPoints(COIN_POINTS);
	}
	
	/** Updates coin's bounding rectangle
	 */
	@Override
	public void update() 
	{
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
	}

	/** Draws the coin
	 *  @param gr the Graphics2D Object to draw with
	 */
	@Override
	public void draw(Graphics2D gr)
	{
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		gr.setFont(font);

		gr.setColor(Color.ORANGE);
		FontRenderContext frc = gr.getFontRenderContext();
		TextLayout layout = new TextLayout(COIN_SYMBOL, font, frc);
		layout.draw(gr, getX(), getY());
		Rectangle2D bounds = layout.getBounds();
		height = (int) bounds.getHeight();
		width = (int) bounds.getWidth();
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
	}
}
