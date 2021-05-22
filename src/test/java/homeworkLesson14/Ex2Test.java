package homeworkLesson14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class Ex2Test {
    private Ex2 ex2;

    @BeforeEach
    void startUp() {
        System.out.println("Начало теста");
        ex2 = new Ex2();
    }

    @AfterEach
    void shutdown() {
        System.out.println("Окончание теста");
    }

    @BeforeAll
    static void init() {
        System.out.println("ГЛАВНЫЙ СТАРТ!");
    }

    @AfterAll
    static void end() {
        System.out.println("ГЛАВНЫЙ КОНЕЦ!");
    }

    @DisplayName("Проверка наличия 1 и 4")
    @ParameterizedTest
    @MethodSource("data")
    void testEx2(int[] arrIntIn) {
        Assertions.assertTrue(ex2.checkNum(arrIntIn));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}),
                Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}),
                Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 3}),
                Arguments.arguments(new int[]{4, 4, 4, 4}),
                Arguments.arguments(new int[]{1, 4})
        );
    }

}
