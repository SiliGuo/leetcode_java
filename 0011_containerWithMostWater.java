// Two Pointers
class Solution {
    public int maxArea(int[] height) {
        // Use two pointers loop from both sides of array
        int left = 0; // left pointer
        int right = height.length - 1; // right pointer
        int res = 0; // result: max area of water
        
        while(left < right) {
            // height of water depends on min of two pointers
            if (height[left] < height[right]) {
                res = Math.max(res, (right - left) * height[left++]);
            } else {
                res = Math.max(res, (right - left) * height[right--] );
            }
        }
        
        return res;
    }
}
