package panels;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import main.PlatePlanMain;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusinessSignIn extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public BusinessSignIn() {
		//========================Setting Default Dimensions========================
			Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
			this.setPreferredSize(windowDim);
			this.setMinimumSize(windowDim);
			this.setMaximumSize(windowDim);
			setLayout(null);
			setBackground(new Color(255, 250, 250));
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		//===========================================================================
			
			
			JLabel welcomeLabel = new JLabel("Sign In");
			welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 26));
			welcomeLabel.setBounds(417, 36, 266, 127);
			add(welcomeLabel);
			
			username = new JTextField();
			username.setBounds(425, 200, 250, 30);
			add(username);
			username.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(425, 301, 250, 30);
			add(passwordField);
			
			JLabel lblUser = new JLabel("Username");
			lblUser.setBounds(425, 175, 120, 16);
			add(lblUser);
			
			JLabel lblPass = new JLabel("Password");
			lblPass.setBounds(425, 283, 120, 16);
			add(lblPass);
			
			JButton btnSignIn = new JButton("Sign In");
			btnSignIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnSignIn.setBounds(491, 394, 117, 29);
			add(btnSignIn);

			
	}
}
