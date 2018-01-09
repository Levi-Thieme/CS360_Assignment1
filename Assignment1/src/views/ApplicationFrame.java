package views;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;

/**
 * The ApplicationFrame is the base view for the application.
 * All other views are accessed through this view.
 * @author Levi Thieme
 *
 */
public class ApplicationFrame extends JFrame {
	
	
	public ApplicationFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		JMenuItem mntmTableView = new JMenuItem("Table View");
		mntmTableView.setMnemonic(KeyEvent.VK_T);
		mnFile.add(mntmTableView);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic(KeyEvent.VK_E);
		mnFile.add(mntmExit);
		
		JMenuItem mntmEditEntries = new JMenuItem("Edit Entries");
		mntmEditEntries.setMnemonic(KeyEvent.VK_E);
		menuBar.add(mntmEditEntries);
		this.setVisible(true);
		
		
		
	}
}
