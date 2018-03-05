//O(n) and O(1)
class Solution {
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int maj = nums[0],count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==maj)
                count++;
            else{
                count--;
                if(count==0){
                    maj = nums[i];
                    count = 1;
                }
            }
        }
        return validate(nums, maj)?maj:-1;
    }
    
    public boolean validate(int[] nums, int maj){
      int count = 0;
      for(int n:nums){
        if(maj==n) count++;
      }
      return (count>nums.length/2);
    }
}
