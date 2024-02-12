package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import services.ReservationService;
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

    public ReservationPanel(String customerEmail) {
        this.customerEmail = customerEmail;
        this.reservationService = new ReservationService(); // Instantiate your service class here.
        setLayout(new GridBagLayout()); // Using GridBagLayout for better organization
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Initialize components
        lblSeats = new JLabel("Number of Seats:");
        txtSeats = createPrettyTextField();
        lblDate = new JLabel("Date (dd/MM/yyyy):");
        txtDate = createPrettyTextField();
        lblTime = new JLabel("Time (HH:mm):");
        txtTime = createPrettyTextField();
        btnSubmitReservation = new JButton("Submit Reservation");

        // Add components to panel using GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblSeats, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtSeats, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblDate, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblTime, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(txtTime, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(btnSubmitReservation, gbc);

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
}
