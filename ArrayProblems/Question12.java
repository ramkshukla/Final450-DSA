package ArrayProblems;

public class Question12 {

    public static void merge(int[] arr1,int[] arr2){
        if(arr1 == null || arr2 == null){
            throw new IllegalArgumentException("Array can not be null");
        }
        int n = arr1.length;
        int m = arr2.length;
        if(n==0&& m==0){
            return;
        }
        int gap = (n+m+1)/2;
        while (gap>=1){
            int i=0;

            while (i+gap< n+m){
                if(i < n && i+gap < n){
                    if(arr1[i] > arr1[i+gap]){
                        swap(arr1, i, arr1, i + gap);
                    }
                }else if(i<n&&i+gap>=n){
                    int j=i+gap-n;
                    if (arr1[i] > arr2[j]) {
                        swap(arr1, i, arr2, j);
                    }
                }
                else{
                    int j = i + gap - n;
                    if (arr2[i - n] > arr2[j]) {
                        swap(arr2, i - n, arr2, j);
                    }
                }
                i++;
            }
            gap = (gap == 1) ? 0 : (gap + 1) / 2;
        }
    }
    public static void swap(int[] arr1, int i, int[] arr2, int j){
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }

    public static String arrayToString(int[] arr){
        if(arr == null) return  "null";
        if(arr.length == 0) return  "[]";
        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
            if(i < arr.length-1) sb.append(", ");
        }
        sb.append("]");
        return  sb.toString();
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5};
        int[] arr2 = {2,4,6};
        System.out.println("Test Case 1: arr1 = " + arrayToString(arr1) + ", arr2 = " + arrayToString(arr2));
        try {
            merge(arr1, arr2);
            System.out.println("After merge: arr1 = " + arrayToString(arr1) + ", arr2 = " + arrayToString(arr2));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
