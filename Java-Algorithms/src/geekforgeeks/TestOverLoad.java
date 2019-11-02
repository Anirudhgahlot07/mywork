package geekforgeeks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class TestOverLoad  implements Comparator<TestOverLoad>{
	
	int pillesh;
	int kalesh;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestOverLoad arr[] = new TestOverLoad[2];
		
		arr[0].kalesh=1;
		arr[0].pillesh=2;
		
		arr[1].kalesh=2;
		arr[2].pillesh=5;
		
		
		/*
		TestOverLoad.addnum(1, 1L);
		TestOverLoad.addnum(null, 1L);
		HashSet<String>  set = new HashSet<>();*/
		
	}
	
	public static void addnum(int x ,int y)
	{
		System.out.println("int");
	}
	
	public static void addnum(long x ,long y)
	{
		System.out.println("long");
	}
	
	public static void addnum(String x ,long y)
	{
		System.out.println("String");
	}
	
	public static void addnum(Object x ,long y)
	{
		System.out.println("Obect");
	}

	

	@Override
	public int compare(TestOverLoad o1, TestOverLoad o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
