/** 
 *  Contains and updates all the characters and obstacles in the game
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-18-18
 */
package main;

import java.awt.Graphics2D;
import java.util.LinkedList;

import characters.Coin;
import characters.House;
import characters.Player;
import characters.Timer;

public class Handler
{
	private LinkedList<Character> characters;
	private LinkedList<Player> playerList;
	private LinkedList<Obstacle> obstacles;
	private LinkedList<House> houses;
	private LinkedList<Coin> coins;
	private Timer timer;
	
	/** Creates a new handler with a timer and empty lists of characters,
	 *  players, obstacles, houses, and coins
	 */
	public Handler() 
	{
		characters = new LinkedList<Character>();
		playerList = new LinkedList<Player>();
		obstacles = new LinkedList<Obstacle>();
		houses = new LinkedList<House>();
		coins = new LinkedList<Coin>();
		timer = null;
	}
	
	/** Goes through all of the Characters and the timer and updates them
	 */
	public void update()
	{
		for(Character tempCharacter : characters)
			tempCharacter.update();
		
		for(Coin tempCoin : coins)
			tempCoin.update();
		
		for(Player tempPlayer : playerList)
			tempPlayer.update();
		
		if (timer.getFrames() % 200 == 0)
		{
			addCoin();
			addCoin();
			removeCoin();
		}
	}
	
	/** Goes through all of the Characters and makes them draw themselves
	 *  @param gr the Graphics2D object to draw with
	 */
	public void draw(Graphics2D gr)
	{
		for(Obstacle tempObstacle : obstacles)
			tempObstacle.draw(gr);
		
		for(Character tempCharacter : characters)
			tempCharacter.draw(gr);
		
		for(Coin tempCoin : coins)
			tempCoin.draw(gr);
		
		for(Player tempPlayer : playerList)
			tempPlayer.draw(gr);
	}
	
	/** Adds a given object to the list of characters
	 *  @param object the Character to be added
	 */
	public void addCharacter(Character object)
	{
		characters.add(object);
		if (object instanceof House)
			houses.add((House)object);
	}
	
	/** Removes a given object from the list of characters
	 *  @param object the Character to be removed
	 */
	public void removeCharacter(Character object)
	{
		characters.remove(object);
		if (object instanceof House)
			houses.remove((House)object);
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
	
	/** Adds a timer
	 *  @param timer the timer to be added
	 */
	public void addTimer(Timer timer)
	{
		this.timer = timer;
	}
	
	/** Adds a coin with a random position
	 */
	public void addCoin()
	{
		int avgDimension = 30;
		int randX = (int) (Math.random() * (MapViewer.WIDTH - avgDimension));
		int randY = (int) (Math.random() * (MapViewer.HEIGHT * 4 / 5)) + 
				(MapViewer.HEIGHT * 1 / 10);
		coins.add(new Coin(randX, randY));
	}
	
	/** Removes the first coin
	 */
	public void removeCoin()
	{
		coins.removeFirst();
	}
	
	/** Removes the given coin
	 *  @param coin the coin to be removed
	 */
	public void removeCoin(Coin coin)
	{
		coins.remove(coin);
	}
	
	/** Returns the timer
	 *  @return the timer
	 */
	public Timer getTimer()
	{
		return timer;
	}
	
	/** Returns the list of characters
	 *  @return the list of characters
	 */
	public LinkedList<Character> getCharacters()
	{
		return characters;
	}
	
	/** Returns the list of players
	 *  @return the list of players
	 */
	public LinkedList<Player> getPlayerList()
	{
		return playerList;
	}
	
	/** Returns the list of obstacles
	 *  @return the list of obstacles
	 */
	public LinkedList<Obstacle> getObstacles()
	{
		return obstacles;
	}
	
	/** Returns the list of houses
	 *  @return the list of houses
	 */
	public LinkedList<House> getHouses()
	{
		return houses;
	}
	
	/** Returns the list of coins
	 *  @return the list of coins
	 */
	public LinkedList<Coin> getCoins()
	{
		return coins;
	}
	
	/** Goes through the collection of characters and finds the player 
	 *  and moves the player left
	 *  @param id the id of the player to move
	 */
	public void movePlayerLeft(int id)
	{
		for(Player player : playerList)
		{
			if(player.getID() == id)
				player.setVelX(-5);
		}
	}
	
	/** Goes through the collection of characters and finds the player 
	 *  and moves the player right
	 *  @param id the id of the player to move
	 */
	public void movePlayerRight(int id)
	{
		for(Player player : playerList)
		{
			if(player.getID() == id)
				player.setVelX(5);
		}
	}
	
	/** Goes through the collection of characters and finds the player 
	 *  and moves the player up
	 *  @param id the id of the player to move
	 */
	public void movePlayerUp(int id)
	{
		for(Player player : playerList)
		{
			if(player.getID() == id)
				//if(player.getVelY() == 0)
					player.setVelY(-20);
		}
	}
	
	/** Goes through the collection of characters and finds the player 
	 *  and stops it if it is moving to the left
	 *  @param id the id of the player to stop
	 */
	public void stopPlayerLeft(int id) 
	{
		for(Player player : playerList)
		{
			if(player.getID() == id)
			{
				if(player.getVelX() < 0)
					player.setVelX(0);
			}
		}
	}
	
	/** Goes through the collection of characters and finds the player 
	 *  and stops it if it is moving to the right
	 *  @param id the id of the player to stop
	 */
	public void stopPlayerRight(int id)
	{
		for(Player player : playerList)
		{
			if(player.getID() == id)
			{
				if(player.getVelX() > 0)
					player.setVelX(0);
			}
		}
	}
	
	/** Returns the player with the given id
	 *  @param id the id to match to the player
	 *  @return the player with the matching id
	 */
	public Player getPlayer(int id) 
	{
		for (Player player : playerList)
		{
			if (player.getID() == id)
				return player;
		}
		return null;
	}
}
