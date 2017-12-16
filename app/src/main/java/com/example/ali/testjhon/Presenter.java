package com.example.ali.testjhon;

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
        List<Integer> listWarna = new ArrayList<>();
        listWarna.add(R.color.colorHitam);
        listWarna.add(R.color.colorCoklat);
        listWarna.add(R.color.colorMerah);
        listWarna.add(R.color.colorOrange);
        listWarna.add(R.color.colorKuning);
        listWarna.add(R.color.colorHijau);
        listWarna.add(R.color.colorBiru);
        listWarna.add(R.color.colorUngu);
        listWarna.add(R.color.colorAbuabu);
        listWarna.add(R.color.colorPutih);

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

        for (int i = 0; i < listLamp.size(); i++) {
            view.setFirs(listLamp.get(i));
        }

        String mInput = property.getInput();
        String[] nList = mInput.split(" ");
        int n = 9;
        List<Integer> listInt = new ArrayList<>();
        for (int y = 1; y <= 9; y++) {
            listInt.add(0);
        }
        cariLampuYangHidup(listInt, nList, n, listLamp);
        banyakLampuYangHidup(listInt, listWarna);
    }

    public void cariLampuYangHidup(List<Integer> listInt, String[] nList, int n, List<AppCompatImageView> listLamp) {
        for (int aa = 1; aa <= nList.length; aa++) {
            if (aa % 2 == 1) {
                int xx = Integer.parseInt(nList[aa - 1]);/*angka ini menjadi index bola lampu ke berapa*/
                if (xx >= 1 && xx <= n) {
                    if (aa < nList.length) {
                        int dx = Integer.parseInt(nList[aa]);/*akan menjadi nilai berapa kali di klick*/
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
