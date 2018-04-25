package theChildOfGod.plane;

import java.awt.Color;
import java.awt.Graphics;
import theChildOfGod.util.Constant;

/**
 * ×Óµ¯Àà
 * @author theChildOfGod
 *
 */
public class Bullet extends GameObject{
	double degree;
	
	public Bullet() {
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH / 2;
		y = Constant.GAME_HEIGHT / 2;
		width = 10;
		height = 10;
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);	
		
		if (y > Constant.GAME_HEIGHT-height || y < 30) {
			degree = -degree;
		}
	
		if (x < 0 || x > Constant.GAME_WIDTH - width) {
			degree = Math.PI - degree;
		}
		
		g.setColor(c);
	}
}
