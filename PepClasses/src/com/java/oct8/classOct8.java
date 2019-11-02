package com.java.oct8;

public class classOct8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve_wordbreak();

	}
	
	static boolean iswordpresent(String dict[],String str)
	{

	    for(String s:dict)
	    {
	        if(s.equals(str))
	            return true;
	    }
	    return false;

	}

	static int wordbreak(String dict[],String question,String ans)
	{
	    if(question.length()==0)
	    {
	     System.out.println(ans);
	        return 1;   
	    }

	    int count=0;
	    for(int i=1;i<=question.length();i++)
	    {
	        String str = question.substring(0,i);
	        if(iswordpresent(dict,str))
	        {
	            count+=wordbreak(dict,question.substring(i),ans+str+" ");
	        }
	    }

	        return count;
	}


	static void solve_wordbreak()
	{
	    String  dict[] ={"samsung","sam","sung","i","like"};
	    String str = "ilikesamsung";
	    System.out.println(wordbreak(dict,str,""));
	    
	}

}
