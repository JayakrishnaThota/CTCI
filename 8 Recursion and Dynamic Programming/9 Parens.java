//Exponential time and space solution O(4pown)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        helper(list, "", n, 0, 0);
        return list;
    }
    public void helper(List<String> list, String s, int n, int l, int h){
        if(s.length()==n*2){
            list.add(s);
            return;
        }
        if(l<n)
            helper(list,s+"(",n,l+1,h);
        if(h<l)
            helper(list,s+")",n,l,h+1);
    }
}
