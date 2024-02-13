package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import dto.Business;
import dto.Customer;
import dto.Reservation;
import dto.Table;

public class DataBaseImpl implements DataBase {

    private static DataBaseImpl dataBaseInstance;
    private static final String URL = "jdbc:postgresql://localhost:5432/PlatePlan";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    private DataBaseImpl() {
        establishConnection();
    }

    public static synchronized DataBaseImpl getInstance() {
        if (dataBaseInstance == null) {
            dataBaseInstance = new DataBaseImpl();
        }
        return dataBaseInstance;
    }

    private Connection establishConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertRecord(String tableName, Object object) {
//        try {
//            Connection conn = establishConnection();
//            String insertCommand = String.format("INSERT INTO %s %s VALUES %s", tableName, getColumns(tableName),
//                    values);
//            System.out.println(insertCommand);
//            PreparedStatement pstmt = conn.prepareStatement(insertCommand);
//
//            int affectedRows = pstmt.executeUpdate();
//            if (affectedRows > 0) {
//                System.out.println("A new record was inserted successfully.");
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
        return true;
    }

    private String getColumns(String tableName) {
        StringBuilder columns = new StringBuilder();

        List<String> columnList = new ArrayList<>();

        try (Connection conn = establishConnection()) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                ResultSet resultSet = meta.getColumns(null, null, tableName, null);
                while (resultSet.next()) {
                    String columnName = resultSet.getString("COLUMN_NAME");
                    columnList.add(columnName);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        columns.append("(");
        columns.append(String.join(",", columnList));
        columns.append(")");
        System.out.println(columns.toString());

        return columns.toString();
    }

    @Override
    public Customer getCustomerAccount(String email) throws AccountNotFoundException {
        // Implement this method to retrieve customer details from the database
        // You can use SQL queries to fetch customer information based on the email
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<Reservation> getCustomerReservations(String email) throws AccountNotFoundException {
        // Implement this method to retrieve reservations for a customer from the database
        // You can use SQL queries to fetch reservations based on the customer's email
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void updateRecord(String tableName, String updatedValues, String conditionColumn, String conditionValue) {
        try {
            Connection conn = establishConnection();
            String updateCommand = String.format("UPDATE %s SET %s WHERE %s='%s'", tableName, updatedValues, conditionColumn, conditionValue);
            System.out.println(updateCommand);
            PreparedStatement pstmt = conn.prepareStatement(updateCommand);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No records were updated.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



	@Override
	public Business getBusinessAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerCustomer(Customer object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Table> getAllTables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getReservationsForDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation getReservationWithId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getAllReservations() {
		// TODO Auto-generated method stub
		return null;
	}

}
