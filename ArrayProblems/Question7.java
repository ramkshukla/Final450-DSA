package ArrayProblems;

public class Question7 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        rotateByOne(arr1);
        System.out.println("After rotation: " + arrayToString(arr1));
    }

    public static  void rotateByOne(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Array must not be null or empty");
        }
//        int temp = arr[0];
//        for(int i=1; i<arr.length; i++){
//            arr[i-1] = arr[i];
//        }
//        arr[arr.length-1] = temp;

        int temp = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = temp;
    }
    public static  String arrayToString(int[] arr){
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
}
