import java.util.*;

public class HW03_4110056028_1 extends One_0k_rock{

    @Override
    public boolean[] one0k(String[] str) {
        boolean[] result = new boolean[str.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = true;
        }
        for (int i = 0; i < result.length; i++) {
            if (str[i].length() % 2 == 0) {
                int left = str[i].length()/2-1, right = str[i].length()/2;
                while(left > -1){
                    if (str[i].charAt(left) == '1' || str[i].charAt(right) == '0') {
                        result[i] = false;
                        break;
                    }else{
                        left--;
                        right++;
                    }
                }
            }else{
                result[i] = false;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("test number:");
            int n = scan.nextInt();
            String[] p = new String[n];
            HW03_4110056028_1 test = new HW03_4110056028_1();
            for (int i = 0; i < n; i++) {
                System.out.print("input"+i+": ");
                p[i] = scan.next();
            }
            boolean[] a = new boolean[n];
            a = test.one0k(p);
            for (int i = 0; i < n; i++) {
                System.out.println(a[i]);
            }
        }
    }
}
