package panels;

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

public class CustomerHomeView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;

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
		
		lblNewLabel = new JLabel("Customer HOME VIEW");
		lblNewLabel.setBounds(481, 342, 138, 16);
		add(lblNewLabel);
		
		JButton btnMakeReservation = new JButton("Reserve Table");
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlatePlanMain.switchPanels(new ReservationPanel(customer));
			}
		});
		btnMakeReservation.setBounds(123, 373, 110, 35);
		add(btnMakeReservation);
	//===========================================================================
		
		
	}
}
