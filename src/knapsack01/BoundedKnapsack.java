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

    //modifying recursive to Memoized
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
    public static void main(String ar[]){

        int w[]={1,3,4,5}; // Weight Array
        int val[]={1,4,5,7}; // Value Array
        int W=7; // Max Capacity
        System.out.println(recursiveKnapSack(w,val,w.length,W));
        System.out.println("---------------------------------------------");
        System.out.println(memoizedKnapSackCaller(w,val,W));
    }
}
