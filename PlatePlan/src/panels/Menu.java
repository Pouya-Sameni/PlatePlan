package panels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JList;

public class Menu extends JPanel{
	
	public Menu() {
	//========================Setting Default Dimensions========================
			Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
			this.setPreferredSize(windowDim);
			this.setMinimumSize(windowDim);
			this.setMaximumSize(windowDim);
			setLayout(null);
			setBackground(new Color(255, 250, 250));
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			
			JList list = new JList();
			list.setBounds(250, 201, 287, 417);
			add(list);
			
			JLabel appetizersLabel = new JLabel("Appetizers");
			appetizersLabel.setBounds(6, 6, 197, 37);
			appetizersLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			add(appetizersLabel);
			
			JLabel appetizer1 = new JLabel("Garlic Cheese Toast");
			appetizer1.setBounds(6, 61, 132, 16);
			add(appetizer1);
			
			JLabel appetizer2 = new JLabel("Bruschetta");
			appetizer2.setBounds(6, 89, 83, 16);
			add(appetizer2);
			
			JLabel appetizer3 = new JLabel("Provolone Sticks");
			appetizer3.setBounds(6, 116, 132, 16);
			add(appetizer3);
			
			JLabel mainDishLabel = new JLabel("Main Dishes");
			mainDishLabel.setBounds(6, 181, 197, 37);
			mainDishLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			add(mainDishLabel);
			
			JLabel mainDish1 = new JLabel("Spaghetti with Meat Sauce");
			mainDish1.setBounds(6, 237, 169, 16);
			add(mainDish1);
			
			JLabel mainDish2 = new JLabel("Seafood Linguine");
			mainDish2.setBounds(6, 262, 108, 16);
			add(mainDish2);
			
			JLabel mainDish3 = new JLabel("Chicken Alfredo");
			mainDish3.setBounds(6, 287, 108, 16);
			add(mainDish3);
			
			JLabel dessertLabel = new JLabel("Desserts");
			dessertLabel.setBounds(6, 331, 158, 37);
			dessertLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			add(dessertLabel);
			
			JLabel dessert1 = new JLabel("Caramel Apple Crepe");
			dessert1.setBounds(6, 393, 169, 16);
			add(dessert1);
			
			JLabel dessert2 = new JLabel("Hummingbird Cake");
			dessert2.setBounds(6, 418, 169, 16);
			add(dessert2);
			
			JLabel dessert3 = new JLabel("Sky High Carrot Cake");
			dessert3.setBounds(6, 442, 169, 16);
			add(dessert3);
			
			JLabel beveragesLabel = new JLabel("Beverages");
			beveragesLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			beveragesLabel.setBounds(6, 483, 158, 37);
			add(beveragesLabel);
			
			JLabel beverages1 = new JLabel("Sparkling Water");
			beverages1.setBounds(6, 532, 169, 16);
			add(beverages1);
			
			JLabel beverages2 = new JLabel("Soft Drink");
			beverages2.setBounds(6, 560, 169, 16);
			add(beverages2);
			
			JLabel beverages3 = new JLabel("Lemonade");
			beverages3.setBounds(6, 588, 169, 16);
			add(beverages3);
			
			
			
			
			DefaultListModel DLM = new DefaultListModel();
			
			
		
	}
}
