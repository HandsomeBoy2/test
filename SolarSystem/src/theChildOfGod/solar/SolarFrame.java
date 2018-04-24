package theChildOfGod.solar;

import java.awt.Graphics;
import java.awt.Image;

import theChildOfGod.util.GameUtil;
import theChildOfGod.util.MyFrame;
import theChildOfGod.util.Constant;

/**
 * 太阳系的主窗口
 * @author Administrator
 *
 */
public class SolarFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bluesky.jpg");
	Star sun = new Star("images/sun.jpg", Constant.GAME_WIDTH/2, Constant.GAME_HEIGHT/2);
	Planet earth = new Planet(sun, "images/earth.jpg", 60, 40, 0.1);
	Planet moon = new Planet(earth, "images/moon.jpg", 30, 20, 0.3, true);
	Planet  mars = new Planet(sun, "images/mars.jpg", 80, 60, 0.2);
	Planet  wood = new Planet(sun, "images/wood.jpg", 90, 60, 0.25);
	Planet  soil = new Planet(sun, "images/soil.jpg", 150, 110, 0.3);
	Planet  gold = new Planet(sun, "images/gold.jpg", 180, 140, 0.35);
	Planet  water = new Planet(sun, "images/water.jpg", 220, 160, 0.4);
	Planet  king = new Planet(sun, "images/king.jpg", 250, 180, 0.45);
	//Planet  nepture = new Planet(sun, "images/nepture.jpg", 280, 210, 0.5);
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, 1000, 1000,null);
		sun.draw(g);
		earth.draw(g);
		mars.draw(g);
		soil.draw(g);
		gold.draw(g);
		water.draw(g);
		king.draw(g);
		//nepture.draw(g);
	}
	
	public static void main(String[] args) {
		SolarFrame gf = new SolarFrame();
		gf.launchFrame();
	}
}
