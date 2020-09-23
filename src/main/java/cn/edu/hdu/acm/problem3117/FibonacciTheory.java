package cn.edu.hdu.acm.problem3117;

/**
 * @author canmozhang
 */
public enum FibonacciTheory {
    GOLD_RATIO() {
        @Override
        protected int solution(int n) {
            double goldenRatio = (1 + Math.sqrt(5)) / 2;
            return (int) Math.round(Math.pow(goldenRatio, n) / Math.sqrt(5));
        }
    },

    RECURSION() {
        @Override
        protected int solution(int n) {
            if (n < 0) {
                return 1;
            }

            int[] memo = new int[n + 1];
            java.util.Arrays.fill(memo, 0);
            return helper(memo, n);


        }

        private int helper(int[] memo, int n) {
            if (n == 1 || n == 2) {
                return n;
            }
            if (memo[n] != 0) {
                return memo[n];
            }
            memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
            return memo[n];
        }


    },

    DYNAMIC_PROGRAMMING() {
        @Override
        protected int solution(int n) {
            if (n < 1) {
                return n;
            }
            int pre = 0;
            int cur = 1;
            int result = 0;
            for (int i = 0; i < n; i++) {
                result = pre + cur;
                pre = cur;
                cur = result;
            }
            return result;
        }
    };


    abstract int solution(int n);
}

