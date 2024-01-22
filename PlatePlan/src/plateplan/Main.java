package plateplan;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import views.HomeView;

public class Main {

	private static JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		switchPanels(new HomeView());
	}
	
    public static void switchPanels (JPanel panel)
    {
        try {
        	JPanel contentPane = (JPanel) mainFrame.getContentPane();

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
