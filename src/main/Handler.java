package main;
/**
 * @author Conor Mai
 */

import java.awt.Graphics2D;
import java.util.LinkedList;

import characters.Player;

public class Handler {

	public LinkedList<Character> characters;
	public LinkedList<Player> playerList;
	
	/** Creates a linked list of characters
	 * 
	 */
	public Handler() 
	{
		characters = new LinkedList<Character>();
		playerList = new LinkedList<Player>();
	}
	
	/**Goes through all of the Characters and updates them
	 * 
	 */
	public void update()
	{
		for(Character tempCharacter : characters)
			tempCharacter.update();
		
		for(Player tempPlayer : playerList)
			tempPlayer.update();
	}
	
	/**Goes through all of the Characters and makes them draw themselves
	 * @param g
	 */
	public void draw(Graphics2D g)
	{
		for(Character tempCharacter : characters)
			tempCharacter.draw(g);
	
		for(Player tempPlayer : playerList)
			tempPlayer.draw(g);
	}
	
	/**Adds an object to the list of characters
	 * @param object
	 */
	public void addCharacter(Character object)
	{
		characters.add(object);
	}
	
	/**removes an object from the list of characters
	 * @param object
	 */
	public void removeCharacter(Character object)
	{
		characters.remove(object);
	}
	
	public void addPlayer(Player p)
	{
		playerList.add(p);
	}
	
	public void removePlayer(Player p)
	{
		playerList.remove(p);
	}
	
	/**Goes through the collection of characters and finds the player 1 
	 * and makes it move to the left
	 */
	public void movePlayerLeft(int id)
	{
		for(Player player : playerList)
			if(player.getID() == id)
				player.getPosition().setXVelocity(-5);
	}
	
	/**Goes through the collection of characters and finds the player 1 
	 * and makes it move to the right
	 */
	public void movePlayerRight(int id)
	{
		for(Player player : playerList)
			if(player.getID() == id)
				player.getPosition().setXVelocity(5);
	}
	
	public void movePlayerUp(int id)
	{
		for(Player player : playerList)
			if(player.getID() == id)
				player.getPosition().setYVelocity(-20);
		
	}
	
	/**Goes through the collection of characters and finds the player 1 
	 * and stops it if it is moving to the left
	 */
	public void stopPlayerLeft(int id) 
	{
		for(Player player : playerList)
			if(player.getID() == id)
			{
				if(player.getPosition().getXVelocity() < 0)
					player.getPosition().setXVelocity(0);
			}
	}
	
	/**Goes through the collection of characters and finds the player 1 
	 * and stops it if it is moving to the right
	 */
	public void stopPlayerRight(int id)
	{
		for(Player player : playerList)
			if(player.getID() == id)
			{
				if(player.getPosition().getXVelocity() > 0)
					player.getPosition().setXVelocity(0);
			}
	}
}
