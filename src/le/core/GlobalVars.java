package le.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import le.levels.Level;
import le.tiles.TileManager;

public class GlobalVars {
	public static final String name = "Level Editor";
	public static final String version = "0.1";
	public static Logger logger;
	
	public static EditorFrame editorFrame;
	public static ToolFrame toolFrame;
	public static EntityTileFrame etFrame;
	public static TileManager tm;
	
	public static float interpolation = 0.0f;
	public static int fps;
	public static int frameCount;
	public static int currentTool = 0;
	public static int scrollX = 0, scrollY = 0;
	public static Vector2D previousMousePosition = new Vector2D(0, 0);
	public static Vector2D currentMousePosition = new Vector2D(0, 0);
	public static int scale = 1;
	public static Level currentLevel;
	
	public static ArrayList<Integer> mouse = new ArrayList<Integer>();
	
	public static void logger() {
		logger = Logger.getLogger(name);
		
		logger.setUseParentHandlers(false);
		LoggerFormatter formatter = new LoggerFormatter();
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(formatter);
		
		logger.addHandler(handler);
	}
}

class LoggerFormatter extends Formatter {
	private static final DateFormat df = new SimpleDateFormat("hh:mm:ss");
	
	@Override
	public String format(LogRecord record) {
		StringBuilder builder = new StringBuilder(10000);
		builder.append(df.format(new Date(record.getMillis()))).append(" : ");
        builder.append("[").append(record.getSourceClassName()).append(".");
        builder.append(record.getSourceMethodName()).append("]");
        builder.append("[").append(record.getLevel()).append("] ");
        builder.append(formatMessage(record));
        builder.append("\n");
        return builder.toString();
	}
	
    public String getHead(Handler h) {
        return super.getHead(h);
    }
 
    public String getTail(Handler h) {
        return super.getTail(h);
    }
}