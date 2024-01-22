package views;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class SignIn extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public SignIn() {
		setLayout(null);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(136, 109, 191, 26);
		add(formattedTextField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(136, 183, 191, 26);
		add(passwordField);

	}
}
