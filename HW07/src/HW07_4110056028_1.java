public class HW07_4110056028_1 extends LLK {
    public static void main(String[] args) throws Exception {
        int[][] star1 = { { 1, 2 }, { 1, 3 }, { 1, 4 } };
        int[][] star2 = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 0, 1 } };
        HW07_4110056028_1 test = new HW07_4110056028_1();
        System.out.println(test.checkLLK(star1));
        System.out.println(test.checkLLK(star2));
    }

    @Override
    public boolean checkLLK(int[][] array) {
        if (array.length < 3) {
            return false;
        }

        for (int i = 0; i < array.length - 2; i++) {
            int[] star1 = array[i];

            for (int j = i + 1; j < array.length - 1; j++) {
                int[] star2 = array[j];

                for (int k = j + 1; k < array.length; k++) {
                    int[] star3 = array[k];

                    // �p��T�I�������ײv
                    // �Y�ײv�۵��A��ܤT���P�P�b�P�@���u�W
                    if ((star2[1] - star1[1]) * (star3[0] - star1[0]) == (star3[1] - star1[1])
                            * (star2[0] - star1[0])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
