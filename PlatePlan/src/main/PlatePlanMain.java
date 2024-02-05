package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.Constants;
import panels.InitialView;
import services.AccountsServiceImpl;
import services.DataBase;

public class PlatePlanMain {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		AccountsServiceImpl accountsService = new AccountsServiceImpl();
		accountsService.registerAccount("test", "test", "test", "test");
		DataBase db = DataBase.getInstance();
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
		switchPanels(new InitialView());
	}
	
	public static void switchPanels (JPanel panel)
    {
        try {
        	JPanel contentPane = (JPanel) frame.getContentPane();

        	contentPane.removeAll();
        	contentPane.add(panel);
        	contentPane.revalidate(); 
        	contentPane.repaint();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
