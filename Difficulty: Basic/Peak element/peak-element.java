//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int A = obj.peakElement(a);
            int n = a.length;
            if (A < 0 && A >= n)
                System.out.println("false");
            else {
                if (n == 1 && A == 0)
                    f = 1;
                else if (A == 0 && a[0] >= a[1])
                    f = 1;
                else if (A == n - 1 && a[n - 1] >= a[n - 2])
                    f = 1;
                else if (A >= 0 && A < n && a[A] >= a[A + 1] && a[A] >= a[A - 1])
                    f = 1;
                else
                    f = 0;
                if (f == 1) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    public int peakElement(int[] arr) {
        int n = arr.length;
         if(n==1)
            return 0;
        if(arr[0]>=arr[1])
            return 0;
        if(arr[n-1]>=arr[n-2])
            return n-1;
        
        int low = 1;
        int high = n-2;
        
        while(low <= high)
        {
            int mid = (low + high) / 2;
            
            if(arr[mid]>= arr[mid+1] && arr[mid]>=arr[mid-1])
                return mid;
            else if(arr[mid] > arr[mid-1])
                low = mid+1;
            else
                high = mid-1;
        }
        
        return -1;
    }
}