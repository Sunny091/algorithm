public class HW10_4110056028_1 extends Buy_Phone {

    private int[] yValue;

    public HW10_4110056028_1() {
        this.yValue = new int[1000000];
    }

    @Override
    public int[][] bestPhone(int[][] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i][1] > this.yValue[inputArr[i][0]]) {
                this.yValue[inputArr[i][0]] = inputArr[i][1];
            }
        }
    }
}
