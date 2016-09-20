package com.hrm.entity;

import java.io.Serializable;
import java.util.Date;

public class Material implements Serializable {
    private Integer id;	//Ա�����
    private String keyword;//Ա���û���//��¼����
    private String  date;		//�Ա�
    private String file;
    private String description;	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
   
   
}
