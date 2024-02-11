package panels;

import java.awt.Color;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
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

import dto.Table;

public class BusinessTableManageView extends JPanel{
	private JTextField textID;
	private JTextField textCapacity;
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
		
			JLabel welcomeLabel = new JLabel("Table Manager");
			welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 26));
			welcomeLabel.setBounds(694, 111, 266, 62);
			add(welcomeLabel);
			
			JLabel lblid = new JLabel("ID:");
			lblid.setBounds(709, 236, 46, 14);
			add(lblid);
			
			JLabel lblCapacity = new JLabel("Capacity: ");
			lblCapacity.setBounds(709, 264, 54, 14);
			add(lblCapacity);
			
			JLabel lblServer = new JLabel("Server: ");
			lblServer.setBounds(709, 292, 46, 14);
			add(lblServer);
			
			textID = new JTextField();
			textID.setFont(new Font("Arial", Font.PLAIN, 11));
			textID.setBounds(765, 233, 168, 20);
			add(textID);
			textID.setColumns(10);
			
			textCapacity = new JTextField();
			textCapacity.setFont(new Font("Arial", Font.PLAIN, 11));
			textCapacity.setBounds(766, 261, 168, 20);
			textCapacity.setColumns(10);
			add(textCapacity);
			
			
			JComboBox serverBox = new JComboBox();
			serverBox.setFont(new Font("Arial", Font.PLAIN, 12));
			serverBox.setModel(new DefaultComboBoxModel(new String[] {"Select Server", "Ricky", "Dereck", "John", "Fish"}));
			serverBox.setBounds(765, 288, 168, 22);
			add(serverBox);
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
			btnNewButton.setBounds(713, 371, 89, 23);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					if (textID.getText().equals("") || textCapacity.getText().equals("") || serverBox.getSelectedItem().equals("Select Server"))
					{
						// do nothing
					}
					else 
					{
						model.addRow(new Object[] {textID.getText(), textCapacity.getText(), serverBox.getSelectedItem()});
					}
				}
			});
			add(btnNewButton);
			
			JButton btnChange = new JButton("Change");
			btnChange.setFont(new Font("Arial", Font.PLAIN, 12));
			btnChange.setBounds(859, 371, 89, 23);
			btnChange.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					if (table.getSelectedRowCount() == 1) {
						Object id = textID.getText();
						Object capacity = textCapacity.getText();
						Object server = serverBox.getSelectedItem();
						if (textID.getText().equals("") || textCapacity.getText().equals("") || serverBox.getSelectedItem().equals("Select Server"))
						{
							// do nothing
						}
						else 
						{
							model.setValueAt(id,table.getSelectedRow(), 0);
							model.setValueAt(capacity, table.getSelectedRow(), 1);
							model.setValueAt(server, table.getSelectedRow(), 2);
						}
					}
				}
			});
			add(btnChange);
			
			JButton btnRemove = new JButton("Remove");
			btnRemove.setFont(new Font("Arial", Font.PLAIN, 12));
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.removeRow(table.getSelectedRow());
				}
			});
			btnRemove.setBounds(713, 405, 89, 23);
			add(btnRemove);
			
			JButton btnReset = new JButton("Reset");
			btnReset.setFont(new Font("Arial", Font.PLAIN, 12));
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textID.setText("");
					textCapacity.setText("");
					serverBox.setSelectedItem("Select Server");
				}
			});
			btnReset.setBounds(859, 405, 89, 23);
			add(btnReset);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(56, 66, 579, 562);
			add(scrollPane);
			
			table = new JTable();
			table.setFont(new Font("Arial", Font.PLAIN, 12));
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
			textSearch.setFont(new Font("Arial", Font.PLAIN, 11));
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
