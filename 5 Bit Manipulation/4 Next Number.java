
public class NextGreater {
    
	public static int getNext(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		
		int pos = c0 + c1; 
		n |= (1 << pos); // Flip right-most non-trailing zero
		n &= ~((1 << pos) - 1); 
		n |= (1 << (c1 - 1)) - 1;
		
		return n;
	}
	
	public static int getPrev(int n) {
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}
		if (temp == 0) { 
			return -1;
		}
		while (((temp & 1) == 0) && (temp != 0)) {
			c0++;
			temp >>= 1;
		}
		int p = c0 + c1; // position of right-most non-trailing one (where the right most bit is bit 0)
		n &= ((~0) << (p + 1)); // clears from bit p onwards (to the right)
		int mask = (1 << (c1 + 1)) - 1; // Sequence of (c1+1) ones
		n |= mask << (c0 - 1);  
		
		return n;		
	}	
	
	
}
