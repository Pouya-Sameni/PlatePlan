package panels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;

import main.PlatePlanMain;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusinessHomeView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public BusinessHomeView() {
		//========================Setting Default Dimensions========================
		Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
		this.setPreferredSize(windowDim);
		this.setMinimumSize(windowDim);
		this.setMaximumSize(windowDim);
		setLayout(null);
		setBackground(new Color(255, 250, 250));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		lblNewLabel = new JLabel("Business HOME VIEW");
		lblNewLabel.setBounds(452, 180, 138, 16);
		add(lblNewLabel);
	//===========================================================================
		
		JButton manageTables = new JButton("Manage Tables");
		manageTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlatePlanMain.switchPanels(new BusinessTableManageView());
			}
		});
		manageTables.setBounds(452, 207, 128, 23);
		add(manageTables);
	}
}
