package com.bot.io;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.database.model.Babarendorf;
public class Filehandler {
	/**
	 * LoadImage lädt den Screenshot, schneidet das Bild aus und gibt das Icon
	 * zurueck.
	 * 
	 * @param path
	 *            - Der Screenshot
	 * @param rect
	 *            - Der auszuschneidende Bereich
	 * @return - Das ausgeschnittene Icon
	 */
	public static BufferedImage loadImage(File path, Rectangle rect) {
		// Keine Referenz auf Screenshot behalten

		BufferedImage screenshot = load(path);

		BufferedImage icon = screenshot.getSubimage(rect.x, rect.y, rect.width, rect.height);

		saveIcon(icon);

		return icon;
	}

	private static void saveIcon(BufferedImage icon) {

		try {
			ImageIO.write(icon, "png", new File("C:\\Temp\\x.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static BufferedImage load(File path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(path);
		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}

		return image;
	}

	public static ArrayList<Babarendorf> readData(File path) {
		ArrayList<Babarendorf> list = new ArrayList<Babarendorf>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			do {
				String tmp = br.readLine();
				if (tmp != null) {
					String[] tmp2 = tmp.split("|");
					int x = Integer.parseInt((tmp2[0] + tmp2[1] + tmp2[2]));
					int y = Integer.parseInt((tmp2[4] + tmp2[5] + tmp2[6]));
					long gefarmed = Long.parseLong(tmp.substring(8, tmp.length()));
					list.add(new Babarendorf(x, y, gefarmed));
				} else {
					break;
				}

			} while (true);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}

}
