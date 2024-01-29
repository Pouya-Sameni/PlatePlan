package panels;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Cursor;

public class CustomerSignIn extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public CustomerSignIn() {
		setBackground(new Color(255, 250, 250));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
			welcomeLabel.setBounds(417, 36, 266, 127);
			add(welcomeLabel);
			
			username = new JTextField();
			username.setBounds(425, 200, Constants.TEXT_FIELD_LENGTH, Constants.TEXT_FIELD_WIDTH);
			add(username);
			username.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(425, 301, Constants.TEXT_FIELD_LENGTH, Constants.TEXT_FIELD_WIDTH);
			add(passwordField);
			
			JLabel lblUser = new JLabel("Username");
			lblUser.setBounds(425, 175, 120, 16);
			add(lblUser);
			
			JLabel lblPass = new JLabel("Password");
			lblPass.setBounds(425, 283, 120, 16);
			add(lblPass);
			
			JButton btnSignIn = new JButton("Sign In");
			btnSignIn.setBounds(491, 394, 117, 29);
			add(btnSignIn);
			
			JButton btnRegister = new JButton("Don't have an account? Register Now!");
			btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegister.setBorderPainted(false);
			btnRegister.setForeground(Color.BLUE);
			btnRegister.setBackground(Color.WHITE);
			btnRegister.setBounds(400, 470, 300, 29);
			add(btnRegister);
			
	}
}
