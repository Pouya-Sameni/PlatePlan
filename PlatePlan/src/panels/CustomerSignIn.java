package panels;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import dto.Customer;
import main.PlatePlanMain;
import service_interfaces.AccountService;
import services.AccountsServiceImpl;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerSignIn extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField username;
    private JPasswordField passwordField;
    private JLabel lblUser;
    private JLabel lblPass;
    private JButton btnSignIn;
    private JButton btnRegister;

    // Added reference to PlatePlanMain
    private PlatePlanMain mainApp;

    /**
     * Create the panel.
     */
    public CustomerSignIn(PlatePlanMain mainApp) {
        this.mainApp = mainApp; // Initialize mainApp

        //========================Setting Default Dimensions========================
        Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
        this.setPreferredSize(windowDim);
        this.setMinimumSize(windowDim);
        this.setMaximumSize(windowDim);
        setLayout(null);
        setBackground(new Color(255, 250, 250));
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        //===========================================================================

        JLabel welcomeLabel = new JLabel("Welcome To Alfredos");
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

        lblUser = new JLabel("Username");
        lblUser.setBounds(425, 175, 120, 16);
        add(lblUser);

        lblPass = new JLabel("Password");
        lblPass.setBounds(425, 283, 120, 16);
        add(lblPass);

        btnSignIn = new JButton("Sign In");
        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                signInCustomer();
            }
        });
        btnSignIn.setBounds(491, 394, 117, 29);
        add(btnSignIn);

        btnRegister = new JButton("Don't have an account? Register Now!");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mainApp.switchPanels(new CustomerSignUp(mainApp));
            }
        });
        btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegister.setBorderPainted(false);
        btnRegister.setForeground(Color.BLUE);
        btnRegister.setBackground(new Color(255, 250, 250));
        btnRegister.setBounds(400, 470, 300, 29);
        add(btnRegister);
        
        
    }

    private void signInCustomer() {
        AccountService accountService = new AccountsServiceImpl();

        String pass = String.valueOf(passwordField.getPassword());
        String email = username.getText(); // Use email instead of the whole customer object
        Customer customer = accountService.login(email, pass);

        if (customer != null) {
            mainApp.onCustomerSignedIn(email); // Pass email to the mainApp
        } else {
            JOptionPane.showMessageDialog(this, "Login failed. Please check your username and password.", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
