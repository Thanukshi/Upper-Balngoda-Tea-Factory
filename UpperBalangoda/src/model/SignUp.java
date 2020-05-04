package model;

public class SignUp {
	
	private String CompanyID;
	
	private String CompanyType;
	
	private String CompanyName;
	
	private String UserName;
	
	private String CompanyPassword;
	
	private String CompanyRePassword;

	/**
	 * @return the companyID
	 */
	public String getCompanyID() {
		return CompanyID;
	}

	/**
	 * @param companyID the companyID to set
	 */
	public void setCompanyID(String companyID) {
		CompanyID = companyID;
	}

	/**
	 * @return the companyType
	 */
	public String getCompanyType() {
		return CompanyType;
	}

	/**
	 * @param companyType the companyType to set
	 */
	public void setCompanyType(String companyType) {
		CompanyType = companyType;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return CompanyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}

	/**
	 * @return the companyPassword
	 */
	public String getCompanyPassword() {
		return CompanyPassword;
	}

	/**
	 * @param companyPassword the companyPassword to set
	 */
	public void setCompanyPassword(String companyPassword) {
		CompanyPassword = companyPassword;
	}

	/**
	 * @return the companyRePassword
	 */
	public String getCompanyRePassword() {
		return CompanyRePassword;
	}

	/**
	 * @param companyRePassword the companyRePassword to set
	 */
	public void setCompanyRePassword(String companyRePassword) {
		CompanyRePassword = companyRePassword;
	}

	@Override
	public String toString() {
		return "SignUp [CompanyID=" + CompanyID + ", CompanyType=" + CompanyType + ", CompanyName=" + CompanyName
				+ ", UserName=" + UserName + ", CompanyPassword=" + CompanyPassword + ", CompanyRePassword="
				+ CompanyRePassword + "]";
	}

	
	

	
}
