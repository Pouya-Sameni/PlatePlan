package customerPanels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;

import dto.Customer;
import main.PlatePlanMain;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;

public class CustomerHomeView extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CustomerHomeView(Customer customer) {
		//========================Setting Default Dimensions========================
		Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
		this.setPreferredSize(windowDim);
		this.setMinimumSize(windowDim);
		this.setMaximumSize(windowDim);
		setLayout(null);
		setBackground(new Color(255, 250, 250));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		//===========================================================================

		JButton btnMakeReservation = new JButton("Reserve Table");
		btnMakeReservation.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlatePlanMain.switchPanels(new CustomerReservations(customer));
			}
		});
		btnMakeReservation.setBounds(466, 153, 152, 29);
		add(btnMakeReservation);
		
		JLabel lblWelcome = new JLabel(String.format("Welcome to Alfredo's Reservation Service %s", customer.getFirstName()));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblWelcome.setBounds(150, 23, 800, 48);
		add(lblWelcome);
		
		
	}
}
