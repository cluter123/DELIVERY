package obstacles;

import java.awt.Graphics2D;

import main.Obstacle;
import main.Position;

public class Platform extends Obstacle {

	public Platform(Position pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D gr) {
		// TODO Auto-generated method stub
		
		gr.drawString("asdf", getPosition().getX(), getPosition().getY());
		gr.fill(getPosition().getBoundingReactangle());
	}

}
