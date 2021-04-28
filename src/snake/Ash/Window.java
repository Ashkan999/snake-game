package snake.Ash;

import javax.swing.JFrame;

public class Window {

	private JFrame jframe;
	private RenderPanel render;

	public Window() {
		jframe = new JFrame("Snake");
		jframe.setVisible(true);
		//	jframe.setLayout(new GridLayout(1,1,0,0));
		jframe.add(render = new RenderPanel());
		jframe.pack();
//		jframe.setSize(render.getWidth(), render.getHeight());
//		jframe.setFocusable(true);
//		jframe.requestFocusInWindow();
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

