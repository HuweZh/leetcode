package com.huhusw.QN;

import java.util.*;

public class Z03 {
    public static void main(String[] args) {
        String s = "SA SK SQ SJ S10 H10 C9";
        Z03 z03 = new Z03();
        System.out.println(z03.showDown(s));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 翻牌
     *
     * @param inHand string字符串 一组以单空格间隔的手牌(例如：SA HK H9 D8 C5 S5 H4)
     * @return string字符串
     */
    public String showDown(String inHand) {
        // write code here
        if (inHand.split(" ").length < 5) {
            return null;
        }
        //0-12 黑桃  12-25 红桃 26-38 草花  39-51方片
        int[] poke = dealData(inHand);
        String res = null;
        //皇家同花顺
        res = case1(poke);
        if (res != null) {
            return res;
        }
        //同花顺
        res = case2(poke);
        if (res != null) {
            return res;
        }
        //四条
        res = case3(poke);
        if (res != null) {
            return res;
        }
        //葫芦
        res = case4(poke);
        if (res != null) {
            return res;
        }
        //同花
        res = case5(poke);
        if (res != null) {
            return res;
        }
        //顺子
        res = case6(poke);
        if (res != null) {
            return res;
        }
        //三条
        res = case7(poke);
        if (res != null) {
            return res;
        }
        //两对
        res = case8(poke);
        if (res != null) {
            return res;
        }
        //一对
        res = case9(poke);
        if (res != null) {
            return res;
        }
        return "GaoPai";
    }

    private String case9(int[] poke) {
        int[] stem = new int[13];
        for (int i = 0; i < 52; i++) {
            stem[i % 13] += poke[i];
        }
        int count = 0;
        for (int i = 0; i < 13; i++) {
            if (stem[i] == 2) {
                count++;
            }
        }
        return count == 1 ? "YiDui" : null;
    }

    private String case8(int[] poke) {
        int[] stem = new int[13];
        for (int i = 0; i < 52; i++) {
            stem[i % 13] += poke[i];
        }
        int count = 0;
        for (int i = 0; i < 13; i++) {
            if (stem[i] == 2) {
                count++;
            }
        }
        return count >= 2 ? "LiangDui" : null;
    }

    private String case7(int[] poke) {
        int[] stem = new int[13];
        for (int i = 0; i < 52; i++) {
            stem[i % 13] += poke[i];
        }
        for (int i = 0; i < 13; i++) {
            if (stem[i] == 3) {
                return "SanTiao";
            }
        }
        return null;
    }

    private String case6(int[] poke) {
        int[] stem = new int[13];
        for (int i = 0; i < 52; i++) {
            stem[i % 13] += poke[i];
        }
        for (int i = 0; i < 8; i++) {
            if (stem[i] != 0 && stem[i + 1] != 0 && stem[i + 2] != 0 && stem[i + 3] != 0 && stem[i + 4] != 0) {
                return "ShunZi";
            }
        }
        if (stem[0] != 0 && stem[9] != 0 && stem[10] != 0 && stem[11] != 0 && stem[12] != 0) {
            return "ShunZi";
        }
        return null;
    }

    private String case5(int[] poke) {
        for (int i = 0; i < 4; i++) {
            int count = 0;
            int diff = i * 13;
            for (int j = 0; j < 13; j++) {
                count += poke[j + diff];
            }
            if (count >= 5) {
                return "TongHua";
            }
        }
        return null;
    }

    private String case4(int[] poke) {
        int[] stem = new int[13];
        for (int i = 0; i < 52; i++) {
            stem[i % 13] += poke[i];
        }
        boolean san = false;
        boolean er = false;
        for (int i = 0; i < 13; i++) {
            if (stem[i] == 3) {
                san = true;
            }
            if (stem[i] == 2) {
                er = true;
            }
        }
        return san && er ? "HuLu" : null;
    }

    private String case3(int[] poke) {
        int[] stem = new int[13];
        for (int i = 0; i < 52; i++) {
            stem[i % 13] += poke[i];
        }
        for (int i = 0; i < 13; i++) {
            if (stem[i] == 4) {
                return "SiTiao";
            }
        }
        return null;
    }

    private String case2(int[] poke) {
        for (int i = 0; i < 4; i++) {
            int diff = i * 13;
            for (int j = diff; j < 13 + diff - 5; j++) {
                if (poke[j] != 0 && poke[j + 1] != 0 && poke[j + 2] != 0 && poke[j + 3] != 0 && poke[j + 4] != 0) {
                    return "TongHuaShun";
                }
            }
        }
        return null;
    }

    private String case1(int[] poke) {
        for (int i = 0; i < 4; i++) {
            int diff = i * 13;
            if (poke[0 + diff] != 0 && poke[9 + diff] != 0 && poke[10 + diff] != 0 && poke[11 + diff] != 0 && poke[12 + diff] != 0) {
                return "HuangJiaTongHuaShun";
            }
        }
        return null;
    }

    private int[] dealData(String data) {
        int[] poke = new int[52];
        String[] strings = data.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].charAt(0) == 'S') {
                //黑桃
                switch (strings[i].charAt(1)) {
                    case 'A':
                        poke[0]++;
                        break;
                    case 'J':
                        poke[10]++;
                        break;
                    case 'Q':
                        poke[11]++;
                        break;
                    case 'K':
                        poke[12]++;
                        break;
                    case '1':
                        poke[9]++;
                        break;
                    default:
                        poke[strings[i].charAt(1) - '1']++;
                        break;
                }
            } else if (strings[i].charAt(0) == 'H') {
                //红桃
                int diff = 13;
                switch (strings[i].charAt(1)) {
                    case 'A':
                        poke[0 + diff]++;
                        break;
                    case 'J':
                        poke[10 + diff]++;
                        break;
                    case 'Q':
                        poke[11 + diff]++;
                        break;
                    case 'K':
                        poke[12 + diff]++;
                        break;
                    case '1':
                        poke[9 + diff]++;
                        break;
                    default:
                        poke[strings[i].charAt(1) - '1' + diff]++;
                        break;
                }
            } else if (strings[i].charAt(0) == 'C') {
                //草花
                int diff = 26;
                switch (strings[i].charAt(1)) {
                    case 'A':
                        poke[0 + diff]++;
                        break;
                    case 'J':
                        poke[10 + diff]++;
                        break;
                    case 'Q':
                        poke[11 + diff]++;
                        break;
                    case 'K':
                        poke[12 + diff]++;
                        break;
                    case '1':
                        poke[9 + diff]++;
                        break;
                    default:
                        poke[strings[i].charAt(1) - '1' + diff]++;
                        break;
                }
            } else {
                //方片
                int diff = 39;
                switch (strings[i].charAt(1)) {
                    case 'A':
                        poke[0 + diff]++;
                        break;
                    case 'J':
                        poke[10 + diff]++;
                        break;
                    case 'Q':
                        poke[11 + diff]++;
                        break;
                    case 'K':
                        poke[12 + diff]++;
                        break;
                    case '1':
                        poke[9 + diff]++;
                        break;
                    default:
                        poke[strings[i].charAt(1) - '1' + diff]++;
                        break;
                }
            }
        }
        return poke;
    }
}
