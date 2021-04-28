package snake.Ash;

import java.awt.Color;
import java.awt.Graphics;

public class BodyPartSnake {
	
	private int xCor;
	private int yCor;
	private static final int WIDTH = 20;
	private static final int HEIGHT = 20;

	public BodyPartSnake(int xCor, int yCor) {
		this.xCor = xCor;
		this.yCor = yCor;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(xCor, yCor, WIDTH, HEIGHT);
		g.setColor(Color.GREEN);
		g.fillRect(xCor + 1, yCor + 1, WIDTH - 2, HEIGHT - 2);
		g.setColor(Color.BLACK);
		g.fillRect(xCor + 3, yCor + 3, WIDTH -6, HEIGHT -6);
	}
	
	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}


	public int getxCor() {
		return xCor;
	}

	public int getyCor() {
		return yCor;
	}

	public void setxCor(int xCor) {
		this.xCor = xCor;
	}

	public void setyCor(int yCor) {
		this.yCor = yCor;
	}
	
	
}
