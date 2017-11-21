import java.util.*;
public class test {
	public String replaceSpaces(String s)
	{
		char[] str = s.toCharArray();
		int truelength = str.length;
	    int spaceCount = 0, index=0, i = 0;
	    for (i = 0; i < truelength; i++)
	    {
			 if (str[i] == ' ')
			 spaceCount++;
		}

			index = truelength + spaceCount * 2;
			char[] newstr = new char[index];
			for (i = truelength - 1; i >= 0; i--)
			{
				if (str[i] == ' ')
				{
					newstr[index-1] = '0';
					newstr[index - 2] = '2';
					newstr[index - 3] = '%';
					index = index - 3;
				}
				else
				{
				  newstr[index - 1] = str[i];
				  index--;
				}
			}
			return String.valueOf(newstr);
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		test t = new test();
		System.out.println(t.replaceSpaces(input));
	}
}
