import javax.swing.*;

public class GUIFrame extends JFrame {

	private static final long serialVersionUID = 8456219051373839560L; // unused
	static int windowSizeX = 750;
	static int windowSizeY = 750;

	public GUIFrame(JPanel t) {
		this.setTitle("tsp_ea");
		this.setSize(windowSizeX, windowSizeY);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(t);

	}

	public static int getWindowSizeX() {
		return windowSizeX;
	}

	public static int getWindowSizeY() {
		return windowSizeY;
	}

}
