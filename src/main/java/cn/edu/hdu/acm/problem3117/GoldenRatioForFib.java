package cn.edu.hdu.acm.problem3117;

public class GoldenRatioForFib {
    private static double goldenRatio = (1 + Math.sqrt(5)) / 2;
    public static int solution(int N) {
        return (int)Math.round(Math.pow(goldenRatio, N)/ Math.sqrt(5));
    }

    public static int fib(int N) {
        if (N < 1) {
            return N;
        }
        int pre = 0;
        int cur = 1;
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = pre + cur;
            pre = cur;
            cur = result;
        }
        return result;
    }
}
