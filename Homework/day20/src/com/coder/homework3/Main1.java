package com.coder.homework3;

import com.coder.homework2.Main;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<Integer> originalList = Main.listGenerate();
        List<Integer> newList = new ArrayList<>(5);
        for (int i : originalList) {
            if (i % 2 == 0)
                newList.add(i);
        }
        System.out.println(originalList);
        System.out.println(newList);
    }
}
