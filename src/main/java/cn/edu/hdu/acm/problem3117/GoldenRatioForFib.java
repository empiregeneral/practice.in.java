package cn.edu.hdu.acm.problem3117;

public class GoldenRatioForFib {
    private static double goldenRatio = (1 + Math.sqrt(5)) / 2;
    public static int solution(int N) {
        return (int)Math.round(Math.pow(goldenRatio, N)/ Math.sqrt(5));
    }
}
