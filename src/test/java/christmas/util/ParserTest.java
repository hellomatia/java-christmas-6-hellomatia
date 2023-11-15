package christmas.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ParserTest {

    @Test
    void stringToList를_통해_List를_반환한다() {
        var input = "양송이스프-10,티본스테이크-20,레드와인-2";
        var expected = List.of("양송이스프-10", "티본스테이크-20", "레드와인-2");
        assertThat(Parser.stringToList(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "10, 10", "100, 100", "10000, 10_000"})
    void stringToInt를_통해_Int를_반환한다(String input, int expected) {
        assertThat(Parser.stringToInt(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "din", "gksro", "한개"})
    void 숫자가_아닌값이_입력될시_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Parser.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 숫자입니다. 다시 입력해주세요");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void null값이_입력될시_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Parser.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 숫자입니다. 다시 입력해주세요");
    }
}
