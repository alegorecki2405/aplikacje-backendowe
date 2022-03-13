package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {


    public static void main(String []args) throws IOException {
        System.out.println("Hello World");
        int[] array = { 4, 5, 7, 11, 12, 15, 15, 21, 40, 45 };
//        System.out.println(searchIndex(array,11));
        zadaniePierwsze();
        zadanieDrugie();
    }

    public static int zadanieTrzecie(int[] array, int value)    {
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

    public static void zadaniePierwsze() throws IOException {

        try (FileInputStream in = new FileInputStream("D:\\Users\\aleksander.gorecki\\IdeaProjects\\apki-backendowe\\input")) {
            String str = "xd";
            str.getBytes(StandardCharsets.UTF_8);
            byte[] bytes = in.readAllBytes();
            InputStream inputStream = new ByteArrayInputStream(bytes);

            StringBuilder textBuilder = new StringBuilder();
            try (Reader reader = new BufferedReader(new InputStreamReader
                    (inputStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    textBuilder.append((char) c);
                }
            }
            System.out.println(textBuilder.toString());
        }
    }

    public static void zadanieDrugie() throws IOException {
        String fileName = "D:\\Users\\aleksander.gorecki\\IdeaProjects\\apki-backendowe\\output.txt";
        try (FileOutputStream fos = new FileOutputStream(fileName)) {

            String text = "Today is a beautiful day";
            byte[] mybytes = text.getBytes();

            fos.write(mybytes);
        }
    }


}
