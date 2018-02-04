package com.sean.zq.android.utils;

/**
 * Created by Sean on 2017/12/26.
 *
 * 常用算法的工具类
 */

public class AlgoUtil {

    /**
     * 1.二分查找
     * */
    public static int binarySearch(int key, int[]a){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(key < a[mid]) hi = mid -1;
            else  if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }


    /**
     * 2.找出数组中最大元素
     * */
    public static double findMax(double[] a){
        double max = a[0];
        for(int x = 0; x <a.length ;x++){
            if(max < a[x]){
                max = a[x];
            }
        }
        return max;
    }

    /**
     * 3.计算数组中平均值
     * */
    public static int getAverage(int[] a){
        int sum = a[0];
        for(int x = 0; x <a.length ;x++){
            sum +=a[x];
        }
        return sum/a.length;
    }

    /**
     * 4.复制数组
     * */
    public static void copyArray(int[] a){
        int n = a.length;
        int[] b = new int[n];
        for(int i = 0;i < n; i++){
            b[i] = a[i];
        }
    }

    /**
     * 5.颠倒数组元素顺序
     * */
    public static void reverseArray(int[] a){
        int n = a.length;
        for(int i = 0; i < n; i++){
            int temp = a[i];
            a[i] = a[n-1-i];
            a[n-1-i] = temp;
        }
    }

    /**
     * 6.矩阵相乘（方阵）
     * */
    public static void phalanxArray(int[][] a, int[][] b){
        int n = a.length;
        int[][] c = new int[n][n];
        for(int i = 0;i < n; i++){
            for(int j = 0; j < n; j++){
                //计算行i和列j的点乘
                for(int k = 0; k < n; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
    }

    /**
     * 7.计算一个整数的绝对值
     * */
    public static int abs(int a){
        if(a > 0)return a;
        else  return -a;
    }

    /**
     * 8.计算一个浮点数的绝对值
     * */
    public static double abs(double a){
        if(a > 0.0)return a;
        else  return -a;
    }

    /**
     * 9.判断一个数是否为素数
     * */
    public static boolean isPrime(int a){
        if(a < 2) return false;
        for(int i = 2; i*i <= a; i++){
            if(a % i == 0)return false;
        }
        return true;
    }

    /**
     * 10.计算平方根(牛顿迭代法)
     * todo 有疑问
     * */
    public static double sprt(double a){
        if(a < 0) return Double.NaN;
        double err = 1 - 15;
        double t = a;
        while (Math.abs(t - a/t) > err * t){
            t = (a/t + t)/2.0;
        }
        return t;

    }

    /**
     * 11.计算直角三角形的斜边
     * */
    public static double hypotenuse(double a, double b){
        return Math.sqrt(a * a + b * b);
    }

    /**
     * 12.计算调和级数
     * */
    public static double h(int a){
       double sum = 0.0;
       for(int i = 1; i <= a; i++){
           sum += 1.0/i;
       }
       return sum;
    }


}
