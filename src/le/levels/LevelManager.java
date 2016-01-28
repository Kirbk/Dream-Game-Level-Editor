package le.levels;

import java.io.File;
import java.util.ArrayList;

import le.core.GlobalVars;

public class LevelManager {
	public LevelManager() {
		
	}
	
	public void loadLevel(Level level) {
		GlobalVars.currentLevel = level;
	}
	
	public void createLevel(String location) {
		File file = null;
		File[] list = null;
		
		try {
			file = new File(location);
		}catch(Exception e) {
			GlobalVars.logger.log(java.util.logging.Level.SEVERE, "Error: File not found", e);
		}
		
	}
}
