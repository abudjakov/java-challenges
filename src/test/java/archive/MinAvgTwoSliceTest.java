package archive;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinAvgTwoSliceTest {

    private MinAvgTwoSlice minAvgTwoSlice;

    @BeforeClass
    public void setUp() throws Exception {
        minAvgTwoSlice = new MinAvgTwoSlice();
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {new int[]{4, 2, 2, 5, 1, 5, 8}, 1},
                {new int[]{1, 0, -5, 5, 1}, 1},
                {new int[]{0, 1, 2, 3, 1}, 0},
                {new int[]{2, 1, 2, 1, 2, 1}, 1},
                {new int[]{10, 10, -1, 2, 4, -1, 2, -1}, 5},

        };
    }

    @Test(dataProvider = "data")
    public void should_test_solution(int[] A, int expected) {
        assertThat(minAvgTwoSlice.solution(A)).isEqualTo(expected);
    }
}