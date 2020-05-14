package com.groupware.request;

import java.util.Date;

import com.groupware.dto.EmployeeVO;

public class RegistEmployeeRequest {

	private String id;
	private String pwd;
	private String eno;
	private String name;
	private String email;
	private int enabled;
	private String phone_c;
	private String phone_p;
	private String picture;
	private Date regDate;
	private String position;
	private String authority;
	private String deptName;
	private String postCode;
	private String address1;
	private String address2;	
	private String ssn;
	private String remark;
	private String licenseDoc;
	private String graduDoc;
	private String scoreDoc;
	private String register;
	private Date recentLoginTime;
	
	private String posi_no;
	private String dept_no;
	
	
	public RegistEmployeeRequest() {	}
	
	public RegistEmployeeRequest(String id, String pwd, String eno, String name, String email, int enabled,
			String phone_c, String phone_p, String picture, Date regDate, String position, String authority,
			String deptName, String postCode, String address1, String address2, String ssn, String remark,
			String licenseDoc, String graduDoc, String scoreDoc, String register, Date recentLoginTime, String posi_no,
			String dept_no) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.eno = eno;
		this.name = name;
		this.email = email;
		this.enabled = enabled;
		this.phone_c = phone_c;
		this.phone_p = phone_p;
		this.picture = picture;
		this.regDate = regDate;
		this.position = position;
		this.authority = authority;
		this.deptName = deptName;
		this.postCode = postCode;
		this.address1 = address1;
		this.address2 = address2;
		this.ssn = ssn;
		this.remark = remark;
		this.licenseDoc = licenseDoc;
		this.graduDoc = graduDoc;
		this.scoreDoc = scoreDoc;
		this.register = register;
		this.recentLoginTime = recentLoginTime;
		this.posi_no = posi_no;
		this.dept_no = dept_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getPhone_c() {
		return phone_c;
	}

	public void setPhone_c(String phone_c) {
		this.phone_c = phone_c;
	}

	public String getPhone_p() {
		return phone_p;
	}

	public void setPhone_p(String phone_p) {
		this.phone_p = phone_p;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLicenseDoc() {
		return licenseDoc;
	}

	public void setLicenseDoc(String licenseDoc) {
		this.licenseDoc = licenseDoc;
	}

	public String getGraduDoc() {
		return graduDoc;
	}

	public void setGraduDoc(String graduDoc) {
		this.graduDoc = graduDoc;
	}

	public String getScoreDoc() {
		return scoreDoc;
	}

	public void setScoreDoc(String scoreDoc) {
		this.scoreDoc = scoreDoc;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public Date getRecentLoginTime() {
		return recentLoginTime;
	}

	public void setRecentLoginTime(Date recentLoginTime) {
		this.recentLoginTime = recentLoginTime;
	}

	public String getPosi_no() {
		return posi_no;
	}

	public void setPosi_no(String posi_no) {
		this.posi_no = posi_no;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}
	
	public EmployeeVO toEmployeeVO() {
		EmployeeVO employee = new EmployeeVO();
		
		
		return employee;
	}
	
}
