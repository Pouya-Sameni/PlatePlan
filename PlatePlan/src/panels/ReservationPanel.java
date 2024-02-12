package panels;

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

import services.ReservationService;
import dto.Customer;
import dto.Reservation;

public class ReservationPanel extends JPanel {
    private JTextField txtSeats;
    private JTextField txtDate;
    private JTextField txtTime;
    private JButton btnSubmitReservation;
    private JLabel lblSeats;
    private JLabel lblDate;
    private JLabel lblTime;
    private String customerEmail; // Now using email instead of customerId
    private ReservationService reservationService;

    public ReservationPanel(Customer customer) {
        //========================Setting Default Dimensions========================
        Dimension windowDim = new Dimension(Constants.WINDOW_MAX_WIDTH, Constants.WINDOW_MAX_HEIGHT);
        this.setPreferredSize(windowDim);
        this.setMinimumSize(windowDim);
        this.setMaximumSize(windowDim);
        setBackground(new Color(255, 250, 250));
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        //===========================================================================
    	
        this.customerEmail = customer.getEmail();
        this.reservationService = new ReservationService();

        // Initialize components
        lblSeats = new JLabel("Number of Seats:");
        lblSeats.setBounds(425, 165, 84, 14);
        txtSeats = createPrettyTextField();
        lblDate = new JLabel("Date (dd/MM/yyyy):");
        lblDate.setBounds(411, 214, 98, 14);
        txtDate = createPrettyTextField();
        lblTime = new JLabel("Time (HH:mm):");
        lblTime.setBounds(438, 279, 71, 14);
        txtTime = createPrettyTextField();
        btnSubmitReservation = new JButton("Submit Reservation");
        btnSubmitReservation.setBounds(589, 400, 125, 23);
        setLayout(null);


        add(lblSeats);
        add(txtSeats);
        add(lblDate);
        add(txtDate);
        add(lblTime);
        add(txtTime);
        add(btnSubmitReservation);
        
        JSpinner spinner = new JSpinner();
        spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spinner.setBounds(519, 156, 61, 30);
        add(spinner);
        
        JSpinner spinner_1 = new JSpinner();
        spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spinner_1.setBounds(620, 273, 61, 23);
        add(spinner_1);
        
        JSpinner spinner_2 = new JSpinner();
        spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spinner_2.setBounds(542, 273, 61, 23);
        add(spinner_2);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setLocation(412, 90);
        datePicker.setSize(253, 23);

        add(datePicker);
        // Add action listener to button
        btnSubmitReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitReservation();
            }
        });
    }

    private JTextField createPrettyTextField() {
        JTextField textField = new JTextField();
        textField.setBounds(400, 362, 150, 30);
        textField.setPreferredSize(new Dimension(150, 30));
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border for outline
        return textField;
    }

    private void submitReservation() {
        try {
            int seats = Integer.parseInt(txtSeats.getText());
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm", Locale.ENGLISH);
            
            LocalDate date = LocalDate.parse(txtDate.getText(), dateFormatter);
            LocalTime time = LocalTime.parse(txtTime.getText(), timeFormatter);
            LocalDateTime dateTime = LocalDateTime.of(date, time);

            Reservation reservation = new Reservation(customerEmail, dateTime, seats);
            reservationService.createReservation(reservation);
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
