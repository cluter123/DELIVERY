/**
 * To categorize different obstacles in the game, and provide required behaviors for each obstacle
 */

import java.awt.Graphics2D;

public Interface Obstacle 
{
   /** Draws the obstacle using the given graphics context
	 *  @param gr the graphics context for drawing
	 */
	void draw(Graphics2D gr);
    
    
}
