package com.groupware.request;

import org.springframework.web.multipart.MultipartFile;

import com.groupware.dto.EmployeeVO;

public class RegistEmployeeCommand {

	private String id;
	private String pwd;
	private String name;
	private String[] ssn;
	private String phone_p;
	private String phone_c;
	private String[] email;
	private String postCode;
	private String address1;
	private String address2;
	private String dept_no;
	private String posi_no;
	private String regDate;
	private String remark;

	private MultipartFile picture;
	
	private MultipartFile licenseDoc;
	private MultipartFile graduDoc;
	private MultipartFile scoreDoc;

	public RegistEmployeeCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public RegistEmployeeCommand(String id, String pwd, String name, String[] ssn, String phone_p, String phone_c,
			String[] email, String postCode, String address1, String address2, String dept_no, String posi_no,
			String regDate, String remark, MultipartFile picture, MultipartFile licenseDoc, MultipartFile graduDoc,
			MultipartFile scoreDoc) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.ssn = ssn;
		this.phone_p = phone_p;
		this.phone_c = phone_c;
		this.email = email;
		this.postCode = postCode;
		this.address1 = address1;
		this.address2 = address2;
		this.dept_no = dept_no;
		this.posi_no = posi_no;
		this.regDate = regDate;
		this.remark = remark;
		this.picture = picture;
		this.licenseDoc = licenseDoc;
		this.graduDoc = graduDoc;
		this.scoreDoc = scoreDoc;
	}



	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public MultipartFile getLicenseDoc() {
		return licenseDoc;
	}

	public void setLicenseDoc(MultipartFile licenseDoc) {
		this.licenseDoc = licenseDoc;
	}

	public MultipartFile getGraduDoc() {
		return graduDoc;
	}

	public void setGraduDoc(MultipartFile graduDoc) {
		this.graduDoc = graduDoc;
	}

	public MultipartFile getScoreDoc() {
		return scoreDoc;
	}

	public void setScoreDoc(MultipartFile scoreDoc) {
		this.scoreDoc = scoreDoc;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}

	public String getPosi_no() {
		return posi_no;
	}

	public void setPosi_no(String posi_no) {
		this.posi_no = posi_no;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
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

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String[] getEmail() {
		return email;
	}

	public void setEmail(String[] email) {
		this.email = email;
	}

	public String[] getSsn() {
		return ssn;
	}

	public void setSsn(String[] ssn) {
		this.ssn = ssn;
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

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_p() {
		return phone_p;
	}

	public void setPhone_p(String phone_p) {
		this.phone_p = phone_p;
	}

	public String getPhone_c() {
		return phone_c;
	}

	public void setPhone_c(String phone_c) {
		this.phone_c = phone_c;
	}

	public EmployeeVO toEmployeeVO() {
		EmployeeVO employee = new EmployeeVO();
		employee.setId(id);
		employee.setPwd(pwd);
		employee.setName(name);
		employee.setPicture(picture.getOriginalFilename());
		employee.setSsn(ssn[0] + "-" + ssn[1]);
		employee.setPhone_c(phone_c);
		employee.setPhone_p(phone_p);
		employee.setEmail(email[0] + "@" + email[1]);
		employee.setPostCode(postCode);
		employee.setAddress1(address1);
		employee.setAddress2(address2);
		employee.setDept_no(dept_no);
		employee.setPosi_no(posi_no);
		employee.setLicenseDoc(licenseDoc.getOriginalFilename());
		employee.setGraduDoc(graduDoc.getOriginalFilename());
		employee.setScoreDoc(scoreDoc.getOriginalFilename());
		employee.setRemark(remark);
		return employee;
	}

}
