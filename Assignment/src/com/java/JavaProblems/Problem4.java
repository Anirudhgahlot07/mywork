package com.java.JavaProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class Problem4 {

	int age =20;
	int a=10;
	public static void main(String[] args) {
		
		createEmpListandPrintThem();
		Problem4 p = new Problem4();
		

	}
	
	public static void createEmpListandPrintThem()
	{
		HashMap<Employee, Department>  map = new HashMap<>();
		LinkedHashMap<Employee, Department>  lmap = new LinkedHashMap<>();
		
		for(int i=0;i<10;i++)
		{
			map.put(new Employee("employee"+i, 1000L*i), new Department("department"+i));
			lmap.put(new Employee("employee"+i, 1000L*i), new Department("department"+i));
		}
		

		System.out.println();
		System.out.println("Print Employee list");
		System.out.println();	
		printListofEmployee(map);
		
		System.out.println();
		System.out.println("Print employee in Insertion order");
		System.out.println();
		printListofEmployee(lmap);
		
		
		System.out.println();
		System.out.println("Print Department List");
		System.out.println();
		printListofDepartment(map);
		
		System.out.println();
		System.out.println("Creating clone of dept with in Map");
		try {
			createCloneOfDept(map);
		} catch (CloneNotSupportedException e) {
		
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Created clone of dept with in Map");
	}
	
	public static void printListofEmployee(HashMap map)
	{
		List<Employee> empList = new ArrayList<>();
		Set set = map.keySet();
		Iterator  it = set.iterator();
		while(it.hasNext())
		{
			empList.add((Employee) it.next());
		}
		
		
		for(int i=0;i<empList.size();i++)
		{
			Employee emp = (Employee) empList.get(i);
			System.out.println(emp.getName());
		}
		
		System.out.println();
		System.out.println("Print sorted list  of employee");
		System.out.println();
		printSortedEmployee(empList);
	}
	
	public static void printListofDepartment(HashMap map)
	{
		List<Department> depList = new ArrayList<>();
		Set set = map.keySet();
		Iterator  it = set.iterator();
		while(it.hasNext())
		{
			depList.add((Department) map.get(it.next()));
		}
		
		
		for(int i=0;i<depList.size();i++)
		{
			Department dep = (Department) depList.get(i);
			System.out.println(dep.getName());
		}
		
		
		
		
		System.out.println();
		System.out.println("Print Sorted Department List");
		System.out.println();
		printsortedDepartment(depList);
		
		
		
		
	}
	
	public static void printSortedEmployee(List list)
	{
		Collections.sort(list,new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.getSalary()<o2.getSalary())
					return 1;
				else if(o1.getSalary()>o2.getSalary())
					return -1;
				else
				return 0;
			}
		});
		
		for(int i=0;i<list.size();i++)
		{
			Employee emp = (Employee) list.get(i);
			System.out.println(emp.getName()+" - "+emp.getSalary());
		}
	}

	public static void printsortedDepartment(List list)
	{
		Collections.sort(list,new Comparator<Department>() {

			@Override
			public int compare(Department o1, Department o2) {
				if(o1.getName().compareTo(o2.getName())>0)
					return 1;
				else if(o1.getName().compareTo(o2.getName())<0)
				return -1;
				else
				return 0;
			}
		});
		
		for(int i=0;i<list.size();i++)
		{
			Department dep = (Department) list.get(i);
			System.out.println(dep.getName());
		}
	}
	
	public static void createCloneOfDept(HashMap map) throws CloneNotSupportedException
	{
		Set set = map.keySet();
		Iterator  it = set.iterator();
		
		while(it.hasNext())
		{
			Employee emp= (Employee) it.next();
			emp.setName(emp.getName()+"cloned");
			Department dept = (Department) map.get(it.next());
			
			map.put(emp, dept.clone());
		}
				
	
	}
}
