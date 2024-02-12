package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import database.DataBaseImpl;
import panels.Constants;
import panels.CustomerSignIn;
import panels.ReservationPanel;
import services.AccountsServiceImpl;
import dto.Customer; // Import the Customer class

public class PlatePlanMain {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        AccountsServiceImpl accountsService = new AccountsServiceImpl();
        accountsService.registerAccount("test", "test", "test", "test");
        DataBaseImpl db = DataBaseImpl.getInstance();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PlatePlanMain window = new PlatePlanMain();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public PlatePlanMain() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Start with the CustomerSignIn panel
        switchPanels(new CustomerSignIn(this));
    }

    /**
     * Method to switch between panels
     */
    public void switchPanels(JPanel panel) {
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.removeAll();
        contentPane.add(panel);
        contentPane.revalidate();
        contentPane.repaint();
    }

    /**
     * Method to handle successful login and switch to ReservationPanel
     */
    public void onCustomerSignedIn(String email) {
        switchPanels(new ReservationPanel(email));
    }
}
