

import Lesson4.Function;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class TriangleTest {
    Function function = new Function();
    private  static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @DisplayName("Проверка на вычесление площади")
    void triangleTest(){
        boolean result = function.triangle(3,4,5);
        Assertions.assertTrue(result);
    }
}
