package views;

import javax.swing.*;

import com.teamdev.jxmaps.Map;

import models.SiteMap;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * The ApplicationFrame is the base view for the application.
 * All other views are accessed through this view.
 * @author Levi Thieme
 *
 */
public class ApplicationFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JMenuItem mntmSave;
	JMenuItem mntmExit;
	JMenuItem mntmAddSite;
	
	public ApplicationFrame(SiteMap map) {
		setPreferredSize(new Dimension(1000, 800));
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//this.setUndecorated(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic(KeyEvent.VK_E);
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		mntmAddSite = new JMenuItem("Add Site");
		mnEdit.add(mntmAddSite);
		
		
		getContentPane().add(map, BorderLayout.CENTER);
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 10));
		getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 75));
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setPreferredSize(new Dimension(80, 80));
		panel_1.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setPreferredSize(new Dimension(80, 80));
		panel_1.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 60));
		panel.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblSiteName = new JLabel("Site Name: ");
		lblSiteName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSiteName.setPreferredSize(new Dimension(100, 50));
		panel_2.add(lblSiteName);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		
		JLabel lblId = new JLabel("Number: ");
		panel_3.add(lblId);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(25, 2));
		panel_3.add(separator);
		
		JLabel lblNewLabel = new JLabel("Longitude:");
		lblNewLabel.setPreferredSize(new Dimension(60, 14));
		panel_3.add(lblNewLabel);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(20, 2));
		panel_3.add(separator_1);
		
		JLabel lblLatitude = new JLabel("Latitude:");
		panel_3.add(lblLatitude);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setPreferredSize(new Dimension(30, 2));
		panel_3.add(separator_2);
		
		JLabel lblUpdated = new JLabel("Updated:");
		panel_3.add(lblUpdated);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setPreferredSize(new Dimension(40, 2));
		panel_3.add(separator_3);
		
		JLabel lblDescription = new JLabel("Description");
		panel_3.add(lblDescription);
		
		JTextPane textPane = new JTextPane();
		textPane.setPreferredSize(new Dimension(200, 300));
		panel_3.add(textPane);
		
		
		
	
		
		
		
		this.setVisible(true);
		
		
		
	}
	
	public JMenuItem getMntmSave() {
		return mntmSave;
	}
	public JMenuItem getMntmExit() {
		return mntmExit;
	}
	public JMenuItem getMntmAddSite() {
		return mntmAddSite;
	}
}
