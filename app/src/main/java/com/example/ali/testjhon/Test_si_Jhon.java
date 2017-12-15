package com.example.ali.testjhon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ali on 15/12/17.
 */

public class Test_si_Jhon {
    public static void main(String[] arggs) {
        Scanner input = new Scanner(System.in);
        int rowTh = Integer.parseInt(input.next());
        int colombTh = Integer.parseInt(input.next());
        int nRow = 30;
        List<Integer> mListInt = new ArrayList<>();
        List<List> mListOfListInt = new ArrayList<>();
        int row, numb;

        for (int a = 0; a <= nRow; a++) {
            numb = 1;
            row = a + 1;
            for (int b = nRow - a; b > 0; b--) {
                System.out.print(" ");
            }

            for (int c = 0; c <= a; c++) {
                if (c > 0) {
                    numb = numb * (row - c) / c;
                    mListInt.add(numb);
                } else {
                    mListInt.add(numb);
                }
                System.out.print(numb + " ");

            }
            mListOfListInt.add(mListInt);
            mListInt = new ArrayList<>();
            System.out.println();
        }

        if(rowTh >= 1 && rowTh <= nRow && colombTh >= 1 && colombTh <= rowTh) {
            List<Integer> list = mListOfListInt.get(rowTh - 1);
            Integer x = list.get(colombTh - 1);
            System.out.print("deretan angka pada baris ke " + rowTh + ": " + mListOfListInt.get(rowTh - 1).toString());
            System.out.println();
            System.out.print("angka yang dicari pada kolom ke " + colombTh + ": " + x);
        } else if (rowTh == 1 && colombTh < 1){
            System.out.print("deretan angka pada baris ke " + (rowTh) + ": " + mListOfListInt.get(rowTh - 1).toString());
            System.out.println();
            System.out.print("angka yang dicari pada kolom ke " + colombTh + ": " + 1);
        } else {
            System.out.println("tidak ditemukan");
        }
    }
}