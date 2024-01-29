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

public class CustomerSignUp extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField passwordField;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtPass;
	private static int TEXT_FIELD_LENGTH = 250;
	private static int TEXT_FIELD_WIDTH = 40;
	private JButton btnSignUp;
	private JLabel lblFName;
	private JLabel lblLName;
	private JLabel lblEmail;
	private JLabel lblPass;
	/**
	 * Create the panel.
	 */
	public CustomerSignUp() {
		//========================Setting Default Dimensions========================
			Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
			this.setPreferredSize(windowDim);
			this.setMinimumSize(windowDim);
			this.setMaximumSize(windowDim);
			setLayout(null);
			setBackground(new Color(255, 250, 250));
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		//===========================================================================
			

			JLabel lblSignUp = new JLabel("Let's Get You Started");
			lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
			lblSignUp.setFont(new Font("Arial", Font.PLAIN, 26));
			lblSignUp.setBounds(329, 36, 441, 127);
			add(lblSignUp);
			
			txtFirstName = new JTextField();
			txtFirstName.setBounds(425, 171, TEXT_FIELD_LENGTH, TEXT_FIELD_WIDTH);
			add(txtFirstName);
			txtFirstName.setColumns(10);
			
			txtLastName = new JTextField();
			txtLastName.setBounds(425, 241, TEXT_FIELD_LENGTH, TEXT_FIELD_WIDTH);
			add(txtLastName);
			txtLastName.setColumns(10);
			
			txtEmail = new JTextField();
			txtEmail.setBounds(425, 311, TEXT_FIELD_LENGTH, TEXT_FIELD_WIDTH);
			add(txtEmail);
			txtEmail.setColumns(10);
			
			txtPass = new JTextField();
			txtPass.setBounds(425, 381, TEXT_FIELD_LENGTH, TEXT_FIELD_WIDTH);
			add(txtPass);
			txtPass.setColumns(10);
			
			btnSignUp = new JButton("SignUp");
			btnSignUp.setBounds(491, 441, 117, 29);
			add(btnSignUp);
			
			lblFName = new JLabel("First Name");
			lblFName.setBounds(425, 152, 100, 16);
			add(lblFName);
			
			lblLName = new JLabel("Last Name");
			lblLName.setBounds(425, 223, 100, 16);
			add(lblLName);
			
			lblEmail = new JLabel("Email");
			lblEmail.setBounds(425, 293, 100, 16);
			add(lblEmail);
			
			lblPass = new JLabel("Password");
			lblPass.setBounds(425, 363, 100, 16);
			add(lblPass);
			
			
	}
}
