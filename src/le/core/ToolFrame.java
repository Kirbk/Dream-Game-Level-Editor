package le.core;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import le.gui.AddButton;
import le.gui.SubtractButton;

public class ToolFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public ToolFrame(String name) {
		super(name);
		this.setContentPane(new ToolPanel());
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setSize(new Dimension(250, 600));
		this.setResizable(false);
		this.setLocation(0, 0);
		this.setVisible(true);
	}
}

class ToolPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public ToolPanel() {
		this.add(new AddButton());
		this.add(new SubtractButton());
	}
}