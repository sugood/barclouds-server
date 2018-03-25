/**
 * 
 */
package com.barclouds.entity;

/**
 * @author Administrator
 */
public class User {
	private int id;

	private String uid;

	private String password;

	private String realName;

	private String gender;

	private String email;

	private String tel;

	private String question;

	private String answer;

	private String validateCode;
	
	private String loginNum;

	public User() {
	}
	
	// 有参构造
	public User(String uid, String password, String realName, String gender, String email,
			String tel, String question,String answer,String validateCode,String loginNum) {
		this.uid = uid;
		this.password = password;
		this.realName = realName;
		this.gender = gender;
		this.email = email;
		this.tel = tel;
		this.question = question;
		this.answer = answer;
		this.validateCode = validateCode;
		this.loginNum = loginNum;
	}
	/**
	 * @return Returns the answer.
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            The answer to set.
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Returns the gender.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            The gender to set.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Returns the question.
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            The question to set.
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return Returns the realName.
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName
	 *            The realName to set.
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * @return Returns the tel.
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            The tel to set.
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return Returns the uid.
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            The uid to set.
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return Returns the validateCode.
	 */
	public String getValidateCode() {
		return validateCode;
	}

	/**
	 * @param validateCode
	 *            The validateCode to set.
	 */
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	/**
	 * @return Returns the loginNum.
	 */
	public String getLoginNum() {
		return loginNum;
	}

	/**
	 * @param loginNum The loginNum to set.
	 */
	public void setLoginNum(String loginNum) {
		this.loginNum = loginNum;
	}

}
