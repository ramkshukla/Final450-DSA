package ArrayProblems;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;


// Reverse an Array Using StringBuilder.append() Method

class Question1{
    public static void main(String[] args) {
        String[] arr = {"Hello", "World"};
        StringBuilder reversed = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            reversed.append(arr[i]).append(" ");
        }

        String[] reversedArray = reversed.toString().split(" ");
        System.out.println(Arrays.asList(reversedArray));
    }
}
// Reverse an Array Using Temp Arrays

public class Question1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of array : ");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i] = scanner.nextInt();
        }
        int[] temp = new int[length];
        int j = length;
        for(int i=0; i<length; i++){
            temp[j-1] = arr[i];
            j--;
        }

        for(int k=0; k<length; k++){
            System.out.print(temp[k] + " ");
        }
        scanner.close();
    }
}


// Reverse an Array Using Swapping Method


class Question1{
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the length of the array : ");
    int length = scanner.nextInt();
    int[] arr = new int[length];
    for(int i=0; i<length; i++){
        arr[i] = scanner.nextInt();
    }

    for(int i=0; i<length/2; i++){
        int temp = arr[i];
        arr[i] = arr[length-i-1];
        arr[length-i-1] = temp;
    }

    for(int i=0; i<length; i++){
        System.out.print(arr[i] + " ");
    }
    scanner.close();
    }
}


// Reverse an Array Collections.Reverse Method


class Question1{
    public static void main(String[] args) {
        System.out.println("Enter the length of the array : ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        System.out.println("Enter the element of the array : ");
        Integer[] arr = new Integer[length];
        for(int i=0; i<length; i++){
            arr[i] = scanner.nextInt();
        } 
        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}