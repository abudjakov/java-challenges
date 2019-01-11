package archive;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrogRiverOneTest {

    private FrogRiverOne frogRiverOne;

    @BeforeMethod
    public void setUp() throws Exception {
        frogRiverOne = new FrogRiverOne();
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 5, 6},
                {new int[]{2, 6, 3, 1, 4}, 3, 3},
                {new int[]{1, 3, 1, 4, 2, 3, 2, 4}, 5, -1},
                {new int[]{1, 1}, 3, -1},
                {new int[]{}, 3, -1},
        };
    }

    @Test(dataProvider = "data")
    public void should_test_solution(int[] A, int X, int expected) throws Exception {
        assertThat(frogRiverOne.solution(X, A)).isEqualTo(expected);
    }
}