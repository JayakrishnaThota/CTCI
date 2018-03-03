public class Solution{
  public int rand7() {
    while (true) {
       int num = 5 * randS() + randS();
       if (num < 21) {
         return num % 7;
       }
   }
  }
}
