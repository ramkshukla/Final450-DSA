// In array processing, an inversion is a pair of elements that are out of order. Formally:
//Given an array arr[], a pair (i, j) is an inversion if i < j and arr[i] > arr[j].

public class Question16{
    public static void main(String[] args) {
//        int[] arr = {2,4,1,3,5};
//        System.out.println("Inversion Count : " + countInversion(arr));

        int[] arr = {2,4,1,3,5};
        int[] temp = new int[arr.length];
        int result = mergeSort(arr, temp, 0, arr.length-1);
        System.out.println("Inversion Count : " + result);
    }

    public static int mergeSort(int[] arr, int[] temp, int left, int right){
        int mid = 0;
        int invCount = 0;
        if(right > left){
            mid = (right + left) / 2;
            invCount += mergeSort(arr,temp,left,mid);
            invCount += mergeSort(arr, temp, mid+1, right);

            invCount += merge(arr, temp, left, mid+1, right);
        }
        return invCount;
    }

    public static int merge(int[] arr, int[] temp, int left, int mid, int right){
        int i = left;
        int j = mid;
        int k = left;
        int invCount = 0;

        while ((i <= mid-1) && (j <= right)){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
                invCount += (mid - i);
            }
        }
        while (i <= mid - 1) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (i = left; i <= right; i++) arr[i] = temp[i];

        return invCount;
    }
//    public static int countInversion(int[] arr){
//        int count = 0;
//        for(int i=0; i< arr.length-1; i++){
//            for(int j=i+1; j<arr.length; j++){
//                if(arr[j] > arr[i]){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
}