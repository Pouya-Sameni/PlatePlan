package dto;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import dto.*;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Customer {

	@NonNull
	@Getter
	@Setter
	private String email;

	@NonNull
	@Getter
	@Setter
	private String firstName;

	@NonNull
	@Getter
	@Setter
	private String lastName;

	@NonNull
	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private List<Reservation> reservations;

	public String genSQLValue() {
		StringBuilder values = new StringBuilder();

		values.append("(");
		values.append("'" + this.getEmail() + "',");
		values.append("'" + this.getFirstName() + "',");
		values.append("'" + this.getLastName() + "',");
		values.append("'" + this.getPassword() + "'");
		values.append(")");
		System.out.println(values.toString());

		return values.toString();

	}

}
