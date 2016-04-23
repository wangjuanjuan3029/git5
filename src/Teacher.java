package com.briup.home01;

public class Teacher {
	private String name;
	private String gender;
	private int age;
	private long id;
	

	public Teacher(){
	
	}
	public Teacher(long id,String name,String gender,int age){
		this.id = id;
		this.name = name ;
		this.gender = gender;
		this.age = age;
	}

	public void setName(String name ){
		this.name = name ;
	}
	public String getName(){
		return this.name;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public String getGender(){
		return this.gender;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
	public void setId(long id){
		this.id = id;
	}
	public long getId(){
		return this.id;
	}
	

	public String toString(){
		return " Teacher [ name:"+this.name+"  gender:"+this.gender+"  age:"+this.age+"  id:"+this.id+"]";
	}
}