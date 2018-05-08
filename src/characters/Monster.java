package characters;
import java.awt.Graphics2D;

import main.Character;
import main.Position;

public class Monster extends Character {
	
	private static final String SYMBOL = "@";

	public Monster(Position pos, int initialPoints) {
		super(pos, initialPoints);
	}

	@Override
	public void update() 
	{
		//find the Player1 position and move in the direction of it

	}

	@Override
	public void draw(Graphics2D gr) 
	{
		//draw the @ string at x , y
	}

}
