package theChildOfGod.plane;

import java.awt.Graphics;
import java.awt.Image;

import theChildOfGod.util.GameUtil;

public class Explode {
	double x, y;
	static Image[] imgs = new Image[11];
	static {
		for (int i = 0; i < 11; i++) {
			imgs[i] = GameUtil.getImage("images/explode/e" + (i+1) + ".jpg");
			imgs[i].getWidth(null);
		}
	}
	
	int count;
	
	public void draw(Graphics g) {
		if (count < 11) {
			g.drawImage(imgs[count], (int)x, (int)y, 60, 60, null);
			count++;
		}
	}
	
	public Explode(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
