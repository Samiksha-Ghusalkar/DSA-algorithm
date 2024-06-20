
import java.util.*;

public class L001 {
    // permutation

    public static int FindPaths(int[] arr, String ans, int target) {

        if (target == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int ele : arr) {

            if (target - ele >= 0) {

                count += FindPaths(arr, ans + ele + "", target - ele);

            }

        }
        return count;

    }

    public static int permutation(int[] arr, String ans, int target, boolean[] vis) {
        int count = 0;
        if (target == 0) {
            System.out.println(ans);
            return 1;

        }

        for (int i = 0; i < arr.length; i++) {

            if (target - arr[i] >= 0 && vis[i] != true) {
                vis[i] = true;

                count += permutation(arr, ans + arr[i] + "", target - arr[i], vis);
                vis[i] = false;

            }

        }
        return count;

    }
    // single coin

    public static int CombinationOfCoins(int arr[], int index, int target, String ans) {
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = index; i < arr.length; i++) {
            if (target - arr[i] >= 0) {
                count += CombinationOfCoins(arr, i + 1, target - arr[i], ans + arr[i] + "");
            }
        }
        return count;

    }

    // permutation for infinite coins using subsequence logic
    public static int PermutationInfiniteCoins(int[] arr, int indx, int target, String ans) {
        int count = 0;
        if (target == 0 || arr.length == indx) {
            if (target == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;

        }
        if (target - arr[indx] >= 0) {
            count += PermutationInfiniteCoins(arr, 0, target - arr[indx], ans + arr[indx]);
            count += PermutationInfiniteCoins(arr, indx + 1, target, ans);

        }

        return count;

    }

    public static int PermutationfiniteCoins(int[] arr, int indx, int target, String ans) {
        int count = 0;
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }
        if (indx == arr.length) {
            return 0;
        }

        for (int i = indx; i < arr.length; i++) {
            if (target - arr[i] >= 0 && arr[i] != -1) {
                int temp = arr[i];
                arr[i] = -1;
                count += PermutationfiniteCoins(arr, 0, target - temp, ans + temp + "");
                arr[i] = temp;
            }
        }
        count += PermutationfiniteCoins(arr, indx + 1, target, ans);

        return count;
    }

    // permutation for finite coins using subsequence logic

    // combination for infinite coins using subsequence logic
    public static int CombinationOfCoinSubSequence(int[] arr, int indx, int target, String ans) {
        int count = 0;
        if (target == 0 || arr.length == indx) {
            if (target == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;

        }
        if (target - arr[indx] >= 0) {
            count += CombinationOfCoinSubSequence(arr, indx, target - arr[indx], ans + "" + arr[indx]);
            count += CombinationOfCoinSubSequence(arr, indx + 1, target, ans);
        }
        return count;

    }

    // combination for finite coins using subsequence logic

    public static int CombinationOfCoinsSubsequence(int[] arr, int indx, int target, String ans) {
        int count = 0;
        if (target == 0 || arr.length == indx) {
            if (target == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;

        }
        if (target - arr[indx] >= 0) {
            count += CombinationOfCoinSubSequence(arr, indx + 1, target - arr[indx], ans + "" + arr[indx]);
            count += CombinationOfCoinSubSequence(arr, indx + 1, target, ans);
        }
        return count;

    }

    

    public static int FindSubsetOfCoins(int[] arr, int index, int sum1, int sum2, String ans1, String ans2)
             {
        if (index == arr.length) {
            if (sum1 == sum2 ) {
                System.out.println("Subset1 " + ans1 + "subset2" + ans2);
              
                return 1;

            }

            return 0;
        }

        int count = 0;

        count += FindSubsetOfCoins(arr, index + 1, sum1 + arr[index], sum2, ans1 + " " + arr[index], ans2);
        count += FindSubsetOfCoins(arr, index + 1, sum1, sum2 + arr[index], ans1, ans2 + " " + arr[index]);
        return count;
    }

    public static void solve() {
        int arr[] = { 10, 20, 30, 40, 50, 60, 70 };
        // boolean vis[] = new boolean[arr.length];

        // int result = FindPaths(arr, "", 10,vis);
        // int result = CombinationOfCoins(arr, 0, 10, "");
        /*
         * int result = permutation(arr, "", 10, vis);
         * System.out.println("total count");
         * System.out.println(result);
         */
        // int result = CombinationOfCoinSubSequence(arr, 0, 10, "");
        // int ans = CombinationOfCoinsSubsequence(arr, 0, 10, "");
        // int ans= PermutationInfiniteCoins(arr, 0,10 , "");
        // int ans = PermutationfiniteCoins(arr, 0, 10, "");
        
        arr[0]=10;
     
        int ans = FindSubsetOfCoins(arr, 1, 0+arr[0], 0, ""+arr[0], "");

        System.out.println("total count");
        System.out.println(ans);

    }

    public static void main(String args[]) {
        solve();

    }

}
