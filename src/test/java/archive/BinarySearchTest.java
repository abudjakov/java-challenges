package archive;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {new int[]{1, 3, 6, 8, 10, 11, 12, 15, 18, 20, 21}, 10, 4},
                {new int[]{1, 3, 6, 8, 10, 11, 12, 15, 18, 20, 21}, 11, 5},
                {new int[]{1, 3, 6, 8, 10, 11, 12, 15, 18, 20, 21}, 12, 6},
                {new int[]{1, 3, 6, 8, 10, 11, 12, 15, 18, 20, 21}, 14, -1},
                {new int[]{1, 3, 6, 8, 10, 11, 12, 15, 18, 20, 21}, 20, 9},
        };
    }

    @Test(dataProvider = "data")
    public void should_test_solution(int[] arr, int value, int index) {
        BinarySearch search = new BinarySearch();
        assertThat(search.index(value, arr)).isEqualTo(index);
    }

}