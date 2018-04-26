package theChildOfGod.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.ArrayList;

import theChildOfGod.util.Constant;
import theChildOfGod.util.GameUtil;
import theChildOfGod.util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	Image background2 = GameUtil.getImage("images/background2.jpg");
	Plane p = new Plane("images/plane.jpg", 50, 50);
	
	ArrayList bulletList = new ArrayList(); //����δ��
	
	Date startTime;
	Date middleTime;
	Date endTime;
	
	public void paint(Graphics g) {
		g.drawImage(background2, 0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT, null);
		p.draw(g);
		p.move();
		
		for(int i = 0; i < bulletList.size(); i++) {
			Bullet b = (Bullet) bulletList.get(i);
			b.draw(g);
			
			//�����ɻ�����ײ
			boolean peng = b.getRect().intersects(p.getRect());
			if (peng) {
				p.setLive(false);//�ɻ�����
				endTime = new Date();
			} else {
				middleTime = new Date();
			}
		}
		
		if (!p.isLive()) {
			printInfo(g, "GAME OVER", 50, 100, 200, Color.RED);
			int period = (int)((endTime.getTime() - startTime.getTime())/1000);
			printInfo(g, "����ʱ�䣺 " + period + "��", 20, 120, 260, Color.BLUE);
			
			switch(period / 10) {
				case 0:
				case 1:
					printInfo(g, "����", 50, 120, 400, Color.RED);
				break;
				case 2:
					printInfo(g, "С��", 50, 120, 400, Color.RED);
				break;
				case 3:
					printInfo(g, "����", 50, 120, 400, Color.RED);
				break;
				case 4:
					printInfo(g, "����", 50, 120, 400, Color.RED);
				break;
				default:
					printInfo(g, "����", 50, 120, 220, Color.RED);
					break;
			}
			
			
			
		} else {
			long period = (middleTime.getTime() - startTime.getTime())/1000;
			printInfo(g, " �Ѿ�����ʱ�䣺 " + period + "��", 20, Constant.GAME_WIDTH-300, 50, Color.PINK);
		}
		
		
		//printInfo(g, "Grades: 100", 20, 50, 50, Color.YELLOW);
	}
	
	/**
	 * �ڴ����ϴ�ӡ��Ϣ
	 * @param g
	 * @param str
	 * @param size
	 */
	public void printInfo(Graphics g, String str, int size, int x, int y, Color color) {
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("����", Font.BOLD, size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
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
		
		startTime = new Date();
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
