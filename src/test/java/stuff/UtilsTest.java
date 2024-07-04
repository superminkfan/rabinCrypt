package stuff;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class UtilsTest {

        @Test
        public void testWithValidString() {
            String str = "123";
            List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(2);
            expected.add(3);
            HashMap<String, Integer> map = Mockito.mock(HashMap.class);
            Mockito.when(map.get("1")).thenReturn(1);
            Mockito.when(map.get("2")).thenReturn(2);
            Mockito.when(map.get("3")).thenReturn(3);
            List<Integer> actual = Utils.getNumbers(str);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testWithEmptyString() {
            String str = "";
            List<Integer> expected = new ArrayList<>();
            HashMap<String, Integer> map = Mockito.mock(HashMap.class);
            List<Integer> actual = Utils.getNumbers(str);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testWithNullString() {
            String str = null;
            List<Integer> expected = new ArrayList<>();
            HashMap<String, Integer> map = Mockito.mock(HashMap.class);
            List<Integer> actual = Utils.getNumbers(str);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testWithNonNumericString() {
            String str = "abc";
            List<Integer> expected = new ArrayList<>();
            HashMap<String, Integer> map = Mockito.mock(HashMap.class);
            List<Integer> actual = Utils.getNumbers(str);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testWithLargeString() {
            String str = "1234567890";
            List<Integer> expected = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                expected.add(i);
            }
            HashMap<String, Integer> map = Mockito.mock(HashMap.class);
            for (int i = 1; i <= 10; i++) {
                Mockito.when(map.get(String.valueOf(i))).thenReturn(i);
            }
            List<Integer> actual = Utils.getNumbers(str);
            Assertions.assertEquals(expected, actual);
        }
    }

