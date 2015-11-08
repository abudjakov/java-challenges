import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CountDivTest {

    private CountDiv countDiv;

    @BeforeClass
    public void setUp() throws Exception {
        countDiv = new CountDiv();
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {6, 11, 2, 3},
                {11, 345, 17, 20},
                {1, 10, 3, 3},
                {2, 15, 5, 3},
                {7, 15, 5, 2}
        };
    }

    @Test(dataProvider = "data")
    public void should_test_solution(int A, int B, int K, int expected) {
        assertThat(countDiv.solution(A, B, K)).isEqualTo(expected);
    }
}