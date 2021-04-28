package snake.Ash;

import java.awt.Color;
import java.awt.Graphics;

public class Apple {

	private int xCor;
	private int yCor;
	private static int width;
	private static int height;
	
	public Apple(int xCor, int yCor) {
		this.xCor = xCor;
		this.yCor = yCor;
		width = BodyPartSnake.getWidth();
		height = BodyPartSnake.getHeight();
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(xCor, yCor, width, height);
		g.setColor(Color.RED);
		g.fillRect(xCor + 2, yCor + 2, width - 4, height - 4);
	}

	
	public int getxCor() {
		return xCor;
	}

	public int getyCor() {
		return yCor;
	}

	
}


