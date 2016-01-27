package le.core;

import java.util.ArrayList;

public class GlobalVars {
	public static final String name = "Level Editor";
	public static final String version = "0.1";
	
	public static EditorFrame editorFrame;
	public static ToolFrame toolFrame;
	public static EntityTileFrame etFrame;
	
	public static float interpolation = 0.0f;
	public static int fps;
	public static int frameCount;
	public static int currentTool = 0;
	public static int scrollX = 0, scrollY = 0;
	public static Vector2D previousMousePosition = new Vector2D(0, 0);
	public static Vector2D currentMousePosition = new Vector2D(0, 0);
	
	public static ArrayList<Integer> mouse = new ArrayList<Integer>();
}
