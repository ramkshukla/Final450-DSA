import java.util.*;
public class Question14 {
    public static void main(String[] args) {
        int[][] interval = {{1,3}, {2,6}, {8,10},{15,18}};
        System.out.println("Test Case 1: Intervals = " + intervalsToString(interval));
        int[][] result = merge(interval);
        System.out.println("Merged: " + intervalsToString(result));
    }

    public static int[][] merge(int[][] intervals){
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort((intervals), (a,b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        // Iterate through sorted intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            int[] current = intervals[i];

            // Check for overlap (current.start <= last.end)
            if (current[0] <= last[1]) {
                // Merge by updating end time
                last[1] = Math.max(last[1], current[1]);
            } else {
                // No overlap, add current interval
                merged.add(current);
            }
        }

        // Convert list to array
        return merged.toArray(new int[merged.size()][]);
    }

    public static String intervalsToString(int[][] arr){
        if(arr == null) return "null";
        if(arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i<arr.length; i++){
            sb.append("[").append(arr[i][0]).append(",").append(arr[i][1]).append("]");
            if(i < arr.length-1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}