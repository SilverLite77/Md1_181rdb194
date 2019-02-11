package dip107;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Md1_181rdb194 {

    public static void firstMethod(int[] arr) {
        int length = arr.length;
        int[] less = new int[length];
        int[] equal = new int[length];
        int[] res = new int[length];
        int k;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[i] == arr[j]) {
                    equal[i]++;
                } else if (arr[i] > arr[j]) {
                    less[i]++;
                }
            }

        }
        for (int i = 0; i < length; i++) {
            k = less[i];
            for (int j = 0; j < equal[i]; j++) {
                res[k + j] = arr[i];
            }
        }

        result(res);
    }

    public static void secondMethod(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        result(arr);
    }


    public static void quickSort(int[] arr, int l, int r) {
        if (arr.length == 0) {
            return;
        }
        if (l >= r) {
            return;
        }
        int m = arr[l + (r - l) / 2];
        int i = l;
        int j = r;

        while (i <= j) {
            while (arr[i] < m) {
                i++;
            }
            while (arr[j] > m) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (l < j) quickSort(arr, l, j);
        if (r > i) quickSort(arr, i, r);
    }

    public static void result(int[] arr) {
        System.out.println("result:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int method, count, element;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ņikita Kikiņovs 12 181RDB194");
        System.out.print("method: ");
        if (sc.hasNextInt()) {
            method = sc.nextInt();
            if (method < 1 || method > 2) {
                System.out.println("input-output error");
                sc.close();
                return;
            }
        } else {
            System.out.println("input-output error");
            sc.close();
            return;
        }

        System.out.print("count: ");
        if (sc.hasNextInt()) {
            count = sc.nextInt();
            if (count < 1) {
                System.out.println("input-output error");
                sc.close();
                return;
            }
        } else {
            System.out.println("input-output error");
            sc.close();
            return;
        }

        int[] arr = new int[count];
        System.out.println("items:");
        for (int i = 0; i < count; i++) {
            if (sc.hasNextInt()) {
                element = sc.nextInt();
                if (element < 0) {
                    System.out.println("input-output error");
                    sc.close();
                    return;
                }
            } else {
                System.out.println("input-output error");
                sc.close();
                return;
            }
            arr[i] = element;
        }
        sc.close();

        if (method == 1) firstMethod(arr);
        else secondMethod(arr);

    }
}