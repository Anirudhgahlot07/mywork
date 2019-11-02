package com.java.Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegistrationFormProblem {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String words[]  = new String[num];
		
		for(int i=0;i<num;i++)
		{
			
			words[i]=br.readLine();
		}
		
		int number2 = Integer.parseInt(br.readLine());
		String lines[] = new String[number2];
		
		for(int i=0;i<num;i++)
		{
			
			lines[i]=br.readLine();
		}
		
		calculateLines(words,lines);
	}
	
	public static void calculateLines(String words[],String lines[])
	{
		int lenwd = words.length;
		int lenlines = lines.length;
		
		for(int i=0;i<lenlines;i++)
		{
			
				
		}
		
	}
}
