package com.huhusw;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import javax.swing.plaf.multi.MultiTableHeaderUI;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static char x;
    public static AtomicInteger finish = new AtomicInteger(0);
    public static AtomicInteger process = new AtomicInteger(0);
    static public int count = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] xS = scanner.nextLine().split(" ");
        String[] yS = scanner.nextLine().split(" ");
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(xS[i]);
            y[i] = Integer.parseInt(yS[i]);
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]), res);
            }
        }
        System.out.println(res);
    }

    Map<Integer, TreeNode> cacheTree = new HashMap<>();
    Map<Integer, Integer> cacheWeight = new HashMap<>();

    public TreeNode norTree(TreeNode root, ArrayList<ArrayList<Integer>> op) {
        //遍历树，保存到map中
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                cacheTree.put(node.val, node);
                cacheWeight.put(node.val, 0);
            }
        }
        //遍历所有的操作
        for (ArrayList<Integer> a : op) {
            //取出id和操作数
            int id = a.get(0);
            int num = a.get(1);
            TreeNode node = cacheTree.get(id);
            nor(node, num);
        }
//        TreeNode node = buildTree(root);
        return buildTree(root);
    }

    //构建权重树
    private TreeNode buildTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(cacheWeight.get(root.val));
        node.left = buildTree(root.left);
        node.right = buildTree(root.right);
        return node;
    }

    //亦或
    public void nor(TreeNode node, int num) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                int weight = cacheWeight.get(treeNode.val);
                weight = weight ^ num;
                cacheWeight.put(treeNode.val, weight);
            }
        }
    }


    public static void cal() {
        //输入数据
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] splits = str.split(" ");
        int[] nums = new int[splits.length];
        int index = 0;
        for (String s : splits) {
            nums[index] = Integer.parseInt(s);
            index++;
        }
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
        //结果
        int res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            //往左扩散
            int curIndex = i;
            int left = i;
            while ((left - 1) >= 0) {
                if (nums[left - 1] > nums[curIndex]) {
                    left--;
                    curIndex--;
                } else {
                    break;
                }
            }
            //往右扩散
            curIndex = i;
            int right = i;
            while (right < nums.length) {
                if (nums[right + 1] > nums[curIndex]) {
                    right++;
                    curIndex++;
                } else {
                    break;
                }
            }
            //往左或者往右没有扩散，这种情况直接放弃
            if (left == i || right == i) {
                continue;
            }
            res = Math.max(right - left + 1, res);
        }
        System.out.println(res);
    }


    /**
     * 输出cba序列
     */
    public static void test2() {
        Provider provider = new Provider();
        Customer c1 = new Customer(1, 2);
        Customer c2 = new Customer(2, 3);
        Customer c3 = new Customer(3, 4);
        new Thread(provider).start();
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
    }

    static class Provider implements Runnable {
        int i = 0;

        @Override
        public void run() {
            while (true) {
                //自旋设置输入字符
                if (finish.compareAndSet(0, 1)) {
                    if (i == 0) {
                        x = 'a';
                    } else if (i == 1) {
                        x = 'b';
                    } else {
                        x = 'c';
                    }
                    i++;
                    i = i % 3;
                    //自旋设置信号，通知消费者进行消费
                    while (true) {
                        if (process.compareAndSet(0, 1)) {
                            break;
                        }
                    }
                }
            }
        }
    }

    static class Customer implements Runnable {
        //每个消费者对应的序号
        private int newValue;
        private int oldValue;

        Customer(int oldValue, int newValue) {
            this.newValue = newValue;
            this.oldValue = oldValue;
        }

        @Override
        public void run() {
            while (true) {
                //自旋设置正在访问
                if (process.get() == 0) {
                    System.out.println('a');
                    process.incrementAndGet();
                } else if (process.get() == 1) {
                    System.out.println('b');
                    process.incrementAndGet();
                } else {
                    System.out.println('c');
                    process.set(0);
                }
//                if (process.compareAndSet(oldValue, newValue)) {
//                    System.out.println(x);
//                    //恢复标志位
//                    while (true){
//                        if(process.compareAndSet(newValue, 0)){
//                            break;
//                        }
//                    }
//                    while (true){
//                        if(finish.compareAndSet(1, 0)){
//                            break;
//                        }
//                    }
//                }
            }
        }
    }

    /**
     * 三个线程输出cba序列
     */
    public static void test1() {
        new Thread(new OutSeq('a', 0)).start();
        new Thread(new OutSeq('b', 1)).start();
        new Thread(new OutSeq('c', 2)).start();
    }

    static class OutSeq implements Runnable {
        public int flag;
        char c;

        OutSeq(char c, int flag) {
            this.c = c;
            this.flag = flag;
        }

        @Override
        public void run() {
            synchronized (OutSeq.class) {
                while (count > 0) {
                    if (count % 3 == flag) {
                        OutSeq.class.notifyAll();
                        System.out.println(Thread.currentThread().getName() + " : " + c);
                        count--;
                    }
                    try {
                        OutSeq.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                OutSeq.class.notifyAll();
                System.out.println("结束了");
            }
        }
    }

    public void test() {
        ThreadLocal<String> localName = new ThreadLocal();
        localName.set("占小狼");
        String name = localName.get();

        int a = "asds".length();
    }
}

