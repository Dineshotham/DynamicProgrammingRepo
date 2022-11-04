package knapsack01;

import java.util.Arrays;

public class BoundedKnapsack {
//Goal:: To find the maximum profit
    public static int recursiveKnapSack(int w[],int val[],int n, int W){
        if(n==0||W==0)
            return 0;
        if(w[n-1]<=W){// When the weight of the item is lower than the Capacity
            return Math.max(val[n-1]+recursiveKnapSack(w,val,n-1,W-w[n-1]), //When Included
                    recursiveKnapSack(w,val,n-1,W)); //Not included
        }
        else
            return recursiveKnapSack(w,val,n-1,W);//Not included
    }
//Recrusive Knapsack ends

    //Bottom Up Tabulation Approach
    public static int tabKnapsack(int w[],int val[],int W){
        int dp[][]= new int[w.length+1][W+1];

        for(int i=0;i<=w.length;i++){
            for(int j=0;j<=W;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(w[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=Math.max((val[i-1]+dp[i-1][j-w[i-1]]),
                            (dp[i-1][j]));
                }
            }
        }



        return dp[w.length][W];

    }


    //modifying recursive to Memoized Knapsack
    public static int memoizedKnapSackCaller(int w[],int val[],int W){
        int memTable[][]= new int[w.length+1][W+1];
        for( int[] row:memTable){
            Arrays.fill(row,-1);
        }
        return memoizedKnapSack(w,val,w.length,W,memTable);
    }
    public static int memoizedKnapSack(int w[],int val[],int n, int W, int memTable[][]){
        if(n==0||W==0)
            return 0;

        if(memTable[n][W]!=-1)
            return memTable[n][W];

        if(w[n-1]>W){
            return memTable[n][W]= memoizedKnapSack(w,val,n-1,W,memTable);
        }else
            return memTable[n][W]= Math.max(val[n-1]+memoizedKnapSack(w,val,n-1,W-w[n-1],memTable), //When Included
                memoizedKnapSack(w,val,n-1,W,memTable)); //Not included

    }
    //Memoized KnapSack Ends
    public static void main(String ar[]){

        int w[]={1,3,4,5}; // Weight Array
        int val[]={1,4,5,7}; // Value Array
        int W=7; // Max Capacity
        System.out.println(recursiveKnapSack(w,val,w.length,W));
        System.out.println("---------------------------------------------");
        System.out.println(memoizedKnapSackCaller(w,val,W));
        System.out.println("---------------------------------------------");
        System.out.println(tabKnapsack(w,val,W));
    }
}
