package theChildOfGod.util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

	/**
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ��ࡣ
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
