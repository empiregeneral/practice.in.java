package newcoder;

public class Main {
    public static void main(String[] args) {
        double height = 300.0;
        double distance = 0.0;
        int count = 0;
        for ( ; height > 0.0001; count++) {
            distance =  distance + height;
            height = height * 0.75;
            distance += height;
        }

        distance = distance - height;

        System.out.println("Distance: " + distance + ", Count: " +count);
    }

}
