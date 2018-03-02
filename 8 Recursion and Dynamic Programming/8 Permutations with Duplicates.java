import java.util.*;

public class Permutations {

    public List<String> permutations(String s){
        List<String> list = new ArrayList<>();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        s = String.valueOf(ch);
        helper(list, new ArrayList<>(), s);
        return list;
    }

    public void helper(List<String> list, List<Character> sublist, String s){
        if(sublist.size()==s.length()){
            String result = "";
            for(char c:sublist) result+=c;
            list.add(result);
            return;
        }
        for(int i=0;i<s.length();i++){
            sublist.add(s.charAt(i));
            helper(list, sublist, s);
            sublist.remove(sublist.size()-1);
        }
    }

    public void display(List<String> list){
        for(String l: list){
            System.out.println("["+l+"]");
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        String s = "aaa";
        List<String> list = p.permutations(s);
        System.out.println("The possible permutations of the given string are ");
        p.display(list);
    }
}
