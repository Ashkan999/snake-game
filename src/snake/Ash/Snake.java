package snake.Ash;

import java.util.ArrayList;

public class Snake {

	private ArrayList<BodyPartSnake> snake;
	
	public Snake() {
		snake = new ArrayList<BodyPartSnake>();
	}

	public ArrayList<BodyPartSnake> getSnake() {
		return snake;
	}
}
