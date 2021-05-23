package homeworkLesson14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Ex1Test {

    private Ex1 ex1;

    @BeforeEach
    void startUp() {
        System.out.println("Начало теста");
        ex1 = new Ex1();
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

    @DisplayName("Проверка правильности отрезки массива")
    @ParameterizedTest
    @MethodSource("data")
    void testEx1(int[] arrIntIn, int[] arrIntOut) {
        Assertions.assertArrayEquals(arrIntOut, ex1.endForFour(arrIntIn));
    }

    @DisplayName("Проверка исключения")
    @ParameterizedTest
    @MethodSource("dataRuntimeException")
    void testEx1RuntimeException(int[] arrInt) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ex1.endForFour(arrInt);
        });
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}),
                Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 7}, new int[]{1, 7}),
                Arguments.arguments(new int[]{1, 2, 1, 4, 7}, new int[]{7}),
                Arguments.arguments(new int[]{4, 2, 5, 66, 2, 3, 88, 1, 7}, new int[]{2, 5, 66, 2, 3, 88, 1, 7}),
                Arguments.arguments(new int[]{4, 2, 5, 66, 2, 3, 88, 1, 4}, new int[]{})
        );
    }

    static Stream<Arguments> dataRuntimeException() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}),
                Arguments.arguments(new int[]{0, 1, 1, 1}),
                Arguments.arguments(new int[]{4, 4, 4, 4, 4}),
                Arguments.arguments(new int[]{1, 2, 2, 3, 1, 7})

        );
    }
}

