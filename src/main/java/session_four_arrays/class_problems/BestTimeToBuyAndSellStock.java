package session_four_arrays.class_problems;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solver = new BestTimeToBuyAndSellStock();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int profit1 = solver.maxProfit(prices1);
        System.out.println("Input: " + Arrays.toString(prices1) + " -> Output: " + profit1);

        int[] prices2 = {7, 6, 4, 3, 1};
        int profit2 = solver.maxProfit(prices2);
        System.out.println("Input: " + Arrays.toString(prices2) + " -> Output: " + profit2);
    }
}
