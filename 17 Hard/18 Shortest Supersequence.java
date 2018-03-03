public class Solution {
    public String minWindow(String s, String t) {
        //Trivial case
        if(s==null||t==null||s.length()<t.length()) return "";
        //Maintain a hashmap for each character in t and it's frequency as value
        Map<Character,Integer> map = new HashMap<>();
        for(char c: t.toCharArray())
        {
            if(!map.containsKey(c)) map.put(c,1);
            else map.put(c,map.get(c)+1);
        }
        //Find the first instance of 
        int left=0,count=0,minLength=s.length()+1,minLeft=0;
        for(int right=0;right<s.length();right++)
        {
            char r = s.charAt(right);
            if(map.containsKey(r)) 
            { 
                map.put(r,map.get(r)-1); if(map.get(r)>=0) count++; 
            }
                while(count==t.length())
                {
                    if(right-left+1<minLength)
                    {
                        minLength = right-left+1;
                        minLeft = left;
                    }
                    if(map.containsKey(s.charAt(left)))
                    {
                        char l = s.charAt(left);
                        map.put(s.charAt(left),map.get(s.charAt(left))+1);
                        if(map.get(s.charAt(left)) > 0)    count --;
                    }
                    left++;
                }     
            }            
        return (minLength>s.length())?"":s.substring(minLeft,minLeft+minLength);    
    }
}
