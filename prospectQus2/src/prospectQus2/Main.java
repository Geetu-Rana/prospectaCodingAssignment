package prospectQus2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int[][] sol(int n,String[][] arr) {
    	
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alpha = s1.toCharArray();

        List<Character> li = new ArrayList<>();

        for(Character c: alpha) {
            li.add(c);
        }
        int[][] ans = new int[arr.length][arr.length];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                String[] s = arr[i][j].trim().split("+");
                if(s.length==1) {
                    ans[i][j] = Integer.parseInt(s[0]);
                } else {
                    char[] c1 = s[0].toCharArray();
                    char[] c2 = s[1].toCharArray();



                    if(c1.length == 1 && c2.length == 1) {
                       int num = Integer.parseInt(String.valueOf(c1[0]));
                        int num1 = Integer.parseInt(String.valueOf(c2[0]));
                        ans[i][j] = num + num1;
                    } else if (c1.length == 1 && c2.length>1) {

                        int num = Integer.parseInt(String.valueOf(c1[0]));

                        int i2 = li.indexOf(c2[0]);
                        int j2 = Integer.parseInt(String.valueOf(c2[1]));

                        ans[i][j] = num+ans[i2][j2];
                    } else {

                        int i1 = li.indexOf(c1[0]);
                        int j1 = Integer.parseInt(String.valueOf(c1[1]));

                        int i2 = li.indexOf(c2[0]);
                        int j2 = Integer.parseInt(String.valueOf(c2[1]));
                        ans[i][j] = ans[i1][j1]+ans[i2][j2];
                    }
                }

            }
        }

        return ans;

    }

    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[][] arr = new String[n][n];

        for(int i=0;i<n;i++) {
        	String[] a = sc.next().split(",");
            for(int j=0;j<n;j++) {
                String[] s= a[j].split(" : ");
                arr[i][j] = s[0];
               
            }
        }

        int[][] ans = sol(n,arr);

        for(int i=0;i<n;i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}