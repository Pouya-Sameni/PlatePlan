package services;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import misc.SQLTables;

public class DataBase {

	private static DataBase dataBaseInstance;
	private static final String URL = "jdbc:postgresql://localhost:5432/PlatePlan";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "admin";

	private DataBase() {
		establishConnection();
		getColumns(SQLTables.ACCOUNTS_TABLE);

	}

	public static synchronized DataBase getInstance() {
		if (dataBaseInstance == null) {
			dataBaseInstance = new DataBase();
		}
		return dataBaseInstance;
	}

	private Connection establishConnection() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected to the PostgreSQL server successfully.");
			return connection;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean insertRecord(String tableName, String values) {

		try {
			Connection conn = this.establishConnection();
			String insertCommand = String.format("INSERT INTO %s %s VALUES %s", tableName, getColumns(tableName),
					values);
			System.out.println (insertCommand);
			PreparedStatement pstmt = conn.prepareStatement(insertCommand);

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("A new record was inserted successfully.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
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

}
