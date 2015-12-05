package test.mvc.cust.model;

public class Cust {
	int custId;
	String name;
	int age;
	public Cust(int id,String name,int age){
		this.custId=id;
		this.name=name;
		this.age=age;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
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
}
