package com.algorithm.sorter;

import org.junit.Test;


/**
 * 冒泡排序(三种方式，优化效果很佳)
 * 时间复杂度
 */
public class BubbleSorter {
    private int[] arr = new int[]{1, 1, 2, 0, 9, 3, 12, 7, 8, 3, 4, 65, 22};

    @Test
    public void test() {
        int[] ints = method(arr);
        forSystem(ints);
    }

    @Test
    public void test2() {
        int[] ints = method2(arr);
        forSystem(ints);
    }

    @Test
    public void test3() {
        int[] ints = method3(arr);
        forSystem(ints);
    }


    private void forSystem(int[] arr) {
        for (int aMethod : arr) {
            if (aMethod == arr[arr.length - 1]) {
                System.out.println(aMethod);
            } else {
                System.out.print(aMethod + ",");
            }
        }
    }


    private int[] method(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    private int[] method2(int[] arr) {
        boolean flag = true;
        int j;
        int l = arr.length;
        while (flag) {
            // 每次排序前，都设置为未排序过
            flag = false;
            for (j = 0; j < l - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // 表示交换过了
                    flag = true;
                }
            }
            l--;
        }
        return arr;
    }


    private int[] method3(int[] arr) {
        int l;
        int i;
        int f = arr.length;// 用来记录最后交换的位置，也就是排序的边界
        while (f > 0) {// 排序未结束标志
            l = f;// l 用来记录遍历的边界
            f = 0;
            for (i = 1; i < l; i++) { // 前面的数大于后面的就交换
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    f = i;// 记录交换的尾部边界
                }
            }
        }
        return arr;
    }
}
