package businessPanels;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import dto.Business;
import dto.Customer;
import dto.Server;
import dto.Reservation;
import dto.Table;
import main.PlatePlanMain;
import service_interfaces.AccountService;
import service_interfaces.ReservationService;
import services.AccountsServiceImpl;
import services.ReservationServiceImpl;

import javax.swing.table.DefaultTableModel;

import customerPanels.Constants;
import database.DataBase;
import database.DataBaseFactory;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;

public class BusinessReservations extends JPanel {
	private JTable table;
	private Business business;
	private DataBase db;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private DefaultTableModel tableModel;

	public BusinessReservations(Business business){
	//========================Setting Default Dimensions========================
		Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
		this.setPreferredSize(windowDim);
		this.setMinimumSize(windowDim);
		this.setMaximumSize(windowDim);
		setLayout(null);
		setBackground(new Color(255, 250, 250));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
	//===========================================================================
		
		this.business = business;
		this.db = DataBaseFactory.getDatabase();
		
		btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlatePlanMain.switchPanels(new BusinessHomeView(business));
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		add(btnNewButton);
		
		lblNewLabel = new JLabel("Current Reservations");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel.setBounds(194, 69, 464, 34);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(48, 114, 800, 450);
		add(scrollPane_1);
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		
		tableModel = new DefaultTableModel(
				new String[] {
						"Date", "Time","Customer ID" ,"Party Size", "Special Notes", "Server", "Table ID", 
					},0
				);
		table.setModel(tableModel);
		
		for (Reservation r: db.getAllReservations())
		{
			tableModel.addRow(new Object[] {r.getDate(),String.format("%s - %s", r.getTime().getFrom(), r.getTime().getTo()),
					r.getCustomerId(), r.getPartySize(), r.getSpecialNotes(),
					r.getServerId()== null || r.getServerId().isEmpty()? "Unassigned": r.getServerId(), r.getTableId()});
		}
		PlatePlanMain.refreshPage();
		
		
		
		
	}
}
