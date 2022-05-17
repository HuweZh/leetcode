package com.huhusw.offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/ef231526f822489d879949226b4bed65
 * 对称飞行器，遍历迷宫
 * 如果没有飞行器的限制，这个题目就是广度优先搜索找最短通路
 * 因为有了飞行器的限制，所以需要在遍历的时候加上飞行器的状态
 * 即三层遍历
 * <p>
 * 深度优先搜索
 * 这里有一个小点：就是如果两次飞行器到了同一个节点，那么对于第一个飞行器来说一定能重复第二个飞行器之后的所有路径
 * 但是反过来就不一样了，所以飞行器次数多的节点是相对于飞行器次数少的节点的优解
 * 所以，我们只需要判断第一次到达节点的状态就行，不管飞行器次数为多少，都代表这个节点被访问过，再有飞行器或者走路来到这个节点可以直接跳过
 */
public class ALI202104 {
    //定义节点
    static class Node {
        int x;  //横纵坐标
        int y;
        int t;  //飞行器的剩余次数
        int s;  //当前节点对应的步数

        //构造函数
        Node(int x, int y, int t, int s) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.s = s;
        }

        Node() {

        }
    }

    //记录是否被访问过
    static boolean[][] visited;
    //上下左右四个方向
    static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    //矩阵的长宽
    static int n;
    static int m;
    //矩阵
    static String[] matrix;

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        visited = new boolean[n][m];
        matrix = new String[n];
        int index = 0;
        while (index < n) {
            matrix[index] = sc.nextLine();
            index++;
        }
        //遍历矩阵，找到开始的位置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i].charAt(j) == 'S') {
                    visited[i][j] = true;
                    //构造第一个节点，还能使用5次飞行器，步数从0开始
                    Node node = new Node(i, j, 5, 0);
                    //广度优先遍历
                    System.out.println(bfs(node));
                }
            }
        }
    }

    /**
     * 广度优先遍历
     *
     * @param node
     * @return
     */
    static public int bfs(Node node) {
        //队列
        Queue<Node> queue = new LinkedList<>();
        //初始化
        queue.offer(node);
        //广度优先遍历
        while (!queue.isEmpty()) {
            //弹出第一个节点
            Node nn = queue.poll();
            int x = nn.x;
            int y = nn.y;
            //到达终点，返回当前的步数
            if (matrix[x].charAt(y) == 'E') {
                return nn.s;
            }
            //四个方向+一个飞行器的方向，一共5个方向
            for (int i = 0; i < 5; i++) {
                //构造一个节点
                Node temp = new Node();
                //飞行器方向
                if (i == 4) {
                    //还有飞行器次数的话，才能往这个方向前进
                    if (nn.t > 0) {
                        temp = new Node(n - 1 - x, m - 1 - y, nn.t - 1, nn.s + 1);
                    }
                } else {
                    //改变四个方向
                    temp = new Node(x + dir[i][0], y + dir[i][1], nn.t, nn.s + 1);
                }
                //检查该节点是否符合可遍历的条件
                if (check(temp)) {
                    visited[temp.x][temp.y] = true;
                    queue.offer(temp);
                }
            }
        }
        return -1;
    }

    /**
     * 检查节点是否合法
     *
     * @param node
     * @return
     */
    static boolean check(Node node) {
        //越界检查，障碍检查，未访问过检查
        //这个未访问过检查直接就排除了两次飞行器同时访问同一个节点的情况
        return node.x >= 0 && node.x < n && node.y >= 0 && node.y < m
                && matrix[node.x].charAt(node.y) != '#' && !visited[node.x][node.y];
    }
}
