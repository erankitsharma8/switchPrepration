package org.example;

public class MaxProfit {

    private static int maxProfitStock(int [] prices){
        if(prices.length==0 || prices.length==1)
            return 0;

        int min=Math.min(prices[0],prices[1]);
        int max=Math.max(0,prices[1]-prices[0]);
        int i=2;
        while(i<prices.length){
            max=Math.max(max,prices[i]-min);
            min=Math.min(min,prices[i]);
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int [] prices={100,200};
        System.out.println("Max Profit could be: "+maxProfitStock(prices));

    }
}
