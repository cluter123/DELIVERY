package main;

public class Position {
	
	private int xPos;
	private int yPos;
	private int xVel;
	private int yVel;

	public Position(int xPosition, int yPosition, int xVelocity, int yVelocity) {
		xPos = xPosition;
		yPos = yPosition;
		xVel = xVelocity;
		yVel = yVelocity;
	}
	
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
	
//	public int getXLength()
//	{
//		return length;
//	}
//	
//	public int getYHeight()
//	{
//		return height;
//	}
	
	public void setX(int x)
	{
		xPos = x;
	}
	
	public void setY(int y)
	{
		yPos = y;
	}
	
//	public void setXLength(int xLength)
//	{
//		length = xLength;
//	}
//	
//	public void setYHeight(int yHeight)
//	{
//		height = yHeight;
//	}
	
	public void addX(int x)
	{
		xPos += x;
	}
	
	public void addY(int y)
	{
		yPos += y;
	}
	
//	public void addXLength(int xLength)
//	{
//		length += xLength;
//	}
//	
//	public void addYHeight(int yHeight)
//	{
//		height += yHeight;
//	}
	
	public int getXVelocity()
	{
		return xVel;
	}
	
	public int getYVelocity()
	{
		return yVel;
	}
	
	public void setXVelocity(int xVelocity)
	{
		xVel = xVelocity;
	}
	
	public void setYVelocity(int yVelocity)
	{
		yVel = yVelocity;
	}
	
	public void addXVelocity(int xVelocity)
	{
		xVel += xVelocity;
	}
	
	public void addYVelocity(int yVelocity)
	{
		yVel += yVelocity;
	}
	
//	public Rectangle getBoundingReactangle()
//	{
//		// this has been changed for strings that draw from bottom left
//		return new Rectangle(xPos, yPos - height, length, height);
//	}
}
