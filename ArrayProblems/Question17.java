// Best Time to Buy and Sell Stock

public class Question17 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Max Profit: " + maxProfit(prices));
    }
//    public static int maxProfit(int[] prices){
//        int minPrice = Integer.MAX_VALUE;
//        int maxProfit = 0;
//
//        for(int price : prices){
//            if(price < minPrice){
//                minPrice = price;
//            } else if (price - minPrice > maxProfit) {
//                maxProfit = price - minPrice;
//            }
//        }
//        return maxProfit;
//    }

    public static int maxProfit(int[] prices){
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[j] - prices[i] > maxProfit){
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

}