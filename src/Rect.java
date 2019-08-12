import java.awt.Color;
import java.awt.Graphics;


public class Rect {
	
	private int startX, startY;
	private int width, height;
	private Color color;
	private Boolean select = false;
	
	public Rect(int sx, int sy, int w, int h, Color c) {
		startX = sx;
		startY = sy;
		width = w;
		height = h;
		color = c;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(startX, startY, width, height);
	}
	
	public int getX() {
		return startX;
	}
	
	public int getY() {
		return startY;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public void setX(int x) {
		startX = x;
	}
	
	public void setY(int y) {
		startY = y;
	}
	
	public void setHeight(int h) {
		height = h;
	}
	
	public void setSelected(Boolean b) {
		select = b;
	}
	
	public boolean getSelected() {
		return select;
	}
}
