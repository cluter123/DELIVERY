/** 
 *  Contains and updates all the characters and obstacles in the game
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-14-18
 */
package main;
import java.awt.Graphics2D;
import java.util.LinkedList;

import characters.Player;

public class Handler 
{

	public LinkedList<Character> characters;
	public LinkedList<Player> playerList;
	public LinkedList<Obstacle> obstacles;
	public LinkedList<House> houses;
	
	/** Creates a linked list of characters
	 */
	public Handler() 
	{
		characters = new LinkedList<Character>();
		playerList = new LinkedList<Player>();
		obstacles = new LinkedList<Obstacle>();
		houses = new LinkedList<House>();
	}
	
	/** Goes through all of the Characters and updates them
	 */
	public void update()
	{
		for(Character tempCharacter : characters)
			tempCharacter.update();
		
		for(Player tempPlayer : playerList)
			tempPlayer.update();
	}
	
	/** Goes through all of the Characters and makes them draw themselves
	 *  @param g the Graphics2D object to draw with
	 */
	public void draw(Graphics2D g)
	{
		for(Obstacle tempObstacle : obstacles)
			tempObstacle.draw(g);
		
		for(Character tempCharacter : characters)
			tempCharacter.draw(g);
	
		for(Player tempPlayer : playerList)
			tempPlayer.draw(g);
		
		for(House tempHouse : houses)
			tempHouse.draw(g);
	}
	
	/** Adds an object to the list of characters
	 *  @param object the Character to be removed
	 */
	public void addCharacter(Character object)
	{
		characters.add(object);
	}
	
	/** Removes an object from the list of characters
	 *  @param object the Character to be removed
	 */
	public void removeCharacter(Character object)
	{
		characters.remove(object);
	}
	
	/** Adds a given player
	 *  @param p the player to be added
	 */
	public void addPlayer(Player p)
	{
		playerList.add(p);
	}
	
	/** Removes a given player
	 *  @param p the player to be removed
	 */
	public void removePlayer(Player p)
	{
		playerList.remove(p);
	}
	
	/** Adds a given obstacle
	 *  @param obstacle the obstacle to be added
	 */
	public void addObstacle(Obstacle obstacle)
	{
		obstacles.add(obstacle);
	}
	
	/** Removes a given obstacle
	 *  @param obstacle the obstacle to be removed
	 */
	public void removeObstacle(Obstacle obstacle)
	{
		 obstacles.remove(obstacle);
	}
	
	/** Adds a house
	 *  @param house the house to add
	 */
	public void addHouse(House house)
	{
		houses.add(house);
	}
	
	/** Removes a house
	 *  @param house the house to remove
	 */
	public void removeHouse(House house)
	{
		 houses.remove(house);
	}
	
	/** Goes through the collection of characters and finds the player 1 
	 *  and makes it move to the left
	 *  @param id the player id
	 */
	public void movePlayerLeft(int id)
	{
		for(Player player : playerList)
			if(player.getID() == id)
				player.getPosition().setXVelocity(-5);
	}
	
	/** Goes through the collection of characters and finds the player 1 
	 *  and makes it move to the right
	 *  @param id the player id
	 */
	public void movePlayerRight(int id)
	{
		for(Player player : playerList)
			if(player.getID() == id)
				player.getPosition().setXVelocity(5);
	}
	
	/** Goes through the collection of characters and finds the player 1 
	 *  and moves it up
	 *  @param id the player id
	 */
	public void movePlayerUp(int id)
	{
		for(Player player : playerList)
			if(player.getID() == id)
				player.getPosition().setYVelocity(-20);
		
	}
	
	/** Goes through the collection of characters and finds the player 1 
	 *  and stops it if it is moving to the left
	 *  @param id the player id
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
	
	/** Goes through the collection of characters and finds the player 1 
	 *  and stops it if it is moving to the right
	 *  @param id the player id
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
