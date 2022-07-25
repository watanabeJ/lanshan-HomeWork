package day2.demo03;

import java.util.Scanner;

public class splitNumber {

    int n = 0, m = 0;
    int[] a = new int[20];

    public void dfs(int pos) {

        for (int i = a[pos - 1]; i <= m; i++) {
            if (i == n) {
                continue;
            }
            a[pos] = i;
            m-=i;
            if (m == 0) {
                prin(pos);
            } else {
                dfs(pos + 1);
            }
            m+=i;
        }
    }
    public void prin(int aa) {
        for (int i = 1; i < aa; i++) {
            System.out.print(a[i]+"+");
        }
        System.out.println(a[aa]);
    }
    public static void main(String[] args) {
        new day2.demo03.splitNumber().sf();

    }

    public void sf() {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = n;
        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }
        dfs(1);
    }
}
