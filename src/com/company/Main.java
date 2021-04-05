package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] str = new String[100][3];
        int i = 0, coll = 0, search = 0;
        while (scan.hasNextLine()) {
            String d = scan.nextLine();
            String[] st = d.split("");
            if (st.length <= 1) {
                break;
            } else if (st.length == 2) {
                if (st[0].equals("INC")) {
                    for (int j = 0; j < str.length; j++) {
                        if (str[j][0].equals(st[1])) {
                            search = j;
                            break;
                        } else {
                            System.out.print("doesnt extist");
                        }
                    }
                    if (str[search][2].charAt(str[search][2].length() - 1) == 'h') {
                        coll = Integer.parseInt(str[search][2].substring(0, str[search][2].length() - 1), 16);
                        System.out.print(Integer.toHexString(++coll));
                    } else if (str[search][2].charAt(str[search][2].length() - 1) == 'q') {
                        coll = Integer.parseInt(str[search][2].substring(0, str[search][2].length() - 1), 8);
                        System.out.print(Integer.toOctalString(++coll));
                    } else if (str[search][2].charAt(str[search][2].length() - 1) == 'b') {
                        coll = Integer.parseInt(str[search][2].substring(0, str[search][2].length() - 1), 2);
                        System.out.print(Integer.toBinaryString(++coll));
                    } else if (str[search][2].charAt(str[search][2].length() - 1) == 'd') {
                        coll = Integer.parseInt(str[search][2].substring(0, str[search][2].length() - 1));
                        System.out.print(++coll);
                    } else if (str[search][2].charAt(str[search][2].length() - 1) == '\'') {
                        if (str[search][2].length() == 3) {
                            coll = (int) str[search][2].charAt(1);
                            System.out.print(++coll);
                        }
                    }
                }
            }
        }
    }
}
