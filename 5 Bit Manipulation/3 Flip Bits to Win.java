public class FlipBits {
    public int flip(int n){
        int prevLength = 0;
        int curLength = 0;
        int maxLength = 1;
        while(n!=0){
            if((n&1)==1){
                curLength++;
            }
            else if((n&1)==0){
                prevLength = ((n&2)==0)?0:curLength;
                curLength = 0;
            }
            maxLength = Math.max(maxLength, curLength+prevLength+1);
        }
        return maxLength;
    }
}
