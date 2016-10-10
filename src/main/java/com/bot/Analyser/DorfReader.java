package com.bot.Analyser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.jboss.jandex.Main;
import org.joda.time.LocalDateTime;

import com.bot.model.Babarendorf;

public class DorfReader {
	
	private BufferedImage i;
	private List<Babarendorf> list;


	public DorfReader(String path) {
		super();
		try {
			this.i = ImageIO.read(new File(path));
			this.list = new ArrayList<Babarendorf>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void doIt(){
		//212 212
		for(int x = 212; x < i.getWidth(); x++){
			for(int y = 212; y < i.getHeight(); y++){
				if(i.getRGB(x, y) == -10066330 && i.getRGB(x+1, y) == -10066330 && i.getRGB(x, y+1) == -10066330 && i.getRGB(x+1, y +1) == -10066330)
					list.add(new Babarendorf(0,x,y ,new LocalDateTime()));
			}
		}
		
		
	}
	public static void main(String[] args) {
		DorfReader r = new DorfReader("C:\\Users\\Effi\\Desktop\\Raster.png");
		r.doIt();
		System.out.println("");
	}
	
	
	
	
	 

}
