import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test {

    @Test
    void Buy_Phone() {
        HW10_4110056028_1 test = new HW10_4110056028_1();
        int[][] example = { { 1, 1 }, { 2, 4 }, { 2, 10 }, { 5, 4 }, { 4, 8 }, { 5, 5 }, { 8, 4 }, { 10, 2 },
                { 10, 1 } };
        int[][] actual1 = test.bestPhone(example);
        int[][] answer = { { 2, 10 }, { 4, 8 }, { 5, 5 }, { 8, 4 }, { 10, 2 } };
        Assertions.assertEquals(answer, actual1);

    }
}
