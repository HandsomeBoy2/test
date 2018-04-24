package theChildOfGod.solar;

import java.awt.Graphics;
import java.awt.Image;

import theChildOfGod.util.GameUtil;

public class Star {
	Image img;
	double x, y;
	int width, height;
	
	public void draw(Graphics g) {
		g.drawImage(img, (int)x, (int)y, 20, 20, null);
	}
	
	public Star() {
		
	}
	public Star(Image img) {
		this.img = img;
	}
	public Star(Image img, double x, double y) {
		this(img);
		this.x = x;
		this.y = y;
	}
	
	public Star(String imgpath, double x, double y) {
		this(GameUtil.getImage(imgpath), x, y);
	}
}
