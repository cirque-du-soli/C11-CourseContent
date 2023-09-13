package com.solifsd08.day04customhashmap;

public class Day04CustomHashMap {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        CustomHashMapStringString hmss = new CustomHashMapStringString();

        hmss.putValue("aaa", "111");
        hmss.putValue("bbb", "222");
        hmss.putValue("ccc", "333");
        hmss.putValue("ddd", "444");
        hmss.putValue("eee", "555");
        hmss.putValue("fff", "666");

        hmss.printDebug();

    }

}
