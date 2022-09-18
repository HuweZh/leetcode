package com.huhusw.TYY;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> arr2 = new ArrayList<>();
        String[] nums = sc.nextLine().split(",");
        sc.close();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        int left = -1;
        int index = 0;
        while (index < n) {
            if (arr[index] % 2 == 0) {
                int p = arr[index];
                for (int j = index - 1; j > left; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[++left] = p;
            }
            index++;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i != n - 1) {
                System.out.print(",");
            }
        }
    }
}
/*
80

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
//         ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        String[] nums = sc.nextLine().split(",");
        sc.close();
        int num;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(nums[i]);
            if (num % 2 == 0) {
//                 arr1.add(num);
                System.out.print(num + ",");
            } else {
                arr2.add(num);
            }
        }

//         for (int i = 0; i < arr1.size(); i++) {
//             System.out.print(arr1.get(i) + ",");
//         }
        for (int i = 0; i < arr2.size(); i++) {
            System.out.print(arr2.get(i));
            if (i != arr2.size() - 1) {
                System.out.print(",");
            }
        }
    }
}

 */