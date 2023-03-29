
public class HW03_4110056028_2 extends One_0k_rock{

    @Override
    public boolean[] one0k(String[] str) {
        boolean[] result = new boolean[str.length];
        boolean check = false;
        int zero_right = 0, one_left = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = true;
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i].length()%2==0) {
                if(str[i].charAt(0) != '0'){
                    result[i] = false;
                    continue;
                }
                if(str[i].charAt(str[i].length()-1) != '1'){
                    result[i] = false;
                    continue;
                }
                for (int j = str[i].length()-1; j > str[i].length()/2-2; j--) {
                    if (str[i].charAt(j) == '0') {
                        check = true;
                        zero_right = j;
                        break;
                    }
                }
                if (!check) {
                    result[i] = false;
                    continue;
                }
                check = false;
                for (int j = 0; j < result.length/2+1; j++) {
                    if(str[i].charAt(j) == '1'){
                        check = true;
                        one_left = j;
                        break;
                    }
                }
                if (!check) {
                    result[i] = false;
                    continue;
                }
                if (zero_right > one_left) {
                    result[i] = false;
                    continue;
                }
            }else{
                result[i] = false;
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws Exception {
        // try (Scanner scan = new Scanner(System.in)) {
        //     System.out.print("test number:");
        //     int n = scan.nextInt();
        //     String[] p = new String[n];
        //     HW03_4110056028_1 test = new HW03_4110056028_1();
        //     for (int i = 0; i < n; i++) {
        //         System.out.print("input"+i+": ");
        //         p[i] = scan.next();
        //     }
        //     boolean[] a = new boolean[n];
        //     a = test.one0k(p);
        //     for (int i = 0; i < n; i++) {
        //         System.out.println(a[i]);
        //     }
        // }
    }
}
