public class Insertion {
    public int insert(int a, int b, int j, int i){
        int allOnes = ~0;
        int left = (1<<i)-1;
        int right = allOnes<<(j+1);
        int mask = left|right;
        int cleared = a&mask;
        int shifted = b<<i;
        return cleared|shifted;
    }
}
