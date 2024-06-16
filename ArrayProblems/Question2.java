package ArrayProblems;

import java.util.Arrays;
import java.util.Scanner;


// Find MAX and MIN BY Set INT_MAX And INT_MIN
/* 
public class Question2 {
    public static void main(String[] args) {
        System.out.println("Enter the length of the array : ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        System.out.println("Enter the element of the arrays : ");
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Maximum Value : " + max);

        int min = Integer.MAX_VALUE;
        for(int i=0; i<length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("Minimum Value : " + min);

        scanner.close();
    }
}
*/

// Maximum and Minimum Element of an array using sorting
/* 
class Question2{
public static void main(String[] args) {
    System.out.println("Enter the length of the array : ");
    Scanner scanner = new Scanner(System.in);
    int length = scanner.nextInt();
    System.out.println("Enter the length of the array : ");
    int[] arr = new int[length];
    for(int i=0; i<length; i++){
        arr[i] = scanner.nextInt();
    }
    Arrays.sort(arr);
    Pair minmax = new Pair();
    minmax.min = arr[0];
    minmax.max = arr[length-1];
    System.out.println("Maximum Element : "+minmax.max);
    System.out.println("Minimum Element : "+minmax.min);

    scanner.close();
}
}
class Pair{
    public int max;
    public int min;
}
*/

// Maximum and Minimum Element of an array using Linear Search
/* 
class Question2{
    public static Pair getMinMax(int[] arr, int length){
        Pair minmax = new Pair();
        if(length == 1){
            minmax.min = arr[0];
            minmax.max = arr[0];
            return minmax;
        }
        
        if(arr[0] > arr[1]){
            minmax.max = arr[0];
            minmax.min = arr[1];
        }
        else{
            minmax.max = arr[1];
            minmax.min = arr[0];
        }

        for(int i=2; i<length; i++){
            if(arr[i] > minmax.max){
                minmax.max = arr[i];
            }
            else if (arr[i] < minmax.min){
                minmax.min = arr[i];
            }
        }
        return minmax;
    }
    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int length = 6;
        Pair minmax = getMinMax(arr, length);
        System.out.println("Minimum Element : " + minmax.min);
        System.out.println("Maximum Element : " + minmax.max);
    }
}
class Pair{
    public int max;
    public int min;
}
 */

// Maximum and Minimum Element using Tournament method

class Question2{

    public static Pair getMinMax(int[] arr, int low, int high) {
        Pair minmax = new Pair();
        Pair mml = new Pair();
        Pair mmr = new Pair();
        if(low == high){
            minmax.min = arr[low];
            minmax.max = arr[high];
            return minmax;
        }

        if(high == low+1){
            if(arr[low] < arr[high]){
                minmax.min = arr[low];
                minmax.max = arr[high];
            }
            else{
                minmax.max = arr[low];
                minmax.min = arr[high];
            }
        }

        int mid = (low+high)/2;
        mml = getMinMax(arr, low, mid);
        mmr = getMinMax(arr, mid+1, high);

        if(mml.min < mmr.min){
            minmax.min = mml.min;
        }
        else{
            minmax.min = mmr.min;
        }

        if(mml.max < mmr.max){
            minmax.max = mml.max;
        }
        else{
            minmax.max = mmr.max;
        }


        return minmax;
    }
    public static void main(String[] args) {
        System.out.println("Enter the length of the array : ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];

        for(int i=0; i<length; i++){
            arr[i] = scanner.nextInt();
        }

        Pair minmax = new Pair();
        minmax = getMinMax(arr, 0, length-1);
        System.out.println("Minimum Element : " + minmax.min);
        System.out.println("Maximum Element : " + minmax.max);
        scanner.close();

    }

   
}

class Pair{
    public int min;
    public int max;
}