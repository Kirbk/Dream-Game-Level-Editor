package le.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import le.core.GlobalVars;
import le.core.ToolID;

public class SubtractButton extends JButton {
	private static final long serialVersionUID = 1L;

	public SubtractButton() {
		try {
			Image img = ImageIO.read(getClass().getResource("/resources/subtract.png"));
			setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setToolTipText("Add entity/texture");
		setPreferredSize(new Dimension(30, 30));
		setMnemonic(KeyEvent.VK_S);
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalVars.currentTool = ToolID.SUBTRACT_TOOL;
	         }          
		});
	}
}
