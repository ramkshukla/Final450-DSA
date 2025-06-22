import java.math.*;
//To find the maximum profit by buying and selling a share at most twice, you need to perform two transactions:
//        Buy low, sell high
//And then again buy low, sell high (after the first sell)
public class Question26 {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices));


    }

    public static int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);           // Buying first stock
            sell1 = Math.max(sell1, buy1 + price);   // Selling first stock
            buy2 = Math.max(buy2, sell1 - price);    // Buying second stock with profit from first sell
            sell2 = Math.max(sell2, buy2 + price);   // Selling second stock
        }

        return sell2;
    }

//    public static int maxProfit(int[] prices){
//        int n = prices.length;
//        if(n==0) return 0;
//
//        int[] left = new int[n];
//        int[] right = new int[n];
//
//        int minPrice = prices[0];
//
//        for(int i=1; i<n; i++){
//            minPrice = Math.min(minPrice, prices[i]);
//            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
//        }
//
//        int maxPrice = prices[n - 1];
//
//        for (int i = n - 2; i >= 0; i--) {
//            maxPrice = Math.max(maxPrice, prices[i]);
//            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
//        }
//
//        int maxProfit = 0;
//
//        for (int i = 0; i < n; i++) {
//            maxProfit = Math.max(maxProfit, left[i] + right[i]);
//        }
//
//        return maxProfit;

//    }
}