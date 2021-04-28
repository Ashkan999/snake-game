package snake.Ash;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class RenderPanel extends JPanel implements ActionListener, Runnable, KeyEventDispatcher{

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	private static final Color color = new Color(8421504);
	private Timer timer = new Timer(120, this);
	Random random = new Random();

	private static Snake snake;
	private static Apple apple;
	private static int level = 1;

	private static boolean right = false; 
	private static boolean left = false; 
	private static boolean up = false; 
	private static boolean down = false;

	public RenderPanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
//		setFocusable(true);
//		requestFocus();
//		addKeyListener(new KeyTest());
//		addKeyListener(this);
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);

		snake = new Snake();
		snake.getSnake().add(new BodyPartSnake(160,60)); 
		snake.getSnake().add(new BodyPartSnake(140,60));  
		snake.getSnake().add(new BodyPartSnake(120,60));  
		snake.getSnake().add(new BodyPartSnake(100,60)); 
		
		createNewApple();

		Thread runningGame  = new Thread(this, "runningGameThread");
		runningGame.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(color);
		g.fillRect(-100, 0, WIDTH + 200, HEIGHT + 200);

//		//grid
//		g.setColor(Color.BLACK);
//		for(int i = 0; i <= HEIGHT; i += BodyPartSnake.getHeight()) {
//			g.drawLine(0, i, WIDTH, i);
//		}
//		for(int i = 0; i <= WIDTH; i += BodyPartSnake.getWidth()) {
//			g.drawLine(i, 0, i, HEIGHT);
//		}

		for(BodyPartSnake b : snake.getSnake()) {
			b.draw(g);
		}
		
		apple.draw(g);
	}

	@Override
	public void run() {
		timer.start();
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.move();
		
		this.repaint();
		
		if(!timer.isRunning()) {
			System.out.println("GAME OVER!");
			System.out.println("LEVEL: " +  level);
		}
	}

	private void move() {
		int xCor = snake.getSnake().get(0).getxCor();
		int yCor = snake.getSnake().get(0).getyCor();
		int offsetx = BodyPartSnake.getWidth();
		int offsety = BodyPartSnake.getHeight();

		if(right) {
			snake.getSnake().add(0 , new BodyPartSnake(xCor + offsetx, yCor));
			//			for(BodyPartSnake b : snake.getSnake()) {
			//				if(b.getyCor() < yCor) {
			//					b.setyCor(b.getyCor() + offsety);
			//				}
			//				if(b.getyCor() > yCor) {
			//					b.setyCor(b.getyCor() - offsety);
			//				}
			//				else {
			//					b.setxCor(b.getxCor() + offsetx);
			//				}
			//			}
			if(borderCollision() || snakeCollision()) {
				timer.stop();
			}
			boolean bo;
			if(bo = snakeEatApple()) {
				createNewApple();
				level++;
			}
			if((!borderCollision() && !bo) && !snakeCollision()) {
				snake.getSnake().remove(snake.getSnake().size()-1);
			}
		}
		if(left) {
			snake.getSnake().add(0, new BodyPartSnake(xCor - offsetx, yCor));
			if(borderCollision() || snakeCollision()) {
				timer.stop();
			}
			boolean bo;
			if(bo = snakeEatApple()) {
				createNewApple();
				level++;
			} 
			if((!borderCollision() && !bo) && !snakeCollision()) {
				snake.getSnake().remove(snake.getSnake().size()-1);
			}
		}
		if(up) {
			snake.getSnake().add(0, new BodyPartSnake(xCor, yCor - offsety));
			if(borderCollision() || snakeCollision()) {
				timer.stop();
			}
			boolean bo;
			if(bo = snakeEatApple()) {
				createNewApple();
				level++;
			}
			if((!borderCollision() && !bo) && !snakeCollision()) {
				snake.getSnake().remove(snake.getSnake().size()-1);
			}
		}
		if(down) {
			snake.getSnake().add(0, new BodyPartSnake(xCor, yCor + offsety));
			if(borderCollision() || snakeCollision()) {
				timer.stop();
			}
			boolean bo;
			if(bo = snakeEatApple()) {
				createNewApple();
				level++;
			} 
			if((!borderCollision() && !bo) && !snakeCollision()) {
				snake.getSnake().remove(snake.getSnake().size()-1);
			}
		}

	}
	
	public boolean snakeCollision() {
		for(int i = 1; i < snake.getSnake().size(); i++) {
			if(snake.getSnake().get(0).getxCor() == snake.getSnake().get(i).getxCor() && snake.getSnake().get(0).getyCor() == snake.getSnake().get(i).getyCor()) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean borderCollision() {
		if(snake.getSnake().get(0).getxCor() < 0 || snake.getSnake().get(0).getxCor() >= WIDTH) {
			return true;
		}
		if(snake.getSnake().get(0).getyCor() < 0 || snake.getSnake().get(0).getyCor() >= HEIGHT) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean snakeEatApple() {
		if(!(snake.getSnake().get(0).getxCor() == apple.getxCor())) {
			return false;
		}
		if(!(snake.getSnake().get(0).getyCor() == apple.getyCor())) {
			return false;
		}
		return true;
	}
	
	public void createNewApple() {
		int xCor = 1;
		while(!((xCor % BodyPartSnake.getWidth()) == 0)) {
			xCor = random.nextInt(WIDTH - 20);
		}
		int yCor = 1;
		while(!((yCor % BodyPartSnake.getHeight()) == 0)) {
			yCor = random.nextInt(HEIGHT - 20);
		}
		apple = new Apple(xCor, yCor);
		
		for(BodyPartSnake b : snake.getSnake()) {
			if(apple.getxCor() == b.getxCor() && apple.getyCor() == b.getyCor()) {
				createNewApple();
			}
		}
		
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent arg0) {
			int key = arg0.getKeyCode();

			if((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && !left) {
				right = true;
				left = false;
				up = false;
				down = false;
			}
			if((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && !right) {
				right = false;
				left = true;
				up = false;
				down = false;
			}
			if((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && !down) {
				right = false;
				left = false;
				up = true;
				down = false;
			}
			if(((key == KeyEvent.VK_DOWN | key == KeyEvent.VK_S) && !up) ) {
				right = false;
				left = false;
				up = false;
				down = true;
			}
		return false;
	}

	
}
