import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test {

    @Test
    void LSD() {
        HW09_4110056028_1 test = new HW09_4110056028_1();
        int[][] start1 = { { 0, 1 }, { 0, 2 }, { 0, 4 }, { 1, 3 }, { 1, 4 }, { 2, 5 }, { 6, 7 } };
        int actual1 = test.Distance(start1);
        Assertions.assertEquals(4, actual1);
    }
}
