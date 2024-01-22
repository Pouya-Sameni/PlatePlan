import javax.swing.*;

public class Main {
    private static JFrame mainFrame;
    public static void main (String [] args)
    {
        mainFrame = new JFrame("PlatePlan");
        mainFrame = new JFrame();
        mainFrame.setBounds(100, 100, 1000, 700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setContentPane(new HomeView().homepanel);
        mainFrame.setVisible(true);
    }

    public static void switchPanels (JPanel panel)
    {
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(new JPanel());
    }

}
