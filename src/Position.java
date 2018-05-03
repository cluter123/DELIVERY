import java.awt.Rectangle;

public class Position {
	
	private int xPos;
	private int yPos;
	private int length;
	private int height;

	public Position(int xPosition, int yPosition, int xLength, int yHeight) {
		xPos = xPosition;
		yPos = yPosition;
		length = xLength;
		height = yHeight;
	}
	
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
	
	public int getXLength()
	{
		return length;
	}
	
	public int getYHeight()
	{
		return height;
	}
	
	public void setX(int x)
	{
		xPos = x;
	}
	
	public void setY(int y)
	{
		yPos = y;
	}
	
	public void setXLength(int xLength)
	{
		length = xLength;
	}
	
	public void setYHeight(int yHeight)
	{
		height = yHeight;
	}
	
	public void addX(int x)
	{
		xPos += x;
	}
	
	public void addY(int y)
	{
		yPos += y;
	}
	
	public void addXLength(int xLength)
	{
		length += xLength;
	}
	
	public void addYHeight(int yHeight)
	{
		height += yHeight;
	}
	
	public Rectangle getBoundingReactangle()
	{
		return new Rectangle(xPos, yPos, length, height);
	}
}
