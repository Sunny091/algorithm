import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test {

    @Test
    void MaxLandArea() {
        HW08_4110056028_1 test = new HW08_4110056028_1();
        int[][] start1 = { { 0, 1, 1 },
                { 1, 0, 1 },
                { 0, 1, 1 } };
        int[][] start2 = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
        int actual1 = test.maxLandArea(start1);
        int actual2 = test.maxLandArea(start2);
        Assertions.assertEquals(5, actual1);
        Assertions.assertEquals(6, actual2);
    }
}