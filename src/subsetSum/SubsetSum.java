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

    public static void main(String ar[]){

        int arr[]={1,2,5}; //Given array
        int sum=5;  //Given Subset Sum
        System.out.println(isSubSetSumRecursiveBackTracking(arr,sum,arr.length));
    }
}
