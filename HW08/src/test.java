import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test {

    @Test
    void MaxLandArea() {
        HW08_4110056028_2 test = new HW08_4110056028_2();
        int[][] star1 = { { 0, 1, 1 },
                { 1, 0, 1 },
                { 0, 1, 1 } };
        int actual1 = test.maxLandArea(star1);
        Assertions.assertEquals(5, actual1);
    }
}