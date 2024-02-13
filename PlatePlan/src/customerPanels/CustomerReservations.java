package customerPanels;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;

import services.ReservationServiceImpl;
import dto.Customer;
import dto.Reservation;

public class CustomerReservations extends JPanel {
    private JTextField txtSeats;
    private JTextField txtDate;
    private JTextField txtTime;
    private JButton btnSubmitReservation;
    private JLabel lblSeats;
    private JLabel lblDate;
    private String customerEmail; // Now using email instead of customerId
    private ReservationServiceImpl reservationService;
    private SpringLayout springLayout;

    public CustomerReservations(Customer customer) {
        //========================Setting Default Dimensions========================
        Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
        this.setPreferredSize(windowDim);
        this.setMinimumSize(windowDim);
        this.setMaximumSize(windowDim);
        setBackground(new Color(255, 250, 250));
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        //===========================================================================
    	
        this.customerEmail = customer.getEmail();
        this.reservationService = new ReservationServiceImpl();

        // Initialize components
        lblSeats = new JLabel("Number of Seats:");
        lblSeats.setBounds(277, 164, 125, 14);
        lblDate = new JLabel("Date (dd/MM/yyyy):");
        lblDate.setBounds(277, 121, 134, 14);
        btnSubmitReservation = new JButton("Submit Reservation");
        btnSubmitReservation.setBounds(467, 530, 165, 29);
        setLayout(null);
        
        List listOfAvailableTimes = new List();
        listOfAvailableTimes.setBounds(350, 210, 400, 300);
        listOfAvailableTimes.add("test");
        add(listOfAvailableTimes);


        add(lblSeats);
        add(lblDate);
        add(btnSubmitReservation);
        
        JSpinner spinner = new JSpinner();
        spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spinner.setBounds(423, 156, 61, 30);
        add(spinner);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setLocation(423, 121);
        datePicker.setSize(202, 29);

        add(datePicker);
        // Add action listener to button
        btnSubmitReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitReservation();
            }
        });
    }


    
    //TODO: Fix Error and move logic to Service
    
    private void submitReservation() {
        try {
            int seats = Integer.parseInt(txtSeats.getText());
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm", Locale.ENGLISH);
            
            LocalDate date = LocalDate.parse(txtDate.getText(), dateFormatter);
            LocalTime time = LocalTime.parse(txtTime.getText(), timeFormatter);
            LocalDateTime dateTime = LocalDateTime.of(date, time);

            //Reservation reservation = new Reservation(customerEmail, dateTime, seats);
           // reservationService.createReservation(reservation);
            JOptionPane.showMessageDialog(this, "Reservation Submitted Successfully!", "Success",
                                          JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error submitting reservation: " + ex.getMessage(), "Error",
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
