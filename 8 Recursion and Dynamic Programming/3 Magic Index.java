   public class MagicIndex {
        public int magicFast(int[] array) {
            return magicFast(array, 0, array.length - 1);
        }

        public int magicFast(int[] array, int start, int end) {
            if (end< start) return -1;

            int midindex =(start+ end)/ 2;
            int midValue = array[midindex];
            if (midValue == midindex) {
                return midindex;

            }


            int leftindex = Math.min(midindex - 1, midValue);
            int left = magicFast(array, start, leftindex);
            if (left>= 0) {
                return left;

            }


            int rightindex = Math.max(midindex + 1, midValue);
            int right = magicFast(array, rightindex, end);

            return right;
        }
