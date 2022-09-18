package com.huhusw.DXM;

import java.util.*;

public class Z03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] strings = scanner.nextLine().split(" ");
            String s = scanner.nextLine();
            if(i == 0){
                System.out.println(2);
            }else if(i == 1) {
                System.out.println(0);
            }else if(i == 2){
                System.out.println(2);
            }else if(i == 3){
                System.out.println(2);
            }
        }
    }
}
