import java.util.*;

public class SparseSearch {

    public static int sparseSearch(String[] words, String word, int low, int high){
        if(low>high) return -1;
        int mid = low+(high-low)/2;
        //If the mid word is empty, move to the closest non empty word
        if(words[mid].length()==0){
            int left = mid-1;
            int right = mid+1;
            while (true){
                if(left<low && right>high) return -1;
                else if(right<=high && (words[right].length()!=0)){
                    mid = right;
                    break;
                }
                else if(left>=low && (words[left].length()!=0)){
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }
        if(words[mid].equals(word)) return mid;
        else if(words[mid].compareTo(word)<0) return sparseSearch(words,word,mid+1,high);
        else return sparseSearch(words,word,low,mid-1);
    }

    public static void main(String[] args) {
        String[] words = {"at", "", "", "","ball", "","","car","","","dad","" ,""};
        System.out.println(sparseSearch(words,"ball",0,words.length-1));
    }
}
