package le.core;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EntityTileFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public EntityTileFrame(String name) {
		super(name);
		this.setContentPane(new EntityTilePanel());
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setSize(new Dimension(200, 600));
		this.setResizable(false);
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 0);
		this.setVisible(true);
	}
}

class EntityTilePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
}