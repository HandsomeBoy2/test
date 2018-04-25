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
	
	ArrayList bulletList = new ArrayList(); //����δ��
	
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT, null);
		p.draw(g);
		p.move();
		
		for(int i = 0; i < bulletList.size(); i++) {
			Bullet b = (Bullet) bulletList.get(i);
			b.draw(g);
			
			//�����ɻ�����ײ
			boolean peng = b.getRect().intersects(p.getRect());
			if (peng) {
				p.setLive(false);//�ɻ�����
			}
		}
		if (!p.isLive()) {
			Color c = g.getColor();
			g.setColor(Color.GREEN);
			Font f = new Font("����", Font.BOLD, 100);
			g.setFont(f);
			g.drawString("GAME OVER", 100, 200);
			g.setColor(c);
		}
	}
	
	//����˫���弼��������˸
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
		//���Ӽ��̵ļ���
		addKeyListener(new KeyMonitor());
		
		//����һ���ӵ�
		for(int i = 0; i < 50; i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
		}
	}
	//������ڲ��࣬���Է����ʹ���ⲿ�����ͨ����
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			//ʵ�ַɻ��ĸ��������
			//p.move(e);
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.minusDirection(e);
		}
		
	}
}
