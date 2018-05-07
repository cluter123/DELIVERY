package main;
/**
 * @author Conor Mai
 *
 */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handle;
	
	public KeyInput(Handler handler)
	{
		handle = handler;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		System.out.println(KeyEvent.VK_A);
		int key = e.getKeyCode();
		System.out.println("Pressed: " + key);
		
		//if a player 1 key is pressed it will go through the handle and change its movement
		if(key == KeyEvent.VK_A) //if the A key has been pressed move the player to the left
			handle.movePlayerLeft(1);
		else if(key == KeyEvent.VK_D) //if the W key has been pressed move the player to the right
			handle.movePlayerRight(1);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		System.out.println("RELEASED: " + key);
		//if a player 1 key is released it will go through the handle and change its movement
		if(key == KeyEvent.VK_A) //if the A key has been released stop the player to the left
			handle.stopPlayerLeft(1);
		else if(key == KeyEvent.VK_D) //if the W key has been released stop the player to the right
			handle.stopPlayerRight(1);		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyAdapter#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e)
	{
	}
}
