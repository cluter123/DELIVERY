/** 
 *  Updates player based on key input from user
 *  @author Conor Mai, Guangze Zu, Emily Lam
 *  Teacher: Ishman
 *  Period: 04
 *  Date: 05-14-18
 */
package main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter 
{

	private Handler handle;
	
	/** Creates a new KeyInput Object with a given Handler
	 * @param handler the handler containing the game variables
	 */
	public KeyInput(Handler handler)
	{
		handle = handler;
	}
	
	/** Moves player based on key pressed by user
	 *  @param e the key event made by user
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		System.out.println("Pressed: " + key);
		
		//if a player 1 key is pressed it will go through the handle and change its movement
		//if the A or left key has been pressed move the player to the left
		if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) 
			handle.movePlayerLeft(1);
		//if the D or right key has been pressed move the player to the right
		else if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) 
			handle.movePlayerRight(1);
		//if the W, up, or space key has been pressed make the player jump
		else if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP || key == KeyEvent.VK_SPACE)
			handle.movePlayerUp(1);
	}
	
	/** Stops player based on key released by user
	 *  @param e the key event made by user
	 */
	@Override
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		System.out.println("RELEASED: " + key);
		//if a player 1 key is released it will go through the handle and change its movement
		//if the A or left key has been released stop the player to the left
		if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) 
			handle.stopPlayerLeft(1);
		//if the D or right key has been released stop the player to the right
		else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) 
			handle.stopPlayerRight(1);		
	}
	
	/** Ignores key typed by user
	 *  @param e the key event made by user
	 */
	@Override
	public void keyTyped(KeyEvent e)
	{
	}
}
