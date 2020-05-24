package com.xp.solutions._4_Median_of_Two_Sorted_Arrays;

/**
 * Description:
 * User: yukong
 * Date: 2018-01-15
 * Time: 17:06
 */
public class Solution {






    public double findKth(int a[], int startA, int m, int b[], int startB, int n, int k) {
        // 保证小的在前
        if (m > n) {
            return findKth(b, startB, n, a, startA, m, k);
        }

        // 如果小的数组(数组a)已经全部过滤了 那么直接拿大数组(数组b)的第k大的数 由于数组是有序的 所以可以直接通过下标获取
        if (m == 0) {
            return b[startB + k - 1];
        }

        if (k == 1) {
            return min(a[startA], b[startB]);
        }

        int pa = min(k/2, m), pb = k - pa;

        // 如果a数组的前(k/2)小于b[k/2] 那么a数组的前k/2可以过滤掉
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


    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        // 获取两个数据
        int m = nums1.length;
        int n = nums2.length;
        // 保证短数组在前
        if(m > n) {
            return findMedianSortedArrays1(nums2, nums1);
        }
        int left = 0, right = m;
        double res = 0.0d;
        while(left <= right) {
            // 短数组的下标i
            int i = left + ((right - left) >> 1);
            // 长数组的下标等于(m + n) / 2 - i 由于数组长度和存在奇偶 在偶数的时候(m+n)/2 == (m+n+1)/2 所以
            int j = ((m + n + 1) >> 1) - i;
            // 长数组的左边最大大于短数组的右边最小 所以 短数组的下标要前进 长数组的下标要后退
            if(j != 0 && i != m && nums2[j - 1] > nums1[i]) {
                left = i + 1;
                // 短数组的左边最大大于长数组的右边最小 所以 长数组的下标要前进 短数组的下标要后退
            } else if (i != 0 && j != n && nums1[i-1] > nums2[j]) {
                right = i - 1;
                // 边界情况
            } else {
                // 左边最大
                if(i == 0) {
                    res = nums2[j-1];
                } else if(j == 0) {
                    res = nums1[i - 1];
                } else {
                    res = Math.max(nums1[i - 1] , nums2[j -1]);
                }
                if(((n + m) & 1) == 1) {
                    return res;
                }
                // 右边最小
                if(i == m) {
                    res += nums2[j];
                } else if(j == n) {
                    res += nums1[i];
                } else {
                    res += Math.min(nums1[i] , nums2[j]);
                }
                return res/2.0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println( new Solution().findMedianSortedArrays1(new int[]{1,3}, new int[]{2}));
    }

}
