package com.estsoft.springdemoproject;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitTest {
    @Test
    public void test() {
        // given
        int a = 1;
        int b = 2;

        // when: 검증하고싶은 메소드(코드) 호출
        int sum = a + b;

        // then : when절 실행한 결과 검증
//        Assertions.assertEquals(3, sum);    // JUnit 사용
        assertThat(sum).isEqualTo(3); // AssertJ 사용

//        Assertions.assertThat(sum).isEven();  // JUnit 사용
        assertThat(sum).isOdd();                // AssertJ 사용
    }
}
