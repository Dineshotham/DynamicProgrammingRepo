package subsetSum;

public class SubsetSum {

    // Recursive Backtracking O(2^n) approach
    public static boolean isSubSetSumRecursiveBackTracking(int arr[],int subSetsum,int n){
        if(n==0)
        return false;
        if(arr[n-1]>subSetsum)
            return isSubSetSumRecursiveBackTracking(arr,subSetsum,n-1); //Exclusion Path
        else if(arr[n-1]==subSetsum)
            return true;
        else
            return isSubSetSumRecursiveBackTracking(arr,subSetsum-arr[n-1],n-1) || //Inclusion Path
                    isSubSetSumRecursiveBackTracking(arr,subSetsum,n-1); //exclusion Path
    }
    //Recursive code ends

    //Tabulation approach
    public static boolean isSubSetSumTabulation(int arr[],int subSetsum){
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][subSetsum+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=subSetsum;j++){
                if(i==0){
                    dp[i][j]=false;
                }
                else if(j==0){
                   dp[i][j]=true;
                }
                else if(arr[i-1]==j)
                    dp[i][j]=true;
                else if(arr[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=(dp[i-1][j]||dp[i-1][j-arr[i-1]]);
                }
            }
        }


        return dp[n][subSetsum];
    }

    public static void main(String ar[]){

        int arr[]={1,2,1,3}; //Given array
        int sum=5;  //Given Subset Sum
        System.out.println(isSubSetSumRecursiveBackTracking(arr,sum,arr.length));
        System.out.println(isSubSetSumTabulation(arr,sum));
    }
}
