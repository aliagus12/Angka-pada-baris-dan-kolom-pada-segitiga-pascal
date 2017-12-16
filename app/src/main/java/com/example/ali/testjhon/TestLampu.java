package com.example.ali.testjhon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ali on 15/12/17.
 */

public class TestLampu {
    public static void main(String[] args) {
        int n = 9;
        int x;
        Scanner input = new Scanner(System.in);
        List<Integer> listInt = new ArrayList<>();
        List<Integer> nList = new ArrayList<>();
        List<String> listWarna = new ArrayList<>();
        listWarna.add("mati");
        listWarna.add("coklat");
        listWarna.add("merah");
        listWarna.add("orange");
        listWarna.add("kuning");
        listWarna.add("hijau");
        listWarna.add("biru");
        listWarna.add("ungu");
        listWarna.add("abu-abu");
        listWarna.add("putih");

        for (int y = 1; y <= 9; y++) {
            listInt.add(0);
        }

        for (int y = 1; y <= n; y++) {
            x = Integer.parseInt(input.next());
            nList.add(x);
        }
        System.out.print(listInt + " kondisi awal");
        System.out.println();

        cariLampuYangHidup(listInt, nList, n);
        banyakLampuYangHidup(listInt, listWarna);
    }

    private static void cariLampuYangHidup(List<Integer> listInt, List<Integer> nList, int n) {
        for (int aa = 1; aa <= nList.size(); aa++) {
            if (aa % 2 == 1) {
                int xx = nList.get(aa - 1);
                if (xx >= 1 && xx <= n) {
                    if (aa < nList.size()) {
                        int dx = nList.get(aa);
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
        System.out.print(listInt.toString() + " kondisi akhir");
    }

    private static void banyakLampuYangHidup(List<Integer> listInt, List<String> listWarna) {
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
        System.out.println(counter);
        System.out.print("warnanya adalah: "+ listWarna.get(counter));
    }
}
