package com.example.ali.testjhon;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ali on 15/12/17.
 */

public class TestLampu {
    public static void main(String[] args) {
        int n = 18;
        String mInput;
        Scanner input = new Scanner(System.in);

        List<String> listColor = getListColor();

        List<Integer> listInt = new ArrayList<>();
        for (int y = 1; y <= 9; y++) {
            listInt.add(0);
        }

        mInput = input.nextLine().trim();
        String[] listInput = mInput.split(" ");
        String[] allNumber = new String[n];

        if (listInput.length < n) {
            for (int i = 1; i <= listInput.length; i++) {
                allNumber[i - 1] = listInput[i - 1];
            }
            for (int i = listInput.length + 1; i <= n; i++) {
                allNumber[i - 1] = "0";
            }
            System.out.println();
            System.out.print(listInt + " kondisi awal");
            cariLampuYangHidup(listInt, allNumber, n);
        } else {
            System.out.print(listInt + " kondisi awal");
            cariLampuYangHidup(listInt, listInput, n);
        }
        banyakLampuYangHidup(listInt, listColor);
    }

    @NonNull
    private static List<String> getListColor() {
        List<String> listColor = new ArrayList<>();
        listColor.add("mati");
        listColor.add("coklat");
        listColor.add("merah");
        listColor.add("orange");
        listColor.add("kuning");
        listColor.add("hijau");
        listColor.add("biru");
        listColor.add("ungu");
        listColor.add("abu-abu");
        listColor.add("putih");
        return listColor;
    }

    private static void cariLampuYangHidup(
            List<Integer> listInt,
            String[] all,
            int n
    ) {
        for (int aa = 1; aa <= all.length; aa++) {
            if (aa % 2 == 1) {
                int xx = Integer.parseInt(all[aa - 1]);
                if (xx >= 1 && xx <= listInt.size()) {
                    if (aa < all.length) {
                        int dx = Integer.parseInt(all[aa]);
                        if (dx >= 0 && dx <= 10000) {
                            if (dx % 2 == 1) {
                                if (listInt.get(xx - 1) == 0) {
                                    listInt.remove(xx - 1);
                                    listInt.add(xx - 1, 1);
                                } else {
                                    int c = listInt.get(xx - 1);
                                    int cx = c + dx;
                                    if (cx % 2 == 1) {
                                        listInt.remove(xx - 1);
                                        listInt.add(xx - 1, 1);
                                    } else {
                                        listInt.remove(xx - 1);
                                        listInt.add(xx - 1, 0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.print(listInt.toString() + " kondisi akhir");
    }

    private static void banyakLampuYangHidup(List<Integer> listInt, List<String> listColor) {
        int counter = 0;
        String mString = listInt.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        String[] angka = mString.split("");
        for (int x = 0; x < angka.length; x++) {
            if (angka[x].contains("1")) {
                counter++;
            }
        }
        System.out.println();
        System.out.print("warnanya adalah: " + listColor.get(counter));
    }
}
