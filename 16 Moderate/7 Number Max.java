
public class Maximum {
    public static int max(int a, int b){
        //check overflow
        //overflow occurs when a and b have different signs
        //so check if a and b have different signs
        int asign = (a>>31)&1;
        int bsign = (b>>31)&1;
        //If a and b have different signs, return the positive one
        if((asign^bsign)==1){
            return asign==1?a:b;
        }
        int c = (a-b);
        int p = (c>>31)&1;
        int q = ~p;
        return a*p + b*q;
    }
    public static void main(String[] args){
        System.out.println(max(5,7));
        System.out.println(max(5,-7));
        System.out.println(max(-5,7));
        System.out.println(max(-5,-7));
    }
}
