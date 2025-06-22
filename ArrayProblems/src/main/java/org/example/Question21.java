public class Question21 {
    public static void main(String[] args) {
        int[] nums = {4,2,-3,1,6};
        if(hasZeroSumSubArray(nums)){
            System.out.println("Yes, a subarray with sum 0 exists.");
        }else{
            System.out.println("No, such subarray does not exist.");
        }
    }
    public static boolean hasZeroSumSubArray(int[] arr){
        // 0(n2)

        int n = arr.length;
        for(int i=0; i<n; i++){
             int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                if(sum == 0) return true;
            }
        }

        // 0(n)

//        Set<Integer> prefixSum = new HashSet<>();
//        int sum = 0;
//        for(int num : arr){
//            sum += num;
//            if(sum == 0 || prefixSum.contains(sum)){
//                return  true;
//            }
//            prefixSum.add(sum);
//        }
        return false;
    }
}