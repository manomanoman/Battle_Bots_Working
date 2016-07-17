package mainStuff;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display extends JFrame {

	// This creates the JFrame
	
	private JFrame frame;
	private Canvas canvas;

	private String title;
	private int width, height;

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		createDisplay();
	}

	private void createDisplay() {
		// JFrame Stuff
		frame = new JFrame();
		canvas = new Canvas();

		frame.setTitle(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		
		frame.add(canvas);
		frame.repaint();
		frame.revalidate();

	}
	
	//Getters And Setters

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
