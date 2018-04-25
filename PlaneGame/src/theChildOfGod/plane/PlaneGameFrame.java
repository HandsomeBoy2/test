package theChildOfGod.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import theChildOfGod.util.Constant;
import theChildOfGod.util.GameUtil;
import theChildOfGod.util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	Image background = GameUtil.getImage("images/background.jpg");
	Plane p = new Plane("images/plane.jpg", 50, 50);
	
	ArrayList bulletList = new ArrayList(); //泛型未加
	
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT, null);
		p.draw(g);
		p.move();
		
		for(int i = 0; i < bulletList.size(); i++) {
			Bullet b = (Bullet) bulletList.get(i);
			b.draw(g);
			
			//检测跟飞机的碰撞
			boolean peng = b.getRect().intersects(p.getRect());
			if (peng) {
				p.setLive(false);//飞机死掉
			}
		}
		if (!p.isLive()) {
			Color c = g.getColor();
			g.setColor(Color.GREEN);
			Font f = new Font("宋体", Font.BOLD, 100);
			g.setFont(f);
			g.drawString("GAME OVER", 100, 200);
			g.setColor(c);
		}
	}
	
	//利用双缓冲技术消除闪烁
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if(offScreenImage == null) 
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
	public static void main(String[] args) {
		PlaneGameFrame c = new PlaneGameFrame();
		c.launchFrame();
	}
	
	public void launchFrame() {
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());
		
		//生成一堆子弹
		for(int i = 0; i < 50; i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
		}
	}
	//定义成内部类，可以方便的使用外部类的普通属性
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			//实现飞机四个方向飞行
			//p.move(e);
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.minusDirection(e);
		}
		
	}
}
