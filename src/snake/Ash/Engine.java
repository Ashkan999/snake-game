//package snake.Ash;
//
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.Timer;
//
//public class Engine implements Runnable, ActionListener {
//
//	private Graphics g;
//
//	private Snake snake;
//	private Timer timer = new Timer(1000, this);
//
//	private boolean right = true; 
//	private boolean left = false; 
//	private boolean up = false; 
//	private boolean down = false;
//
//	//	private boolean running = true;
//
//	public Engine(Graphics g) {
//		this.g = g;
//		snake = new Snake();
//		snake.getSnake().add(new BodyPartSnake(200,100)); 
//		snake.getSnake().add(new BodyPartSnake(180,100));  
//		snake.getSnake().add(new BodyPartSnake(160,100));  
//		snake.getSnake().add(new BodyPartSnake(140,100));  
//		this.draw(g);
//		
//		
//		
//		
//
//		Thread runningGame  = new Thread(this, "runningGameThread");
//		runningGame.start();
//
//	}
//
//	public void draw(Graphics g) {
//		for(BodyPartSnake b : snake.getSnake()) {
//			b.draw(g);
//		}
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//
//		this.move();
//		System.out.println("hoisfsd");
//		this.draw(this.g);
//		
//	//	timer.stop();
//
//
//	}
//
//	@Override
//	public void run() {
//		timer.start();
//
//	}
//
//	public void move() {
//		int xCor = snake.getSnake().get(0).getxCor();
//		int yCor = snake.getSnake().get(0).getyCor();
//		int offsetx = BodyPartSnake.getWidth();
//		int offsety = BodyPartSnake.getHeight();
//
//		if(right = true) {
//			snake.getSnake().add(0 , new BodyPartSnake(xCor + offsetx, yCor));
//			snake.getSnake().remove(snake.getSnake().size()-1);
//		}
//		if(left = true) {
//
//		}
//		if(up = true) {
//
//		}
//		if(down = true) {
//
//		}
//	}
//}
