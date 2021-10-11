package com.huhusw.middle;

public class M165 {
    public static void main(String[] args) {
        M165 m165 = new M165();
        m165.compareVersion("1.1", "1.0.0.0.1");
    }

    public int compareVersion(String version1, String version2) {
        String strings1 = removeZero(version1);
        String strings2 = removeZero(version2);
        int n = Math.min(strings1.length(), strings2.length());
        for (int i = 0; i < n; i++) {
            if (strings1.charAt(i) > strings2.charAt(i)) {
                return 1;
            } else if (strings1.charAt(i) < strings2.charAt(i)) {
                return -1;
            }
        }
        if (strings1.length() == strings2.length()) return 0;
        else
            return strings1.length() > strings2.length() ? 1 : -1;
    }

    private String removeZero(String version) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < version.length(); i++) {
            if (version.charAt(i) != '0' && version.charAt(i) != '.') {
                stringBuilder.append(version.charAt(i));
            }
        }
        return new String(stringBuilder);
    }

}
