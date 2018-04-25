package theChildOfGod.util;

import java.awt.Frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.omg.Messaging.SyncScopeHelper;

public class MyFrame extends Frame {

	
	/**
	 * ���ش���
	 */
	public void launchFrame() {
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		setLocation(100, 100);
		setVisible(true);

		new PaintThread().start(); // �����ػ��߳�

		addWindowListener(new WindowAdapter() { // ͨ���������ֱ�ӹرմ���
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}

	private double x = 100, y = 100;
	private double degree = 3.14 / 3; // [0, 2pi]
	private double speed = 100;

	@Override
	public void paint(Graphics g) {

		if (speed > 0) {
			speed -= 0.5;
		}
		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);

		if (y > 500 - 50 || y < 30) {
			degree = -degree;
		}

		if (x < 0 || x > 500 - 30) {
			degree = Math.PI - degree;
		}

	}

	/**
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ��ࡣ
	 * 
	 * @author theChildOfGod
	 *
	 */
	class PaintThread extends Thread {

		public void run() {
			while (true) {
				try {
					repaint();
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
