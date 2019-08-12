
/*
 * @author Daniel Hawkins
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Visualizer extends JPanel {
	
	private static int j;
	private static int i;
	private static int n;
	private static int count;
	private static int min_idx;
	private final int boardWidth = 1500;
	private final int boardHeight = 1000;
	private static int arraySize = 1500;
	private Boolean done = false;
	private ArrayList<Rect> rectArray = new ArrayList<>();
	private Timer timer;
	
	/*
	 * Constructor that creates a board to visualize sorting processes and calls the sorting function until the list is sorted.
	 */
	public Visualizer() {
		initBoard(arraySize); // Initializes a board with the given number of items in the array.
		Collections.shuffle(rectArray); // Randomizes the order of the numbers in the array.
		/*
		 * Swing game timer that allows for a better visualization of the sorting process by adding a small delay between each step.
		 */
		timer = new Timer(10, new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!done) {
					selectionSort();
				}
				else {
					if (count < 499) {
						for (int i = 0;i<4;i++) {
							rectArray.get(count+i).setColor(Color.GREEN);
						}
						count+=4;
						repaint();
					}
					else {
						timer.stop();
					}
				}
			}
		});
		timer.start();
	}
	
	
	/*
	 * Initializes the board to visualize the sorting process.
	 */
	private void initBoard(int a) {
		int j = 0;
		for (int i = 0; i < a; i+=3) {
			j+=2;
			rectArray.add(new Rect(i,j,2,boardHeight-j,Color.GRAY));
		}
		setFocusable(true);
		setDoubleBuffered(true);
		
		setPreferredSize(new Dimension(boardWidth, boardHeight));
		repaint();
		n = rectArray.size();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	private void draw(Graphics g) {
		int i = 0;
		for (Rect rec:rectArray) {
			i+=3;
			int x = i;
			int y = rec.getY();
			int w = rec.getWidth();
			int h = rec.getHeight();
			g.setColor(rec.getColor());
			g.fillRect(x, y, w, h);
		}
		Toolkit.getDefaultToolkit().sync();
	}
	
	/*
	 * Implementation of the Selection Sort algorithm that can be run by the visualizer.
	 */
	private void selectionSort() {
		if (i < n) {
			if (i > 0 && i != n) {
				rectArray.get(i-1).setColor(Color.GRAY);
			}
			rectArray.get(min_idx).setColor(Color.GRAY);
			min_idx = i;
			for (j = i+1;j < n;j++) {
				if (rectArray.get(j).getHeight() < rectArray.get(min_idx).getHeight()) {
					min_idx = j;
		        }
            }
			Collections.swap(rectArray, min_idx, i);
			rectArray.get(min_idx).setColor(Color.BLUE);
			rectArray.get(i).setColor(Color.RED);
			i++;
			repaint();
		}
		else {
			rectArray.get(n-1).setColor(Color.GRAY);
			System.out.println("Sorting Complete.");
			done = true;
			repaint();
		}
	}

}
