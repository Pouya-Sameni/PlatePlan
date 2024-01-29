package panels;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class CustomerSignIn extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public CustomerSignIn() {
		//========================Setting Default Dimensions========================
			Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
			this.setPreferredSize(windowDim);
			this.setMinimumSize(windowDim);
			this.setMaximumSize(windowDim);
			setLayout(null);
		//===========================================================================
			
			
			JLabel welcomeLabel = new JLabel("Welcome To Alfredos");
			welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 26));
			welcomeLabel.setBounds(408, 128, 266, 127);
			add(welcomeLabel);
			
			username = new JTextField();
			username.setBounds(431, 242, Constants.TEXT_FIELD_LENGTH, Constants.TEXT_FIELD_WIDTH);
			add(username);
			username.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(431, 343, Constants.TEXT_FIELD_LENGTH, Constants.TEXT_FIELD_WIDTH);
			add(passwordField);
			
	}
}
