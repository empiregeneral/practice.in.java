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

            List<BeansAndFood> beansAndFoodList = new ArrayList<>();

            for (int house = 0; house < houseTotal; house++) {
                int javaBeans = Integer.parseInt(scanner.next());
                int catFood = Integer.parseInt(scanner.next());
                BeansAndFood beansAndFood = new BeansAndFood(javaBeans, catFood);
                beansAndFoodList.add(beansAndFood);
            }
            Scanner output = new Scanner(new Solution(beansAndFoodList, totalOfCatFood));
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }

    }
}
