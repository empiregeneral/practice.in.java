package cn.edu.hdu.acm.problem1009;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            int catFoodTotal = Integer.parseInt(scanner.next());
            int houseTotal = Integer.parseInt(scanner.next());
            if (catFoodTotal == -1 && houseTotal == -1) {
                break;
            }

            List<Rational> radioList = new ArrayList<>();

            for (int house = 0; house < houseTotal; house++) {
                int catFood = Integer.parseInt(scanner.next());
                int javaBean = Integer.parseInt(scanner.next());
                Rational radio = new Rational(catFood, javaBean);
                radioList.add(radio);
            }
            Scanner out = new Scanner(new Solution(radioList, new Rational(catFoodTotal, 1)));
            while(out.hasNextLine()) {
                System.out.println(out.nextLine());
            }
        }
    }

}

