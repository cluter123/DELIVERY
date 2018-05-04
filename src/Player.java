import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Player extends Character {

	public Player(Position pos, int initialPoints) {
		super(pos, initialPoints);
	}

	@Override
	public void render(Graphics2D gr) {
		gr.setFont(new Font("Courier", Font.PLAIN, 10));
		gr.setColor(Color.blue);
		gr.drawRect(getPosition().getX(), getPosition().getY() - 10, 6, 10);
		gr.setColor(Color.black);
		gr.drawString("G", getPosition().getX(), getPosition().getY());
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
