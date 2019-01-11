package archive;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;


public class ReverseTest {

    class ReserveO extends Reverse {

        public int count = 0;


        @Override
        public String reverse(String str) {
            count++;
            return super.reverse(str);
        }


    }


    ReserveO runner = new ReserveO();

    @Before
    public void setup() {
        runner.count = 0;
    }

    @Test
    public void should_test_predefined() {
        runner.reverse("hello world");
        Assert.assertEquals("hello world", runner.count, 11);
    }

    private String generator(int n) {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(symbols.charAt((int) Math.floor(Math.random() * symbols.length())));

        return sb.toString();
    }

    @Test
    public void should_tetst_30_randomized() {
        for (int i = 1; i < 30; i++) {
            runner.count = 0;
            String random = generator(i);
            String expected = new StringBuilder(random).reverse().toString();
            Assert.assertEquals(expected, expected, runner.reverse(random));
            Assert.assertEquals(random.length(), runner.count);
        }
        ExecutorService service;
    }


}