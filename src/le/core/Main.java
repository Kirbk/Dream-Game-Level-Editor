package le.core;

import java.awt.MouseInfo;

public class Main {
	public Main() {
		GlobalVars.editorFrame = new EditorFrame(GlobalVars.name, GlobalVars.version);
		GlobalVars.toolFrame = new ToolFrame("Tools");
		GlobalVars.etFrame = new EntityTileFrame("Entities & Tiles");
		
		gameloop();
	}
	
	public void gameloop() {
		final double GAME_HERTZ = 30.0;
		final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
		final int MAX_UPDATES_BEFORE_RENDER = 5;
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime = System.nanoTime();
		final double TARGET_FPS = 60;
		final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;
		int lastSecondTime = (int) (lastUpdateTime / 1000000000);
		
		while(true) {
			double now = System.nanoTime();
			int updateCount = 0;
			
			while(now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER) {
				//UPDATE HERE
				
				if(GlobalVars.mouse.contains(1)) {
					GlobalVars.currentMousePosition = new Vector2D(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
					int dx = GlobalVars.currentMousePosition.x - GlobalVars.previousMousePosition.x;
					int dy = GlobalVars.currentMousePosition.y - GlobalVars.previousMousePosition.y;
					
					GlobalVars.scrollX += dx;
					GlobalVars.scrollY += dy;
					
					GlobalVars.previousMousePosition = GlobalVars.currentMousePosition;
				}
				
				lastUpdateTime += TIME_BETWEEN_UPDATES;
				updateCount++;
			}
			
			if(now - lastUpdateTime > TIME_BETWEEN_UPDATES) {
				lastUpdateTime = now - TIME_BETWEEN_UPDATES;
			}
			
			GlobalVars.interpolation = Math.min(1.0f, (float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES));
			GlobalVars.editorFrame.repaint();
			lastRenderTime = now;
			
			int thisSecond = (int) (lastUpdateTime / 1000000000);
			if(thisSecond > lastSecondTime) {
				GlobalVars.fps = GlobalVars.frameCount;
				GlobalVars.frameCount = 0;
				lastSecondTime = thisSecond;
			}
			
			while(now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES) {
				Thread.yield();
				
				try {Thread.sleep(1);} catch(Exception e) {} 
				
				now = System.nanoTime();
			}
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
