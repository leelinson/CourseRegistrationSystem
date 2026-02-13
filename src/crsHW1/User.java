package crsHW1;

/**
 * Abstract base class for all users in the Course Registration System.
 * Encapsulates common attributes: username, password, first name, last name.
 * Admin and Student inherit from this class (inheritance / Req 07).
 */
public abstract class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	public User(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	/** Display the role-specific menu (overridden by Admin and Student). */
	public abstract void displayMenu();

	/** Returns full name for display and matching in course lists. */
	public String getFullName() {
		return firstName + " " + lastName;
	}
}
