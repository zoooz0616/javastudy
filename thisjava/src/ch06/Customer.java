package ch06;

public class Customer {
	private String nameString;
	private char gender;
	private String emailString;
	private int birthYear;
	
	
	public Customer() {
		
	}
	
	public Customer(String nameString, char gender, String emailString, int birthYear) {
		this.nameString = nameString;
		this.gender = gender;
		this.emailString = emailString;
		this.birthYear = birthYear;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	@Override
	public String toString() {
		return "Customer [nameString=" + nameString + ", gender=" + gender +
				", emailString=" + emailString
				+ ", birthYear=" + birthYear + "]";
	}
	
	
	

}
