// The Trapping Rain Water problem is a classic interview problem that can be solved efficiently using various approaches
public class Question29 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped water: " + trap(height));
    }

    // ✅ Space Optimized Version (Two Pointers Approach, O(1) Space):

    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    water += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

    // ✅ Java Solution using Precomputed Left and Right Max Arrays (Time: O(n), Space: O(n))
//    public static int trap(int[] height){
//        int n = height.length;
//        if(n==0) return 0;
//
//        int[] leftMax = new int[n];
//        int[] rightMax = new int[n];
//        int water = 0;
//
//        leftMax[0] = height[0];
//        for(int i=1; i<n; i++){
//            leftMax[i] = Math.max(leftMax[i-1], height[i]);
//        }
//
//        rightMax[n-1] = height[n-1];
//        for(int i=n-2; i>=0; i--){
//            rightMax[i] = Math.max(rightMax[i+1], height[i]);
//        }
//
//        for (int i = 0; i < n; i++) {
//            water += Math.min(leftMax[i], rightMax[i]) - height[i];
//        }
//
//        return water;
//    }
}