package views;

import javax.swing.JPanel;

import plateplan.Main;
import views.SignIn;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeView extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public HomeView() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(168, 107, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Business Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.switchPanels(new SignIn());
//				JOptionPane.showMessageDialog(null, "ALERT");
				
			}
		});
		btnNewButton_1.setBounds(151, 183, 156, 29);
		add(btnNewButton_1);

	}
}
