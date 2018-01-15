package views;

import javax.swing.*;

import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.Marker;

import models.CollectionSite;
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
	private JTextField numberField;
	private JTextField longField;
	private JTextField latField;
	private JTextField updatedField;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAddSite;
	private JButton btnEdit;
	private JButton btnDelete;
	private JTextPane descriptionTextPane;
	private JTextField nameField;
	private JList<String> markerList;
	
	public ApplicationFrame(SiteMap map, DefaultListModel<String> listModel) {
		getContentPane().setPreferredSize(new Dimension(1000, 800));
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.setMnemonic(KeyEvent.VK_S);
		mnFile.add(mntmSave);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic(KeyEvent.VK_E);
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setMnemonic(KeyEvent.VK_E);
		menuBar.add(mnEdit);
		
		mntmAddSite = new JMenuItem("Add Site");
		mntmAddSite.setMnemonic(KeyEvent.VK_A);
		mnEdit.add(mntmAddSite);
		
				
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 10));
		getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 180));
		panel.add(panel_2, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Sites");
		panel_2.add(label);
		
		markerList = new JList<String>(listModel);
		markerList.setPreferredSize(new Dimension(200, 200));
		markerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_2.add(markerList);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 75));
		panel.add(panel_1, BorderLayout.SOUTH);
		
		btnEdit = new JButton("Edit");
		btnEdit.setPreferredSize(new Dimension(80, 80));
		panel_1.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.setPreferredSize(new Dimension(80, 80));
		panel_1.add(btnDelete);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 350));
		panel.add(panel_3, BorderLayout.CENTER);
		
		JLabel lblName = new JLabel("Name:");
		panel_3.add(lblName);
		
		nameField = new JTextField();
		nameField.setEditable(false);
		panel_3.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblId = new JLabel("Number: ");
		panel_3.add(lblId);
		
		numberField = new JTextField();
		panel_3.add(numberField);
		numberField.setColumns(10);
		numberField.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("Longitude:");
		lblNewLabel.setPreferredSize(new Dimension(60, 14));
		panel_3.add(lblNewLabel);
		
		longField = new JTextField();
		panel_3.add(longField);
		longField.setColumns(10);
		longField.setEditable(false);
		
		JLabel lblLatitude = new JLabel("Latitude:");
		panel_3.add(lblLatitude);
		
		latField = new JTextField();
		panel_3.add(latField);
		latField.setColumns(10);
		latField.setEditable(false);
		
		JLabel lblUpdated = new JLabel("Updated:");
		panel_3.add(lblUpdated);
		
		updatedField = new JTextField();
		panel_3.add(updatedField);
		updatedField.setColumns(10);
		updatedField.setEditable(false);
		
		JLabel lblDescription = new JLabel("Description");
		panel_3.add(lblDescription);
		
		descriptionTextPane = new JTextPane();
		descriptionTextPane.setPreferredSize(new Dimension(200, 300));
		panel_3.add(descriptionTextPane);
		
		
		
		getContentPane().add(map, BorderLayout.CENTER);
		
		JPanel mapPane = new JPanel();
		mapPane.setPreferredSize(new Dimension(770, 10));
		
		
		JPanel map_panel = new JPanel();
		map_panel.setLayout(new BorderLayout());
		getContentPane().add(map_panel, BorderLayout.CENTER);
		
		map_panel.add(map, BorderLayout.CENTER);
		
		
		map_panel.add(map);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 50));
		map_panel.add(panel_4, BorderLayout.NORTH);
		
		
		this.pack();
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
	public JButton getBtnEdit() {
		return btnEdit;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JTextField getNameField() {
		return nameField;
	}
	public JTextField getNumField() {
		return numberField;
	}
	public JTextField getLongField() {
		return longField;
	}
	public JTextField getLatField() {
		return latField;
	}
	public JTextField getUpdatedField() {
		return updatedField;
	}
	public JTextPane getDescriptionPane() {
		return descriptionTextPane;
	}




	public JList<String> getMarkerList() {
		return markerList;
	}
}


