package com.java.JavaProblems;

import java.util.HashMap;
import java.util.Set;

public class Test extends Problem4 {
	 static int b;
	
	static{
		m();
	}
	
	public Test(int age, int col) {
		super();
		this.age = age;
		this.col = col;
	}

	public Test() {
		// TODO Auto-generated constructor stub
	}

	int age=10;
	int col;
	
	static void m()
	{
		System.out.println("in static");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		b = 1;
		System.out.println("valeu of b:"+b);
		/*
		HashMap hmap = new HashMap();
		String s="A";
		StringBuilder sb = new StringBuilder("A");
		hmap.put(sb, 1);
		sb.append("b");
		Set set = hmap.keySet();
		System.out.println(hmap.get(s));
		*/
		
		
		Test t1 = new Test(1,2);
		Test t2 = new Test(3,4);
		
		System.out.println(t1.age+" "+t2.age);
		swap(t1, t2);
		System.out.println("after swap");
		System.out.println(t1.age+" "+t2.age);
		
		Test t = new Test(); // 10
		
		
		Problem4 p = new Test(); // 20
		System.out.println(t.a);
		System.out.println(p.age);
		//System.out.println(t.;

	}
	
	static void swap(Test a,Test b)
	{
		int temp = a.age;
		a.age = b.age;
		b.age = temp;
		
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
