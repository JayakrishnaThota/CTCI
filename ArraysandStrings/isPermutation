import java.util.*;
public class test {
	public boolean isPermutation(String s, String t){
		int[] map = new int[128];
		for(int i=0;i<s.length();i++){
			int ascii = (int)s.charAt(i);
			map[ascii]++;
		}
		for(int i=0;i<t.length();i++){
			int ascii = (int)t.charAt(i);
			map[ascii]--;
		}
		for(int i=0;i<128;i++){
			if(map[i]!=0)
				return false;
		}
		return true;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String input1 = in.nextLine();
		String input2 = in.nextLine();
		test t = new test();
		System.out.println(t.isPermutation(input1,input2));
	}
}
