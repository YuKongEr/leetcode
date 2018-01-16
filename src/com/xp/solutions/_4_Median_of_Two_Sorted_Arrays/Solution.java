package com.xp.solutions._4_Median_of_Two_Sorted_Arrays;

/**
 * Description:
 * User: yukong
 * Date: 2018-01-15
 * Time: 17:06
 */
public class Solution {






    public double findKth(int a[], int startA, int m, int b[], int startB, int n, int k) {
        if (m > n) {
            return findKth(b, startB, n, a, startA, m, k);
        }

        if (m == 0) {
            return b[startB + k - 1];
        }

        if (k == 1) {
            return min(a[startA], b[startB]);
        }

        int pa = min(k/2, m), pb = k - pa;

        if (a[startA + pa-1] < b[startB + pb-1]) {
            return findKth(a, startA + pa, m - pa, b, startB, n, k - pa);
        } else {
            return findKth(a, startA, m, b, startB + pb, n - pb, k - pb);
        }
    }
    public void test() {

    }
    private int min(int a, int b){
        return a > b ? b : a;
    }
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        int total = m+n;

        if ((total&1) == 1) {
            return findKth(A, 0, m, B, 0, n, total / 2 + 1);
        } else {
            return (findKth(A, 0, m, B, 0, n, total / 2) + findKth(A, 0, m, B, 0, n, total / 2 + 1)) / 2;
        }
    }

   /* public  double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length = nums1.length + nums2.length;

        int middle ;
        int flag = 0;
        if ( length == 1) {
            middle = 1;
        } else {
            if (length%2 == 0) {
                middle = length/2 + 1;
                flag = 1;
            } else {
                middle = length/2 + 1;
            }
        }

        int[] array = new int[middle];
        int p=0,q=0;
        for (int i = 0; i < middle; i++) {
            if ( p < nums1.length && q < nums2.length) {
                if (nums1[p] < nums2[q]) {
                    array[i] = nums1[p];
                    p++;
                } else {
                    array[i] = nums2[q];
                    q++;
                }
            } else if (p < nums1.length) {
                array[i] = nums1[p];
                p++;
            } else if (q < nums2.length) {
                array[i] = nums2[q];
                q++;
            }
        }
        if (flag == 0){
            return array[middle-1];
        } else {
            return (array[middle-1] + array[middle-2]) / 2.0;
        }
    }*/

}
