package panels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class CustomerHomeView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public CustomerHomeView() {
		//========================Setting Default Dimensions========================
		Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
		this.setPreferredSize(windowDim);
		this.setMinimumSize(windowDim);
		this.setMaximumSize(windowDim);
		setLayout(null);
		setBackground(new Color(255, 250, 250));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		lblNewLabel = new JLabel("HOME VIEW");
		lblNewLabel.setBounds(481, 342, 138, 16);
		add(lblNewLabel);
	//===========================================================================
	}
}
