package ArrayProblems;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;


// Reverse an Array Using Temp Arrays
public class Question1{
    public static void main(String[] args){
        System.out.println("Enter the length of the arrays");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        System.out.println("Enter the element of the array : ");
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i] = scanner.nextInt();
        }
        int[] brr = new int[length];
        int j = length;
        for(int i=0; i<length; i++){
            brr[j-1] = arr[i];
            j = j-1;
        }
        System.out.println("Enter the element of the array : ");
        for(int i=0; i<length; i++){
            System.out.print(brr[i] + " ");
        }
        scanner.close();
    }
}


// Reverse an Array Using Swapping Method
/* 
class Question1{
    public static void main(String[] args){
        System.out.println("Enter the length of the array : ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i] = scanner.nextInt();
        }

        for(int i=0; i<length/2; i++){
            int t = arr[i];
            arr[i] = arr[length-i-1];
            arr[length-i-1] = t;
        }

        System.out.println("Reverse Array : ");
        for(int i=0; i<length; i++){
            System.out.print(arr[i] + " ");
        }
        scanner.close();
    }
}
*/

// Reverse an Array Collections.Reverse Method
/* 
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
*/

// Reverse an Array Using StringBuilder.append() Method
/* 
class Question1{
    public static void main(String[] args) {
        String[] arr = {"Hello", "World"};
        StringBuilder reversedArray = new StringBuilder();
        for(int i=arr.length; i>0; i--){
            reversedArray.append(arr[i-1]).append(" ");
        }
        String[] reverse = reversedArray.toString().split(" ");
        System.out.println(Arrays.toString(reverse));
    }
}
*/