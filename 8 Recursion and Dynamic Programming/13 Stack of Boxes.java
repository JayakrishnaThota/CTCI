import java.util.Arrays;
import java.util.Comparator;

//Given an array of boxes(length, breadth and height
//Stack the boxes in such a way that it accomodates max box height and return the max height
public class boxstacking {
    public static class Box{
        int length;
        int breadth;
        int height;
        int basearea;
        public Box(int l, int b, int h){
            this.length = l;
            this.breadth = b;
            this.height = h;
            this.basearea = l*b;
        }
    }

    //O(n2) time and O(n) space
    private int getHeight(Box[] b){
        int n = b.length;
        Box[] allvariants = new Box[n*3];
        //Always keep breadth smaller than length
        for(int i=0;i<n;i++){
            int tl = b[i].length;
            int tb = b[i].breadth;
            int th = b[i].height;
            allvariants[3*i] = new Box(Math.max(tb,th), Math.min(tb,th),tl);
            allvariants[3*i+1] = new Box(Math.max(tl,th), Math.min(tl,th), tb);
            allvariants[3*i+2] = new Box(Math.max(tl,tb),Math.min(tl, tb),th);
        }
        for(int i=0;i<3*n;i++){
            allvariants[i].basearea = allvariants[i].length*allvariants[i].breadth;
        }
        //Sort all the boxes in decreasing order of base areas
        Arrays.sort(allvariants, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o2.basearea - o1.basearea;
            }
        });
        int[] h = new int[3*n];
        int newl = 3*n;
        for(int i=0;i<newl;i++)
            h[i] = allvariants[i].height;
        for(int i=0;i<newl;i++){
            h[i] = 0;
            Box box = allvariants[i];
            int val = 0;
            for(int j=0;j<i;j++){
                Box prev = allvariants[j];
                if(box.length<prev.length && box.breadth< prev.breadth){
                    val = Math.max(val,h[j]);
                }
            }
            h[i] = val + box.height;
        }
        //return the max height from h array
        int max = -1;
        for(int i:h){
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        Box[] b = new Box[4];
        boxstacking bs = new boxstacking();
        b[0] = new Box(4,6,7);
        b[1] = new Box(1,2,3);
        b[2] = new Box(4,5,6);
        b[3] = new Box(10,12,32);
        System.out.println("The max height of the boxes stacked is "+bs.getHeight(b));
    }
}
