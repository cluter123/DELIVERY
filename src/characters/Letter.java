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

public class Letter extends Character
{
	private String letter;
	private int letterPosition;
	private int height;
	private int width;
	private static int order = 0;
	public static final int LETTER_POINTS = 50;
	public static final String[] ABC_ARRAY = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
			"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	public Letter(int x, int y)
	{
		super(x, y);
		letterPosition = order++;
		width = 0;
		height = 0;
		setPoints(LETTER_POINTS);
		if (letterPosition < ABC_ARRAY.length)
			letter = ABC_ARRAY[letterPosition];
	}
	
	public int getLetterPosition()
	{
		return letterPosition;
	}
	
	public static int getOrder()
	{
		return order;
	}
	
	public boolean isOdd()
	{
		if (letterPosition % 2 == 0)
			return false;
		return true;
	}
	
	public String getLetter()
	{
		return letter;
	}
	
	@Override
	public void update()
	{
		setBoundingRectangle(new Rectangle(getX(), getY() - height, width, height));
	}
	
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
		
//		gr.setColor(Color.GREEN);
//		gr.draw(getBoundingRectangle());
	}
}
