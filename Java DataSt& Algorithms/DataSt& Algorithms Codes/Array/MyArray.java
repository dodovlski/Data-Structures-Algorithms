package Array;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyArray {
    public static void main(String[] args) {
        int[] numbers = {2, 11, 5, 10, 7, 8};
        PrintArray(numbers);
        ReverseArray(numbers, 0, numbers.length - 1);
        PrintArray(numbers);
        System.out.println(FindMinimum(numbers));
    }

    public static void PrintArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] RemoveEven(int[] arr) {
        int oddCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCounter++;
            }
        }
        int[] resultArr = new int[oddCounter];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                resultArr[idx] = arr[i];
                idx++;
            }
        }
        return resultArr;

    }

    public static void ReverseArray(int myArr[], int start, int end) {
        while (start < end) {
            int temp = myArr[start];
            myArr[start] = myArr[end];
            myArr[end] = temp;
            start++;
            end--;
        }
    }


    public static int FindMinimum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }


    public static int FindSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public static void MoveZeroToEnd(int[] arr) {

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0) {
                j++;
            }
        }
    }

    public static void ResizeArray(int[] arr, int newCapacity) {
        int[] temp = new int[newCapacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    // Finding the Missing Number in the Array (range 1 to a )
    public static int FindMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for (int num : arr) {
            sum = sum - num;
        }
        return sum;
    }



}