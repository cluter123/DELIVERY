import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	private LinkedList<Character> objects = new LinkedList<Character>();
	
	public Handler() {
		// TODO Auto-generated constructor stub
	}
	
	public void update()
	{
		for(int k = 0; k < objects.size(); k++)
		{
			Character tempObject = objects.get(k);
			
			tempObject.update();
		}
	}
	
	public void render(Graphics g)
	{
		for(int k = 0; k < objects.size(); k++)
		{
			Character tempObject = objects.get(k);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(Character object)
	{
		objects.add(object);
	}
	
	public void removeObject(Character object)
	{
		objects.remove(object);
	}
}
