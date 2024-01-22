import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView {
    private JPanel homepanel;
    private JButton confirmbutton;


    public HomeView (){

        confirmbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"ALERT");
            }
        });
    }

    public static void main (String [] args)
    {
        JFrame frame = new JFrame("PlatePlan");
        frame = new JFrame();
        frame.setBounds(100, 100, 852, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new HomeView().homepanel);
        frame.setVisible(true);
    }

}

