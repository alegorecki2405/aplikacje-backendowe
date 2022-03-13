package com.company;

public class Main {


    public static void main(String []args){
        System.out.println("Hello World");
        int[] array = { 4, 5, 7, 11, 12, 15, 15, 21, 40, 45 };
        System.out.println(searchIndex(array,11));
    }

    public static int searchIndex(int[] array, int value)    {
        int index = 0;
        int limit = array.length;
        while (index <= limit) {
            int point = (int)Math.ceil((index + limit)/2.0);
            int entry = array[point];
            if (value > entry) {
                index = point + 1;
                continue;
            }
            if (value < entry) {
                limit = point - 1;
                continue;
            }
            return point;
        }
        return -1;
    }
}
