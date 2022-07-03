package chap05;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("@DisplayName")
public class DisplayNameTest {

    @DisplayName("값 같은지 비교")
    @Test
    void assertEqualsMethod(){

    }

    @Disabled
    @Test
    void failMethod(){
        System.out.println("테스트 실행 중지");
    }

    @DisplayName("익셉션 발생 여부 테스트")
    @Test
    void assertThrowsTest(){

    }

    @Test
    void assertAllTest(){

    }
}
