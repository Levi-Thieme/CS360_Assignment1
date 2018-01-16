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
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAddSite;
	private JButton btnEdit;
	private JButton btnDelete;
	private JTextPane descriptionTextPane;
	private JTextField nameField;
	private JList<String> markerList;
	private JTextField updatedByField;
	private JTextField timeField;
	




	private JTextField dateField;
	
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
		
		JMenuItem mntmUpload = new JMenuItem("Upload");
		mnFile.add(mntmUpload);
		
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
		panel_2.setPreferredSize(new Dimension(10, 230));
		panel.add(panel_2, BorderLayout.NORTH);
		
		markerList = new JList<String>(listModel);
		markerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(markerList);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(200, 150));
		panel_2.add(scrollPane);
		
		JLabel label = new JLabel("Sites");
		scrollPane.setColumnHeaderView(label);
		
		
		
		
		
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
		panel_3.setPreferredSize(new Dimension(10, 300));
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
		latField.setPreferredSize(new Dimension(140, 20));
		panel_3.add(latField);
		latField.setColumns(10);
		latField.setEditable(false);
		
		JLabel lblDescription = new JLabel("Description");
		panel_3.add(lblDescription);
		
		descriptionTextPane = new JTextPane();
		descriptionTextPane.setEditable(false);
		descriptionTextPane.setPreferredSize(new Dimension(200, 200));
		panel_3.add(descriptionTextPane);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(50, 2));
		panel_3.add(separator_1);
		
		JLabel lblUpdated = new JLabel("Updated");
		lblUpdated.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblUpdated);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(40, 2));
		panel_3.add(separator);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setPreferredSize(new Dimension(80, 14));
		panel_3.add(lblDate);
		
		dateField = new JTextField();
		dateField.setEditable(false);
		dateField.setColumns(10);
		panel_3.add(dateField);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setPreferredSize(new Dimension(80, 14));
		panel_3.add(lblTime);
		
		timeField = new JTextField();
		timeField.setEditable(false);
		panel_3.add(timeField);
		timeField.setColumns(10);
		
		JLabel lblTakenBy = new JLabel("Updated By:");
		lblTakenBy.setPreferredSize(new Dimension(80, 14));
		panel_3.add(lblTakenBy);
		
		updatedByField = new JTextField();
		updatedByField.setEditable(false);
		panel_3.add(updatedByField);
		updatedByField.setColumns(10);
		
		
		
		getContentPane().add(map, BorderLayout.CENTER);
		
		JPanel mapPane = new JPanel();
		mapPane.setPreferredSize(new Dimension(770, 10));
		
		
		JPanel map_panel = new JPanel();
		map_panel.setLayout(new BorderLayout());
		getContentPane().add(map_panel, BorderLayout.CENTER);
		
		map_panel.add(map, BorderLayout.CENTER);
		
		
		map_panel.add(map);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 70));
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
	public JTextField dateField() {
		return dateField;
	}
	public JTextField getUpdatedByField() {
		return updatedByField;
	}
	public JTextField getDateField() {
		return dateField;
	}
	public void setDateField(JTextField dateField) {
		this.dateField = dateField;
	}


	public JTextField getTimeField() {
		return timeField;
	}
	public void setTimeField(JTextField timeField) {
		this.timeField = timeField;
	}

	public JTextPane getDescriptionPane() {
		return descriptionTextPane;
	}




	public JList<String> getMarkerList() {
		return markerList;
	}
}


