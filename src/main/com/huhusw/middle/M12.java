package com.huhusw.middle;

/**
 * @author huhusw
 * @Description
 * @create 2021-05-14 10:32
 */
public class M12 {
    char[] word = new char[]{'I', 'V', 'X', 'L', 'C', 'D'};
    //个位 0到9
    String[] bitNum = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    //十位 0到9
    String[] tenNum = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    //百位 0到9
    String[] hundredNum = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    //千位 0到9
    String[] thousandNum = new String[]{"", "M", "MM", "MMM"};

    public static void main(String[] args) {
        M12 m12 = new M12();
        String s = m12.intToRoman(58);
        System.out.println(s);
    }

    public String intToRoman(int num) {
        int bitRemainder = num % 10;
        num = num / 10;
        int tenRemainder = num % 10;
        num = num / 10;
        int hundredRemainder = num % 10;
        num = num / 10;
        int thousandRemainder = num;
        return thousandNum[thousandRemainder] + hundredNum[hundredRemainder] + tenNum[tenRemainder] + bitNum[bitRemainder];
    }
}
