package la.bean;

import java.io.Serializable;

public class ItemBean implements Serializable{
	private int code;
	private String name;
	private int age;
	private String tel;


	public ItemBean(int code, String name, int age, String tel) {
		this.code = code;
		this.name = name;
		this.age = age;
		this.tel = tel;
	}

	public ItemBean() {
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

}