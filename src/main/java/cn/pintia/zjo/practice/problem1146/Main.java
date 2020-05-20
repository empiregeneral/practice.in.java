package cn.pintia.zjo.practice.problem1146;

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static String s = "";
    public static int n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sup[] =    {"-", " ", "-", "-", " ", "-", "-", "-", "-", "-"};
        String izqSup[] = {"|", " ", " ", " ", "|", "|", "|", " ", "|", "|"};
        String derSup[] = {"|", "|", "|", "|", "|", " ", " ", "|", "|", "|"};
        String mid[] =    {" ", " ", "-", "-", "-", "-", "-", " ", "-", "-"};
        String izqInf[] = {"|", " ", "|", " ", " ", " ", "|", " ", "|", " "};
        String derInf[] = {"|", "|", " ", "|", "|", "|", "|", "|", "|", "|"};
        String inf[] =    {"-", " ", "-", "-", " ", "-", "-", " ", "-", "-"};

        n = sc.nextInt();
        while(n != 0){
            s = sc.next();

            horizontal(sup);
            vertical(derSup, izqSup);
            horizontal(mid);
            vertical(derInf, izqInf);
            horizontal(inf);

            System.out.println("");
            n = sc.nextInt();
        }
    }

    public static void horizontal(String[] cad){
        int si = 0;
        String resp = "";
        for(int i = 0; i < s.length(); i++){
            si = Character.getNumericValue(s.charAt(i));
            resp += " ";
            resp += String.format("%0"+n+"d",0).replace("0", cad[si]);
            resp += " ";
            if(i < (s.length() - 1)) {
                resp += " ";
            }
        }
        System.out.println(resp);
    }

    public static void vertical(String[] derCad, String[] izqCad){
        int si = 0;
        String resp = "";
        for(int i = 0; i < s.length(); i++){
            si = Character.getNumericValue(s.charAt(i));
            resp += izqCad[si];
            resp += String.format("%"+n+"s", " ");
            resp += derCad[si];
            if(i < (s.length() - 1)) {
                resp += " ";
            }
        }

        for(int i = 0; i < n; i++){
            System.out.println(resp);
        }
    }
}