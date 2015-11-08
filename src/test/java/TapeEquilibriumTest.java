import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TapeEquilibriumTest {

    private TapeEquilibrium tapeEquilibrium;

    @BeforeClass
    public void setUp() throws Exception {
        tapeEquilibrium = new TapeEquilibrium();
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {new int[]{3, 1, 2, 4, 3}, 1},
                {new int[]{5, 2, 1}, 2},
                {new int[]{1, 1, 1}, 1},
                {new int[]{1, 1}, 0},
                {new int[]{-1, 1}, 2},
                {new int[]{1, -1}, 2},
                {new int[]{1, -1, 1}, 1},
                {new int[]{-4, 2, -3, 3, 0}, 2}
        };
    }

    @Test(dataProvider = "data")
    public void should_test(int[] A, int expected) {
        assertThat(tapeEquilibrium.solution(A)).as(Arrays.toString(A)).isEqualTo(expected);
    }
}