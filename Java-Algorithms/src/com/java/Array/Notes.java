package com.java.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Notes {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		ArrayList<String> input= new ArrayList<String>();
		System.out.println("Enter the input: ");
		for(int i=0;i<n;i++)
		{
			input.add(sc.nextLine());
		}
		solution(input);
		
		
		
		Bag bag=new Bag();
		bag.add(new Note(83));
		bag.add(new Coin(19));
		bag.add(new Coin(85));
		bag.add(new Note(8));
		bag.add(new Note(30));
		bag.add(new Coin(56));
		bag.add(new Coin(53));
		bag.display();

	}

	private static void solution(ArrayList input) {
		ArrayList<Integer> coins=new ArrayList<Integer>();
		ArrayList<Integer> notes=new ArrayList<Integer>();
		for(int i=0; i<input.size();i++)
		{
			String[] in=((String) input.get(i)).split(" ");
			if(in[0].equalsIgnoreCase("coin"))
			{
				coins.add(Integer.parseInt(in[1]));
			}
			else if(in[0].equalsIgnoreCase("note"))
			{
				notes.add(Integer.parseInt(in[1]));
			}
		}
		System.out.println("Coins: ");
		for(int i=0;i<coins.size();i++)
		{
			System.out.println(coins.get(i));
		}
		System.out.println();
		System.out.println("Notes: ");
		for(int i=0;i<notes.size();i++)
		{
			System.out.println(notes.get(i));
		}
	}

}

class Coin
{
	int value;
	Coin(int value)
	{
		setValue(value);
	}
	public void setValue(int value)
	{
		this.value=value;
	}
	public int getValue()
	{
		return value;
	}
	public String toString()
	{
		return String.valueOf(value);
	}
}

class Note
{
	int value;
	Note(int value)
	{
		setValue(value);
	}
	public void setValue(int value)
	{
		this.value=value;
	}
	public int getValue()
	{
		return value;
	}
	public String toString()
	{
		return String.valueOf(value);
	}
}



class Bag<T>
{
	Bag root;
	T type;
	
	public void add(T type)
	{
		if(root==null)
		{
			root=new Bag();
			root.type=type;
		}
		else
		{
			Bag temp = root;
			while(temp.root!=null)
			{
				temp=temp.root;
			}
			temp=new Bag();
			temp.type=type;
		}
	}
	public void display()
	{
		Bag temp=root;
		while(temp.root!=null)
		{
			System.out.println(temp.type.toString());
		}
	}
}