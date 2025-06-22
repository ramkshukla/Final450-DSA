package ArrayProblems;

import java.util.Arrays;
import java.util.Scanner;


// Find MAX and MIN BY Set INT_MAX And INT_MIN

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the array : ");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i] = scanner.nextInt();
        }
       
        System.out.println("Minimum Element : " + getMin(arr, length));
        System.out.println("Maximum Element : " + getMax(arr, length));
        scanner.close();
    }
    public static int getMin(int[] arr, int length){
        int minimum = Integer.MAX_VALUE;
        for(int i=0; i<length; i++){
            if(arr[i] < minimum){
                minimum = arr[i];
            }
        }
        return minimum;
    }
    public static int getMax(int[] arr, int length){
        int maximum = Integer.MIN_VALUE;
        for(int i=0; i<length; i++){
            if(arr[i] > maximum){
                maximum = arr[i];
            }
        }
        return maximum;
    }

}


// Maximum and Minimum Element of an array using sorting

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


// Maximum and Minimum Element of an array using Linear Search
/
class Question2{
    public static Pair getMinMax(int[] arr, int length) {
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
    public static void main(String[] args){
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int length = arr.length;
        Pair minmax = getMinMax(arr, length);
        System.out.println("Mimimum Element : "+minmax.min);
        System.out.println("Maximum Element : "+minmax.max);
    }

   
}
class Pair{
    public int max;
    public int min;
}

// Maximum and Minimum Element using Tournament method

class Question2{
    public static Pair getMinMax(int[] arr, int low, int high){
        Pair minmax = new Pair();
        Pair mml = new Pair();
        Pair mmr = new Pair();

        if(low == high){
            minmax.min = arr[low];
            minmax.max = arr[low];
            return minmax;
        }
        if(high == low+1){
            if(arr[low] > arr[high]){
                minmax.min = arr[high];
                minmax.max = arr[low];
            }
            else{
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            return minmax;
        }
        int mid = (low + high)/2;
        mml = getMinMax(arr, low, mid);
        mmr = getMinMax(arr, mid+1, high);

        if(mml.min < mmr.min){
            minmax.min = mml.min;
        }
        else{
            minmax.min = mmr.min;
        }

        if(mml.max > mmr.max){
            minmax.max = mml.max;
        }
        else{
            minmax.max = mmr.max;
        }
        return minmax;
    }
    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int length = arr.length;
        Pair minmax = getMinMax(arr, 0, length-1);
        System.out.println("Minimum Element : " + minmax.min);
        System.out.println("Maximum Element : " + minmax.max);
    }   
}

class Pair{
    public int min;
    public int max;
}


// Maximum and Minimum Elements of an array by comparing by Pairs
class Question2{
    public static Pair getMinMax(int[] arr, int length){
        Pair minmax = new Pair();
        int i;
        if(length%2 == 0){
            if(arr[0] > arr[1]){
                minmax.min = arr[1];
                minmax.max = arr[0];
            }
            else{
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
        }
        else{
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
        }

        while (i < length-1) {
            if(arr[i] > arr[i+1]){
                if(arr[i] > minmax.max){
                    minmax.max = arr[i];
                }
                if(arr[i+1] < minmax.min){
                    minmax.min = arr[i+1];
                }
            }
            else{
                if(arr[i+1] >  minmax.max){
                    minmax.max = arr[i+1];
                }
                if(arr[i] < minmax.min){
                    minmax.min = arr[i];
                }
            }
            i+=2;
        }
        return minmax;
    }
    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int length = arr.length;
        Pair minmax = getMinMax(arr, length);
        System.out.println("Minimum Element : " + minmax.min);
        System.out.println("Maximum Element : " + minmax.max);
    }
}

class Pair{
   public int min;
   public int max;
}