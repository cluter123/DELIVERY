package Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Conor Mai
 *
 */
public class KeyInput extends KeyAdapter {

	private Handler handle;
	
	public KeyInput(Handler handle)
	{
		this.handle = handle;
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
		{
			handle.moveP1Left();
		}
		else if(key == KeyEvent.VK_D) //if the W key has been pressed move the player to the right
		{
			handle.moveP1Right();
		}
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
		{
			handle.stopP1Left();
		}
		else if(key == KeyEvent.VK_D) //if the W key has been released stop the player to the right
		{
			handle.stopP1Right();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyAdapter#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e)
	{
	}
}
