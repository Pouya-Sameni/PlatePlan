package customerPanels;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import services.ReservationServiceImpl;
import dto.Customer;
import dto.Reservation;
import dto.TimeSlot;
import main.PlatePlanMain;
import misc.ServiceUtils;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CustomerReservations extends JPanel {
	private JTextField txtSeats;
	private JTextField txtDate;
	private JTextField txtTime;
	private JButton btnSubmitReservation;
	private JLabel lblSeats;
	private JLabel lblDate;
	private Customer customer; // Now using email instead of customerId
	private ReservationServiceImpl reservationService;
	private SpringLayout springLayout;
	private ServiceUtils serviceUtils;
	ArrayList<TimeSlot> timeList;
	private List listOfAvailableTimes;
	private JSpinner spinner;
	private JDatePickerImpl datePicker;
	private Map<String, TimeSlot> timeSlotMap;
	private JTextPane txtSpecialNotesPane;

	public CustomerReservations(Customer customer) {
		// ========================Setting Default Dimensions========================
		Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
		this.setPreferredSize(windowDim);
		this.setMinimumSize(windowDim);
		this.setMaximumSize(windowDim);
		setBackground(new Color(255, 250, 250));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		// ===========================================================================

		this.serviceUtils = ServiceUtils.getInstance();
		timeList = new ArrayList<>();
		this.customer = customer;
		this.reservationService = new ReservationServiceImpl();
		timeSlotMap = new HashMap<>();
		// Initialize components
		lblSeats = new JLabel("Number of Seats:");
		lblSeats.setBounds(277, 164, 125, 14);
		lblDate = new JLabel("Date (dd/MM/yyyy):");
		lblDate.setBounds(277, 121, 134, 14);
		btnSubmitReservation = new JButton("Submit Reservation");
		btnSubmitReservation.setBounds(467, 600, 165, 29);
		setLayout(null);

		listOfAvailableTimes = new List();
		listOfAvailableTimes.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		listOfAvailableTimes.setFont(new Font("Arial", Font.PLAIN, 18));
		listOfAvailableTimes.setBounds(318, 239, 200, 300);

		add(listOfAvailableTimes);

		add(lblSeats);
		add(lblDate);
		add(btnSubmitReservation);

		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				getDateAvailableSlots();
			}
		});
		spinner.setModel(new SpinnerNumberModel(1, 1, 8, 1));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner.setBounds(423, 156, 61, 30);
		add(spinner);

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");

		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDateAvailableSlots();
			}
		});

		datePicker.setLocation(423, 121);
		datePicker.setSize(202, 29);

		add(datePicker);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlatePlanMain.switchPanels(new CustomerHomeView(customer));
				
			}
		});
		btnBack.setBounds(6, 6, 117, 29);
		add(btnBack);
		
		txtSpecialNotesPane = new JTextPane();
		txtSpecialNotesPane.setBounds(555, 239, 200, 300);
		add(txtSpecialNotesPane);
		
		JLabel lblAvailableTimes = new JLabel("Available Times");
		lblAvailableTimes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAvailableTimes.setBounds(318, 219, 90, 15);
		add(lblAvailableTimes);
		
		JLabel lblSpecialNotes = new JLabel("Special Notes");
		lblSpecialNotes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpecialNotes.setBounds(555, 220, 90, 15);
		add(lblSpecialNotes);
		// Add action listener to button
		btnSubmitReservation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				submitReservation();
			}
		});
	}

	private void getDateAvailableSlots() {

		Date selectedValue = (Date) datePicker.getModel().getValue();
		// Check if a date is selected
		if (selectedValue != null) {
			// Convert Calendar to LocalDate
			LocalDate localDate = selectedValue.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int capacity = (Integer) spinner.getValue();

			System.out.println("Searching for Time Slot: " + localDate + " For " + capacity);
			timeList = (ArrayList<TimeSlot>) serviceUtils.getAvailableTables(localDate, capacity);
			listOfAvailableTimes.removeAll();
			timeSlotMap.clear();
			for (TimeSlot timeSlot : timeList) {
				String displayText = String.format("%s - %s", timeSlot.getFrom().toString(), timeSlot.getTo().toString());
				timeSlotMap.put(displayText, timeSlot);
				listOfAvailableTimes
						.add(displayText);
			}
			PlatePlanMain.refreshPage();
		}
	}

	// TODO: Fix Error and move logic to Service

	private void submitReservation() {
		try {
			int capacity = (Integer)spinner.getValue();
			TimeSlot timeSlotChosen = timeSlotMap.get(listOfAvailableTimes.getSelectedItem());
			String specialNotes = txtSpecialNotesPane.getText();
			if (timeSlotChosen == null)
			{
				throw new NullPointerException();
			}
			LocalDate date = ((Date) datePicker.getModel().getValue())
					.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Reservation reservation = reservationService.createCustomerReservation(customer,date,timeSlotChosen,capacity,specialNotes );
			
			if (reservation == null)
			{
				throw new NullPointerException();
			}
			
			JOptionPane.showMessageDialog(this, "Reservation Submitted Successfully!", "Success",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error submitting reservation", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
		private String datePattern = "yyyy-MM-dd";
		private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}

			return "";
		}
	}
}
