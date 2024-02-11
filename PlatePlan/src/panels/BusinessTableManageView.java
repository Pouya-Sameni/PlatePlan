package panels;

import java.awt.Color;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.TableRowSorter;

public class BusinessTableManageView extends JPanel{
	private JTextField textID;
	private JTextField textCapacity;
	private DefaultTableModel model;
	private JTable table;
	private JTextField textSearch;
	public BusinessTableManageView() {
		//========================Setting Default Dimensions========================
		Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
		this.setPreferredSize(windowDim);
		this.setMinimumSize(windowDim);
		this.setMaximumSize(windowDim);
		setLayout(null);
		setBackground(new Color(255, 250, 250));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	//===========================================================================
			
			JLabel lblNewLabel = new JLabel("ID:");
			lblNewLabel.setBounds(709, 86, 46, 14);
			add(lblNewLabel);
			
			JLabel lblCapacity = new JLabel("Capacity: ");
			lblCapacity.setBounds(709, 114, 54, 14);
			add(lblCapacity);
			
			JLabel lblNewLabel_1_1 = new JLabel("Server: ");
			lblNewLabel_1_1.setBounds(709, 142, 46, 14);
			add(lblNewLabel_1_1);
			
			textID = new JTextField();
			textID.setBounds(765, 83, 168, 20);
			add(textID);
			textID.setColumns(10);
			
			textCapacity = new JTextField();
			textCapacity.setBounds(766, 111, 168, 20);
			textCapacity.setColumns(10);
			add(textCapacity);
			
			JComboBox serverBox = new JComboBox();
			serverBox.setModel(new DefaultComboBoxModel(new String[] {"Select Server", "Ricky", "Dereck", "John", "Fish"}));
			serverBox.setBounds(765, 138, 168, 22);
			add(serverBox);
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.setBounds(713, 221, 89, 23);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					    DefaultTableModel model = (DefaultTableModel) table.getModel();
					    model.addRow(new Object[] {textID.getText(), textCapacity.getText(), serverBox.getSelectedItem()});
				}
			});
			add(btnNewButton);
			
			JButton btnChange = new JButton("Change");
			btnChange.setBounds(859, 221, 89, 23);
			btnChange.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					if (table.getSelectedRowCount() == 1) {
						Object id = textID.getText();
						Object capacity = textCapacity.getText();
						Object server = serverBox.getSelectedItem();
						
						model.setValueAt(id,table.getSelectedRow(), 0);
						model.setValueAt(capacity, table.getSelectedRow(), 1);
						model.setValueAt(server, table.getSelectedRow(), 2);
					}
				}
			});
			add(btnChange);
			
			JButton btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.removeRow(table.getSelectedRow());
				}
			});
			btnRemove.setBounds(713, 255, 89, 23);
			add(btnRemove);
			
			JButton btnReset = new JButton("Reset");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textID.setText("");
					textCapacity.setText("");
					serverBox.setSelectedItem("Select Server");
				}
			});
			btnReset.setBounds(859, 255, 89, 23);
			add(btnReset);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(56, 66, 579, 562);
			add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					Object tableID = model.getValueAt(table.getSelectedRow(), 0);
					Object tableCapacity = model.getValueAt(table.getSelectedRow(), 1);
					Object tableServer = model.getValueAt(table.getSelectedRow(), 2);
					
					
					textID.setText((String) tableID);
					textCapacity.setText((String) tableCapacity);
					serverBox.setSelectedItem(tableServer);
					
				}
			});
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
			
			textSearch = new JTextField();
			textSearch.setToolTipText("");
			textSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					TableRowSorter<DefaultTableModel> model1 = new TableRowSorter<>(model);
					table.setRowSorter(model1);
					model1.setRowFilter(RowFilter.regexFilter(textSearch.getText()));
				}
			});
			textSearch.setColumns(10);
			textSearch.setBounds(143, 35, 168, 20);
			add(textSearch);
			
			JLabel lblSearch = new JLabel("Search:");
			lblSearch.setBounds(87, 38, 46, 14);
			add(lblSearch);
			
			
	}
}
