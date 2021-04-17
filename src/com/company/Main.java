package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args){
        List<String> ans = JSONReader.getUsernames(10);
        for(String str : ans ){
            System.out.println(str);
        }
    }
}
