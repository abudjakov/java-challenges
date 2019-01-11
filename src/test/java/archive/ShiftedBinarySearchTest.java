package archive;

import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ShiftedBinarySearchTest {


    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {new int[]{18, 20, 21, 1, 3, 6, 8, 10, 11, 12, 15}, 10, 7},
                {new int[]{18, 20, 21, 1, 3, 6, 8, 10, 11, 12, 15}, 11, 8},
                {new int[]{18, 20, 21, 1, 3, 6, 8, 10, 11, 12, 15}, 12, 9},
                {new int[]{18, 20, 21, 1, 3, 6, 8, 10, 11, 12, 15}, 14, -1},
                {new int[]{18, 20, 21, 1, 3, 6, 8, 10, 11, 12, 15}, 18, 0},
                {new int[]{18, 20, 21, 1, 3, 6, 8, 10, 11, 12, 15}, 20, 1},
                {new int[]{18, 20, 21, 1, 3, 6, 8, 10, 11, 12, 15}, 21, 2},
                {new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 1, 5},
                {new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 2, 6},
                {new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 3, 7},
                {new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 4, 0},
                {new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 5, 1},
                {new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8, 4},
                {new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 9, -1},
                {new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 0, -1},
        };
    }

    @Test(dataProvider = "data")
    public void should_test_solution(int[] arr, int value, int index) {
        ShiftedBinarySearch search = new ShiftedBinarySearch();
        assertThat(search.find(value, arr)).as("arr: %s, value: %s", Arrays.toString(arr), value).isEqualTo(index);

        try (AutoCloseableSoftAssertions softly = new AutoCloseableSoftAssertions()) {
            softly.assertThat(true);
        }
    }

}