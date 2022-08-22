package com.huhusw;

import java.util.*;

public class shudu {
    public static void main(String[] args) {
        p3();
    }

    static public ListNode solve(ListNode[] a) {
        Queue<Integer> queue = new LinkedList<>();
        for (ListNode listNode : a) {
            while (listNode != null) {
                if (!queue.contains(listNode.val)) {
                    queue.offer(listNode.val);
                    listNode = listNode.next;
                } else {
                    break;
                }
            }
        }
        ListNode head = new ListNode(queue.poll());
        ListNode p = head;
        while (!queue.isEmpty()) {
            p.next = new ListNode(queue.poll());
            p = p.next;
        }
        p.next = head;
        return head;
    }

    static public ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode pN = newHead;
        while (p1 != null && p2 != null) {
            pN.next = p1;
            p1 = p1.next;
            if (p1.val == p2.val) {
                p2 = p2.next;
            }
            pN = pN.next;
        }
        if (p1 == null) {
            pN.next = p2;
        }
        if (p2 == null) {
            pN.next = p1;
        }
        return newHead.next;
    }

    static public int getNumber(int[] a) {
        int count = 0;
        while (count < a.length - 1) {
            int index = -1;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 0) {
                    continue;
                }
                index++;
                //质数
                if (isOdd(index + 1)) {
                    continue;
                }
                a[i] = 0;
                count++;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                return a[i];
            }
        }
        return 0;
    }

    static public boolean isOdd(int a) {
        if (a == 1) {
            return false;
        }
        for (int i = 2; i <= a >> 1; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }


    public void p1() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] strings = new String[n];
        int index = 0;
        int maxLength = -1;
        while (index < n) {
            strings[index] = scanner.nextLine();
            maxLength = Math.max(maxLength, strings[index].length());
            index++;
        }
        //补0
        for (int i = 0; i < n; i++) {
            if (strings[i].length() < maxLength) {
                for (int j = strings.length; j < maxLength; j++) {
                    strings[i] += "0";
                }
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(maxLength);
        //竖读
        for (int i = 0; i < maxLength; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum = sum * 10 + (int) (strings[j].charAt(i) - '0');
            }
            queue.offer(sum);
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    /**
     * 90%
     */
    static public void p3() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            long[] attack = new long[n];
            long[] defend = new long[n];
            long res = Long.MAX_VALUE;
            int attIndex = 0;
            int defIndex = n-1;
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == '0') {
                    attIndex = i;
                    break;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (str.charAt(i) == '1') {
                    defIndex = i;
                    break;
                }
            }
            attack[attIndex] = attIndex + 1;
            defend[defIndex] = defIndex + 1;
            for (int i = attIndex + 1; i < n; i++) {
                if (str.charAt(i) == '0') {
                    attack[i] = attack[i - 1] + i + 1;
                } else {
                    attack[i] = attack[i - 1];
                }
            }
            for (int i = defIndex - 1; i >= 0; i--) {
                if (str.charAt(i) == '0') {
                    defend[i] = defend[i + 1];
                } else {
                    defend[i] = defend[i + 1] + i + 1;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                res = Math.min(res, Math.abs(attack[i] - defend[i + 1]));
            }
//        res = Math.min(res, attack[n - 1]);
//        res = Math.min(res, defend[0]);
            System.out.println(res);
        }
    }
}
