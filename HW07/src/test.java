
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test {

    @Test
    void checkllk() {
        HW07_4110056028_1 test = new HW07_4110056028_1();
        int[][] star1 = { { 1, 2 }, { 1, 3 }, { 1, 4 } };
        int[][] star2 = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 0, 1 } };
        boolean actual1 = test.checkLLK(star1);
        boolean actual2 = test.checkLLK(star2);
        Assertions.assertEquals(actual1, true);
        Assertions.assertEquals(actual2, false);
    }
}
