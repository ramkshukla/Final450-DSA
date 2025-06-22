import java.util.List;
import java.util.ArrayList;
// find common elements in 3 sorted arrays
public class Question19 {
    public static void main(String[] args) {
        int[] A = {1, 5, 10, 20, 40, 80};
        int[] B = {6, 7, 20, 80, 100};
        int[] C = {3, 4, 15, 20, 30, 70, 80, 120};

        List<Integer> commons = findCommonElements(A, B, C);
        System.out.println("Common elements: " + commons);
    }
    public static List<Integer> findCommonElements(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;
        List<Integer> result = new ArrayList<>();

        while (i < A.length && j < B.length && k < C.length) {
            // If elements at all three pointers are equal
            if (A[i] == B[j] && B[j] == C[k]) {
                // Avoid duplicates
                if (result.isEmpty() || result.get(result.size() - 1) != A[i]) {
                    result.add(A[i]);
                }
                i++; j++; k++;
            }
            // Find the smallest and move its pointer
            else if (A[i] < B[j]) i++;
            else if (B[j] < C[k]) j++;
            else k++;
        }

        return result;
    }
}