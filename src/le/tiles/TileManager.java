package le.tiles;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import le.core.GlobalVars;

public class TileManager {
	BufferedImage tilesheet;
	ArrayList<BufferedImage> textures = new ArrayList<BufferedImage>();
	
	public TileManager(String tilesheet) {
		loadTileSet(tilesheet);
	}
	
	public void loadTileSet(String path) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(getClass().getResource("/textures/tiles/" + path));
		}catch(Exception e) {
			GlobalVars.logger.log(Level.WARNING, "Error: Missing Tilesheet", e);
		}
		
		this.tilesheet = img;
	}
	
	public void seperate() {
		if((tilesheet.getWidth() % 16) > 0) {
			GlobalVars.logger.log(Level.WARNING, "Tilesheet width not divisible by 16");
		}
		if((tilesheet.getHeight() % 16) > 0) {
			GlobalVars.logger.log(Level.WARNING, "Tilesheet height not divisible by 16");
		}
		
		for(int y = 0; y < tilesheet.getHeight() / 16; y++) {
			for(int x = 0; x < tilesheet.getWidth() / 16; x++) {
				textures.add(tilesheet.getSubimage(x * 16, y * 16, 16, 16));
			}
		}
	}
	
	public void forceID(String texture, int ID) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(getClass().getResource(texture));
		}catch(Exception e) {
			GlobalVars.logger.log(Level.WARNING, "Failed to forceID, texture not found", e);
		}
		
		if(img.getWidth() > 16 || img.getHeight() > 16) {
			GlobalVars.logger.log(Level.WARNING, "Failed to forceID, texture must be 16x16");
		}else {
			GlobalVars.logger.log(Level.INFO, "Forcing texture into ID: " + ID);
			textures.set(ID, img);
		}
	}
	
	public void switchID(int id1, int id2) {
		BufferedImage temp1 = textures.get(id1);
		BufferedImage temp2 = textures.get(id2);
		
		textures.set(id1, temp2);
		textures.set(id2, temp1);
		
		GlobalVars.logger.log(Level.INFO, "Switched texture IDs: " + id1 + " and " + id2);
	}
}