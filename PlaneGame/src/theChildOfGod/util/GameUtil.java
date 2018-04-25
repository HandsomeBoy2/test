package theChildOfGod.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * ��Ϸ�����г��õĹ����ࣨ���磺����ͼƬ�ȷ�����
 * @author theChildOfGod
 *
 */
public class GameUtil {
	
	private GameUtil() {} //������ͨ���Ὣ���췽��˽����
	
	public static Image getImage(String path) {
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage imag = null;
		try {
			imag = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return  imag;
	}
}
