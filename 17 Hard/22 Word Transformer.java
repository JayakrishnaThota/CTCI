public class Solution {
    List<List<String>> result;
    List<String> list;
    HashMap<String,List<String>> map;
    public List<List<String>> findLadders(String start, String end, List<String> dict) 
    {
        result = new ArrayList<List<String>>();
        list = new ArrayList();
        map = new HashMap();
        if(dict.size()==0) return result;
        boolean done = false;
        int curr =1, next=0;
        Queue<String> queue = new LinkedList();
        HashSet<String> unvisited = new HashSet(dict);
        HashSet<String> visited = new HashSet();
        visited.add(start);
        unvisited.remove(start);
        queue.offer(start);
        while(!queue.isEmpty()){
            String word = queue.poll();
            curr--;
            for(int i=0;i<word.length();i++){
                char[] ch = word.toCharArray();
                char temp = ch[i];
                for(char c='a';c<='z';c++){
                    ch[i] = c;
                    String nw = String.valueOf(ch);
                    if(unvisited.contains(nw)){
                        if(visited.add(nw)){
                            next++;
                            queue.add(nw);
                        }
                        if(map.containsKey(nw)){
                            map.get(nw).add(word);
                        }
                        else{
                        List<String> l = new ArrayList();
                            l.add(word);
                        map.put(nw,l);
                        }
                    if(nw.equals(end)&&!done){
                        done = true;
                    }
                }                   
            }
            }
                if(curr==0){
                    if(done) break;
                    curr = next;
                    next = 0;
                    unvisited.removeAll(visited);
                    visited.clear();
                }
        }
        backtrace(end,start);
        return result;
    }
        public void backtrace(String end, String start){
            if(end.equals(start)){
                list.add(0,start);
	    		result.add(new ArrayList<String>(list));
	    		list.remove(0);
	    		return;
            }
            list.add(0,end);
            if(map.get(end)!=null){
                for(String s:map.get(end)){
                    backtrace(s,start);
                }
            }
            list.remove(0);
        }
}
