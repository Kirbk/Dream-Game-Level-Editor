package le.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EditorFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public EditorFrame(String name, String version) {
		super(name);
		this.setContentPane(new EditorPanel());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(800, 600));
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(!GlobalVars.mouse.contains(e.getButton())) {
					GlobalVars.previousMousePosition = new Vector2D(e.getX(), e.getY());
					GlobalVars.mouse.add(e.getButton());
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if(GlobalVars.mouse.contains(e.getButton())) {
					GlobalVars.mouse.remove((Object) e.getButton());
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

class EditorPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public EditorPanel() {
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLACK);
		
		if(GlobalVars.editorFrame != null) {
			g2.fillRect(0, 0, GlobalVars.editorFrame.getWidth(), GlobalVars.editorFrame.getWidth());
		}
		
		g2.setColor(Color.RED);
		g2.fillRect(GlobalVars.scrollX, GlobalVars.scrollY, 16, 16);
		
		g2.setColor(Color.WHITE);
		g2.drawString("(" + GlobalVars.scrollX + ", " + GlobalVars.scrollY + ")", 0, 10);
		
		GlobalVars.frameCount++;
	}
}