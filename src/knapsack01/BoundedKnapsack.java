package knapsack01;

public class BoundedKnapsack {

//Goal:: To find the maximum profit
    public static int recursiveKnapSack(int w[],int val[],int n, int W){
        if(n==0||W==0)
            return 0;
        if(w[n-1]<W){// When the weight of the item is lower than the Capacity
            return Math.max(val[n-1]+recursiveKnapSack(w,val,n-1,W-w[n-1]), //When Included
                    recursiveKnapSack(w,val,n-1,W)); //Not included
        }
        else
            return recursiveKnapSack(w,val,n-1,W);//Not included
    }
    public static void main(String ar[]){

        int w[]={1,3,4,5}; // Weight Array
        int val[]={1,4,5,7}; // Value Array
        int W=7; // Max Capacity
        System.out.println(recursiveKnapSack(w,val,w.length,W));
    }
}
