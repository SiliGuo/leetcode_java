// Binary Search
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // If nums1 longer than nums2, switch position
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = len1;
        int k = (len1 + len2 + 1) / 2; // median position
        int mid1 = 0, mid2 = 0;
        
        // Find median numbers
        while (low <= high) {
            mid1 = low + (high - low) / 2;
            mid2 = k - mid1;
            if (mid1 < (len1) && (nums1[mid1] < nums2[mid2-1])) {
                low = mid1 + 1;
            } else if (mid1 > 0 && (nums1[mid1-1] > nums2[mid2])) {
                high = mid1 - 1;
            } else {
                break;
            }
        }
        
        int midL, midR;
        if (mid1 == 0) {
            midL = nums2[mid2-1];
        } else if (mid2 == 0) {
            midL = nums1[mid1-1];
        } else {
            midL = Math.max(nums1[mid1-1], nums2[mid2-1]);
        }
        
        if ((len1 + len2) % 2 == 1) return midL;
        
        if (mid1 == len1) {
            midR = nums2[mid2];
        } else if (mid2 == len2) {
            midR = nums1[mid1];
        } else {
            midR = Math.min(nums1[mid1], nums2[mid2]);
        }
        return (float)(midL + midR) / 2;
        
    }
}
