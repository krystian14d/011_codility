package hackerrank;

public class LegoBlocks {
    public static int legoBlocks(int n, int m) {
        // Write your code here
        int divisor = 7 + (int)Math.pow(10,9);
        long[] p = new long[m]; // combination count of one row of m length
        for (int i = 0; i < m; i++) {
            if (i == 0) p[i] = 1;
            else if (i == 1) p[i] = 2;
            else if (i == 2) p[i] = 4;
            else if (i == 3) p[i] = 8;
            else p[i] = (p[i - 1] + p[i - 2] + p[i - 3] + p[i - 4]) % divisor;
        }

        // all possible (good or bad) combinations count of a n * x (1<=x<=m) wall
        long[] a = new long[m];
        for (int i = 0; i < m; i++) {
            long base = p[i],times = n, res = base;
            while (times > 1) {
                res = (res * base) % divisor;
                times--;
            }
            a[i] = res;
        }

        // good combinations count of a n * x (1<=x<=m) wall
        long[] g = new long[m];
        for (int i = 0; i < m; i++) {
            if (i == 0) g[i] = 1;
            else {
                long pGood = a[i];
                for (int j = 0; j < i; j++) {
                    pGood -= g[j] * a[i - j - 1] % divisor;
                }
                while (pGood < 0) {
                    pGood += divisor;
                }
                g[i] = pGood;
            }
        }
        return (int)(g[m - 1] % divisor);
    }

}
