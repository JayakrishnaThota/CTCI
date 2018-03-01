public class Solution
{
  public int swapOddEvenBits(int x) {
   return ( ((x & 0xaaaaaaaa) >>> 1) I ((x & 0x55555555) << 1) );
  }
}
