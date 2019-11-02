package com.java.Array;

public class Department implements Cloneable{
	
	public Department(String name) {
		
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
}
