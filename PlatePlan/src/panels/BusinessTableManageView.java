package panels;

import java.awt.Color;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusinessTableManageView extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DefaultTableModel model;
	private JTable table;
	public BusinessTableManageView() {
		//========================Setting Default Dimensions========================
			Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
			this.setPreferredSize(windowDim);
			this.setMinimumSize(windowDim);
			this.setMaximumSize(windowDim);
			setBackground(new Color(255, 250, 250));
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			setLayout(null);
		//==========================================================================
			
			JLabel lblNewLabel = new JLabel("ID:");
			lblNewLabel.setBounds(86, 600, 46, 14);
			add(lblNewLabel);
			
			JLabel lblCapacity = new JLabel("Capacity: ");
			lblCapacity.setBounds(86, 628, 68, 14);
			add(lblCapacity);
			
			JLabel lblNewLabel_1_1 = new JLabel("Server: ");
			lblNewLabel_1_1.setBounds(86, 656, 46, 14);
			add(lblNewLabel_1_1);
			
			textField = new JTextField();
			textField.setBounds(142, 597, 168, 20);
			add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(143, 625, 168, 20);
			textField_1.setColumns(10);
			add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setBounds(142, 653, 168, 20);
			textField_2.setColumns(10);
			add(textField_2);
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.setBounds(429, 600, 89, 23);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[] {Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()), textField_2.getText()});
				}
			});
			add(btnNewButton);
			
			JButton btnChange = new JButton("Change");
			btnChange.setBounds(575, 600, 89, 23);
			btnChange.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			add(btnChange);
			
			JButton btnRemove = new JButton("Remove");
			btnRemove.setBounds(429, 634, 89, 23);
			add(btnRemove);
			
			JButton btnReset = new JButton("Reset");
			btnReset.setBounds(575, 634, 89, 23);
			add(btnReset);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(78, 52, 939, 507);
			add(scrollPane);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Capacity", "Server"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(15);
			table.setBackground(new Color(255, 255, 255));
			scrollPane.setViewportView(table);
			
	}
}
