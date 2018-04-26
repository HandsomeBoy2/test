package theChildOfGod.plane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import theChildOfGod.util.GameUtil;

public class Plane extends GameObject {
	private boolean left, up, right, down;

	private boolean live = true;

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g) {
		if (live) {
			g.drawImage(img, (int) x, (int) y, 20, 20, null);
			move();
		}
	}

	// 实现飞机四个方向飞行
	/*
	 * public void move(KeyEvent e) { switch(e.getKeyCode()) { case 37: x -= speed;
	 * break; case 38: y -= speed; break; case 39: x += speed; break; case 40: y +=
	 * speed; break; } }
	 */
	public void move() {
		if (left) {
			x -= speed;
		}
		if (right) {
			x += speed;
		}
		if (up) {
			y -= speed;
		}
		if (down) {
			y += speed;
		}
	}

	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
			break;
		}
	}

	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
			break;
		}
	}

	public Plane(String imgpath, double x, double y) {
		super();
		this.img = GameUtil.getImage(imgpath);
		this.width = 10;
		this.height = 10;
		this.x = x;
		this.y = y;
	}

	public Plane() {
	}

}
