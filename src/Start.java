import javax.swing.JFrame;



public class Start extends JFrame {
	
	public Start() {
		initUI();
	}
	
	private void initUI() {
		add(new Visualizer());
		setResizable(false);
		pack();
		setTitle("Sorting Visualizer 1.0");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		JFrame s = new Start();
		s.setVisible(true);
	}
}
