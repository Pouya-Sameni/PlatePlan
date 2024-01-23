package panels;

import java.awt.Dimension;
import javax.swing.JPanel;

import main.PlatePlanMain;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitialView extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public InitialView() {
		Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
		this.setPreferredSize(windowDim);
		this.setMinimumSize(windowDim);
		this.setMaximumSize(windowDim);
		setLayout(null);
		
		JButton customerView = new JButton("Customer Sign In");
		customerView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlatePlanMain.switchPanels(new CustomerSignIn());
			}
		});
		customerView.setBounds(450, 275, 174, 29);
		add(customerView);
	}

}
