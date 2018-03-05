import java.util.*;
//Given a set of words and a word, find the frequencies of that word
public class WordFrequencies {
    Map<String, Integer> map;
    public WordFrequencies(List<String> list){
        map = new HashMap();
        update(list, map);
    }
    
    public void update(List<String> list, Map<String, Integer> map){
        for(String s:list){
            map.put(s, map.getOrDefault(s,0)+1);
        }
    }
    
    public int frequency(String word){
        return map.getOrDefault(word,0);
    }
}
