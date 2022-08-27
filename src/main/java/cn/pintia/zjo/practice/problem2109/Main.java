package cn.pintia.zjo.practice.problem2109;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            int totalOfCatFood = Integer.parseInt(scanner.next());
            int houseTotal = Integer.parseInt(scanner.next());
            if (totalOfCatFood == -1 && houseTotal == -1) {
                break;
            }

            List<FoodAndBean> foodAndBeanList = new ArrayList<>();

            for (int house = 0; house < houseTotal; house++) {
                int catFood = Integer.parseInt(scanner.next());
                int javaBeans = Integer.parseInt(scanner.next());
                FoodAndBean foodAndBean = new FoodAndBean(catFood, javaBeans);
                foodAndBeanList.add(foodAndBean);
            }
            Scanner output = new Scanner(new Solution(foodAndBeanList, totalOfCatFood));
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }

    }
}
