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
	
	double totalCost = 0.00;
	
	public Menu() {
	//========================Setting Default Dimensions========================
			Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
			this.setPreferredSize(windowDim);
			this.setMinimumSize(windowDim);
			this.setMaximumSize(windowDim);
			setLayout(null);
			setBackground(new Color(255, 250, 250));
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	//========================Setting Default Dimensions========================
			
			
			
			// List of items user picked
			JList list = new JList();
			list.setBounds(600, 100, 287, 450);
			add(list);
			DefaultListModel DLM = new DefaultListModel();
			
			// Labels
			
			JLabel lblNewLabel = new JLabel("Your Order");
			lblNewLabel.setBounds(690, 35, 197, 37);
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			add(lblNewLabel);
			
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
			
			JLabel mainDish1 = new JLabel("Ravioli");
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
			
			
			
			JLabel appetizerPrice1 = new JLabel("$22");
			appetizerPrice1.setForeground(Color.RED);
			appetizerPrice1.setBounds(135, 61, 132, 16);
			add(appetizerPrice1);
			
			JLabel appetizerPrice2 = new JLabel("$19");
			appetizerPrice2.setForeground(Color.RED);
			appetizerPrice2.setBounds(135, 89, 61, 16);
			add(appetizerPrice2);
			
			JLabel appetizerPrice3 = new JLabel("$20");
			appetizerPrice3.setForeground(Color.RED);
			appetizerPrice3.setBounds(135, 116, 61, 16);
			add(appetizerPrice3);
			
			JLabel mainPrice1 = new JLabel("$28");
			mainPrice1.setForeground(Color.RED);
			mainPrice1.setBounds(135, 237, 61, 16);
			add(mainPrice1);
			
			JLabel mainPrice2 = new JLabel("$30");
			mainPrice2.setForeground(Color.RED);
			mainPrice2.setBounds(135, 262, 61, 16);
			add(mainPrice2);
			
			JLabel mainPrice3 = new JLabel("$27");
			mainPrice3.setForeground(Color.RED);
			mainPrice3.setBounds(135, 287, 61, 16);
			add(mainPrice3);
			
			JLabel dessertPrice1 = new JLabel("$20");
			dessertPrice1.setForeground(Color.RED);
			dessertPrice1.setBounds(151, 442, 61, 16);
			add(dessertPrice1);
			
			JLabel dessertPrice2 = new JLabel("$16");
			dessertPrice2.setForeground(Color.RED);
			dessertPrice2.setBounds(151, 418, 61, 16);
			add(dessertPrice2);
			
			JLabel dessertPrice3 = new JLabel("$15");
			dessertPrice3.setForeground(Color.RED);
			dessertPrice3.setBounds(151, 393, 61, 16);
			add(dessertPrice3);
			
			JLabel beveragePrice1 = new JLabel("$3");
			beveragePrice1.setForeground(Color.RED);
			beveragePrice1.setBounds(114, 532, 61, 16);
			add(beveragePrice1);
			
			JLabel beveragePrice2 = new JLabel("$4");
			beveragePrice2.setForeground(Color.RED);
			beveragePrice2.setBounds(114, 560, 61, 16);
			add(beveragePrice2);
			
			JLabel beveragePrice3 = new JLabel("$4");
			beveragePrice3.setForeground(Color.RED);
			beveragePrice3.setBounds(114, 588, 61, 16);
			add(beveragePrice3);
			
			JLabel totalCostPrice = new JLabel("Total: " + totalCost);
			totalCostPrice.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			totalCostPrice.setBounds(694, 620, 197, 37);
			add(totalCostPrice);
			
			// Buttons
			JButton addAppetizerButton1 = new JButton("Add");
			addAppetizerButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(appetizer1, DLM, list, appetizerPrice1, totalCostPrice);
				}
			});
			addAppetizerButton1.setBounds(200, 55, 117, 29);
			add(addAppetizerButton1);
			
			JButton removeAppetizerButton1 = new JButton("Remove");
			removeAppetizerButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(appetizer1, DLM, list, appetizerPrice1, totalCostPrice);
				}
			});
			removeAppetizerButton1.setBounds(330, 56, 117, 29);
			add(removeAppetizerButton1);
			
			JButton addAppetizerButton2 = new JButton("Add");
			addAppetizerButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(appetizer2, DLM, list, appetizerPrice2, totalCostPrice);
				}
			});
			addAppetizerButton2.setBounds(200, 80, 117, 29);
			add(addAppetizerButton2);
			
			JButton removeAppetizerButton2 = new JButton("Remove");
			removeAppetizerButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(appetizer2, DLM, list, appetizerPrice2, totalCostPrice);
				}
			});
			removeAppetizerButton2.setBounds(330, 80, 117, 29);
			add(removeAppetizerButton2);
			
			JButton addAppetizerButton3 = new JButton("Add");
			addAppetizerButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(appetizer3, DLM, list, appetizerPrice3, totalCostPrice);
				}
			});
			addAppetizerButton3.setBounds(200, 105, 117, 29);
			add(addAppetizerButton3);
			
			JButton removeAppetizerButton3 = new JButton("Remove");
			removeAppetizerButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(appetizer3, DLM, list, appetizerPrice3, totalCostPrice);
				}
			});
			removeAppetizerButton3.setBounds(330, 105, 117, 29);
			add(removeAppetizerButton3);
			
			JButton addMainButton1 = new JButton("Add");
			addMainButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(mainDish1, DLM, list, mainPrice1, totalCostPrice);
				}
			});
			addMainButton1.setBounds(200, 232, 117, 29);
			add(addMainButton1);
			
			JButton removeMainButton1 = new JButton("Remove");
			removeMainButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(mainDish1, DLM, list, mainPrice1, totalCostPrice);
				}
			});
			removeMainButton1.setBounds(330, 232, 117, 29);
			add(removeMainButton1);
			
			JButton addMainButton2 = new JButton("Add");
			addMainButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(mainDish2, DLM, list, mainPrice2, totalCostPrice);
				}
			});
			addMainButton2.setBounds(200, 257, 117, 29);
			add(addMainButton2);
			
			JButton removeMainButton2 = new JButton("Remove");
			removeMainButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(mainDish2, DLM, list, mainPrice2, totalCostPrice);
				}
			});
			removeMainButton2.setBounds(330, 257, 117, 29);
			add(removeMainButton2);
			
			JButton addMainButton3 = new JButton("Add");
			addMainButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(mainDish3, DLM, list, mainPrice3, totalCostPrice);
				}
			});
			addMainButton3.setBounds(200, 282, 117, 29);
			add(addMainButton3);
			
			JButton removeMainButton3 = new JButton("Remove");
			removeMainButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(mainDish3, DLM, list, mainPrice3,totalCostPrice);
				}
			});
			removeMainButton3.setBounds(330, 282, 117, 29);
			add(removeMainButton3);
			
			JButton addDessertButton1 = new JButton("Add");
			addDessertButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(dessert1, DLM, list, dessertPrice1, totalCostPrice);
				}
			});
			addDessertButton1.setBounds(200, 388, 117, 29);
			add(addDessertButton1);
			
			JButton removeDessertButton1 = new JButton("Remove");
			removeDessertButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(dessert1, DLM, list, dessertPrice1, totalCostPrice);
				}
			});
			removeDessertButton1.setBounds(330, 383, 117, 29);
			add(removeDessertButton1);
			
			JButton addDessertButton2 = new JButton("Add");
			addDessertButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(dessert2, DLM, list, dessertPrice2, totalCostPrice);
				}
			});
			addDessertButton2.setBounds(200, 413, 117, 29);
			add(addDessertButton2);
			
			JButton removeDessertButton2 = new JButton("Remove");
			removeDessertButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(dessert2, DLM, list, dessertPrice2, totalCostPrice);
				}
			});
			removeDessertButton2.setBounds(330, 411, 117, 29);
			add(removeDessertButton2);
			
			JButton addDessertButton3 = new JButton("Add");
			addDessertButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(dessert3, DLM, list, dessertPrice3, totalCostPrice);
				}
			});
			addDessertButton3.setBounds(200, 437, 117, 29);
			add(addDessertButton3);
			
			JButton removeDessertButton3 = new JButton("Remove");
			removeDessertButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(dessert3, DLM, list, dessertPrice3, totalCostPrice);
				}
			});
			removeDessertButton3.setBounds(330, 437, 117, 29);
			add(removeDessertButton3);
			
			JButton addBeverage1 = new JButton("Add");
			addBeverage1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(beverages1, DLM, list, beveragePrice1, totalCostPrice);
				}
			});
			addBeverage1.setBounds(200, 527, 117, 29);
			add(addBeverage1);
			
			JButton removeBeverage1 = new JButton("Remove");
			removeBeverage1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(beverages1, DLM, list, beveragePrice1, totalCostPrice);
				}
			});
			removeBeverage1.setBounds(330, 527, 117, 29);
			add(removeBeverage1);
			
			JButton addBeverage2 = new JButton("Add");
			addBeverage2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(beverages2, DLM, list, beveragePrice2, totalCostPrice);
				}
			});
			addBeverage2.setBounds(200, 555, 117, 29);
			add(addBeverage2);
			
			JButton removeBeverage2 = new JButton("Remove");
			removeBeverage2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(beverages2, DLM, list, beveragePrice2, totalCostPrice);
				}
			});
			removeBeverage2.setBounds(330, 555, 117, 29);
			add(removeBeverage2);
			
			JButton addBeverage3 = new JButton("Add");
			addBeverage3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add(beverages3, DLM, list, beveragePrice3, totalCostPrice);
				}
			});
			addBeverage3.setBounds(200, 583, 117, 29);
			add(addBeverage3);
			
			JButton removeBeverage3 = new JButton("Remove");
			removeBeverage3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(beverages3, DLM, list, beveragePrice3, totalCostPrice);
				}
			});
			removeBeverage3.setBounds(330, 583, 117, 29);
			add(removeBeverage3);
			
			
			
			
		
	}
	
	public void add(JLabel label, DefaultListModel DLM, JList list, JLabel price, JLabel totalCostPrice) {
		
		String s = label.getText();
		String pri = price.getText();
		double p = Double.valueOf(pri.substring(1));
		DLM.addElement(s);
		list.setModel(DLM);
		totalCost += p;
		double roundOff = Math.round(totalCost);
		totalCostPrice.setText("Total: " + String.valueOf(roundOff));
		System.out.println(totalCost);
		
		
	}
	
	public void remove(JLabel label, DefaultListModel DLM, JList list, JLabel price, JLabel totalCostPrice) {
		if(DLM.contains(label.getText())) {
			String s = label.getText();
			String pri = price.getText();
			double p = Double.valueOf(pri.substring(1));
			DLM.removeElement(s);
			list.setModel(DLM);
			totalCost -= p;
			double roundOff = Math.round(totalCost);
			totalCostPrice.setText("Total: " + String.valueOf(roundOff));
			System.out.println(totalCost);
		}
	}
}
