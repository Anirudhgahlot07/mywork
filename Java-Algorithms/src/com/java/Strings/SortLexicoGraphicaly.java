package com.java.Strings;

public class SortLexicoGraphicaly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//System.out.println(SortLexi("geeks"));
			System.out.println(strstr("GeeksForGeeks" , "For"));
		
	}
	
	static String SortLexi(String str)
	{
		int len = str.length();
		char arr[] = new char[len];
		int count=0;
		
		int countarr[] = new int[26];
		
		for(int i=0;i<len;i++)
		{
		
			countarr[str.charAt(i)-'a']++;
		}
		for(int i=25;i>=0;)
		{
			if(countarr[i]>0)
			{
				arr[count++]=(char)(i+'a');
				countarr[i]--;
			}
			else
				i--;
		}
		
		return String.valueOf(arr);
		
	}
	

   static  int strstr(String s, String x)
    {
       // Your code here
       
    int index=0;
     //Your code here
     if(s.length()<x.length())
        return -1;
        else
        {
            int len = s.length();
            int len2= x.length();
            
            for(int i=0,j=0;i<len;i++)
            {
                for( j=0;j<len2;)
                {
                    if(s.charAt(i)==x.charAt(j))
                        {
                            index++;
                            j++;
                            i++;
                            
                        }
                        else
                        {
                            index=0;
                        break;
                        }
                            
                }
                if(j==len2)
                    return i-index;
            }
            
            return -1;
        }

    }


}
