package com.example.ali.testjhon;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;

import com.example.ali.testjhon.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 16/12/17.
 */

public class Presenter {
    private Interface view;
    private ActivityMainBinding binding;

    public Presenter(Interface view, ActivityMainBinding binding) {
        this.view = view;
        this.binding = binding;
    }

    public void checkLamp(Property property) {
        List<Integer> listColor = getListColor();

        List<AppCompatImageView> listLamp = getListLamp();

        for (int i = 1; i <= listLamp.size(); i++) {
            view.setFirs(listLamp.get(i - 1));
        }

        int n = 18;
        String mInput = property.getInput().trim();
        String[] nList = mInput.split(" ");
        String[] allNumber = new String[n];

        List<Integer> listInt = new ArrayList<>();
        for (int y = 1; y <= 9; y++) {
            listInt.add(0);
        }

        if (nList.length < n) {
            for (int i = 1; i <= nList.length; i++) {
                allNumber[i - 1] = nList[i - 1];
            }
            for (int i = nList.length + 1; i <= n; i++) {
                allNumber[i - 1] = "0";
            }
            cariLampuYangHidup(listInt, allNumber, n, listLamp);
        } else {
            cariLampuYangHidup(listInt, nList, n, listLamp);
        }
        banyakLampuYangHidup(listInt, listColor);
    }

    @NonNull
    private List<Integer> getListColor() {
        List<Integer> listColor = new ArrayList<>();
        listColor.add(R.color.colorHitam);
        listColor.add(R.color.colorCoklat);
        listColor.add(R.color.colorMerah);
        listColor.add(R.color.colorOrange);
        listColor.add(R.color.colorKuning);
        listColor.add(R.color.colorHijau);
        listColor.add(R.color.colorBiru);
        listColor.add(R.color.colorUngu);
        listColor.add(R.color.colorAbuabu);
        listColor.add(R.color.colorPutih);
        return listColor;
    }

    @NonNull
    private List<AppCompatImageView> getListLamp() {
        List<AppCompatImageView> listLamp = new ArrayList<>();
        listLamp.add(binding.image1);
        listLamp.add(binding.image2);
        listLamp.add(binding.image3);
        listLamp.add(binding.image4);
        listLamp.add(binding.image5);
        listLamp.add(binding.image6);
        listLamp.add(binding.image7);
        listLamp.add(binding.image8);
        listLamp.add(binding.image9);
        return listLamp;
    }

    public void cariLampuYangHidup(
            List<Integer> listInt,
            String[] all,
            int n,
            List<AppCompatImageView> listLamp
    ) {
        for (int aa = 1; aa <= n; aa++) {
            if (aa % 2 == 1) {
                int xx = Integer.parseInt(all[aa - 1]);/*angka ini menjadi index bola lampu ke berapa jangan lupa*/
                if (xx >= 1 && xx <= listInt.size()) {
                    if (aa < all.length) {
                        int dx = Integer.parseInt(all[aa]);/*akan menjadi nilai berapa kali di klick*/
                        if (dx >= 0 && dx <= 10000) {
                            if (dx % 2 == 1) {
                                if (listInt.get(xx - 1) % 2 == 0) {
                                    listInt.remove(xx - 1);
                                    listInt.add(xx - 1, 1);
                                    view.enableLamp(listLamp.get(xx - 1));
                                } else {
                                    int c = listInt.get(xx - 1);
                                    int cx = c + dx;
                                    if (cx % 2 == 1) {
                                        listInt.remove(xx - 1);
                                        listInt.add(xx - 1, 1);
                                    } else {
                                        listInt.remove(xx - 1);
                                        listInt.add(xx - 1, 0);
                                        view.disableLamp(listLamp.get(xx - 1));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void banyakLampuYangHidup(List<Integer> listInt, List<Integer> listWarna) {
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
        view.showColor(listWarna.get(counter));

    }
}
