package businessPanels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;

import customerPanels.Constants;
import customerPanels.InitialView;
import dto.Business;
import main.PlatePlanMain;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusinessHomeView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private Business business;

	/**
	 * Create the panel.
	 */
	public BusinessHomeView(Business bussiness) {
		setFont(new Font("Calibri", Font.PLAIN, 18));
		//========================Setting Default Dimensions========================
		Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
		this.setPreferredSize(windowDim);
		this.setMinimumSize(windowDim);
		this.setMaximumSize(windowDim);
		setLayout(null);
		setBackground(new Color(255, 250, 250));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	//===========================================================================
		this.business = bussiness;
		lblNewLabel = new JLabel("BUSINESS MANAGEMENT");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setBounds(429, 105, 370, 28);
		add(lblNewLabel);
		
		//Button to open another panel(reservationHomeView)
		JButton btnNewButton = new JButton("View & Manage Reservations");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlatePlanMain.switchPanels(new BusinessReservations(business));
			}
		});
		btnNewButton.setBounds(429, 144, 231, 23);
		add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlatePlanMain.switchPanels(new InitialView());
			}
		});
		btnLogOut.setBounds(6, 6, 117, 29);
		add(btnLogOut);
	}
}
