import java.util.*;
public class test {
	public boolean isUnique(String s){
		boolean[] map = new boolean[128];
		for(int i=0;i<s.length();i++){
			int ascii = (int)s.charAt(i);
			if(map[ascii])
				return false;
			map[ascii] = true;
		}
		return true;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		test t = new test();
		System.out.println(t.isUnique(input));

	}
}
