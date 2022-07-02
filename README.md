## 📚 TDD 테스트 주도 개발 
### 👉 TDD 란?

+ <strong>TDD</strong>는 테스트부터 시작한다.
+  구현을 먼저 하고 나중에 테스트하는 것이 아니라 <strong>먼저 테스트를 하고 그다음에 구현한다.</strong></br>
+ 구현 코드가 없는데 어떻게 테스트할 수 있을까? 여기서 테스트를 먼저 한다는 것은 기능이 올바를게 동작하는지 검증하는 테스트 코드를 작성한다는 것을 의미한다.</br>
+ 기능은 검증하는 테스트 코드를 먼저 작성하고 테스트를 통과시키기 위해 개발을 진행한다.

### 👉 TDD 장점
+ 기능구현을 먼저 하기전에 테스트 기능 검증확인해보기
+ 테스트 코드 작성하면 개발의 생산성이 좋다.
+ 유지보수 코드에서 리팩토링 통해서 버그, 재수정 등 
+ 테스트 기능 구현 통해서 소스코드는 사용자가 쉽게 이해할 수 있도록 구현됨 

### 👉 JUnit 5
+ JUnit 플랫폼: 테스팅 프레임워크를 구동하기 위한 런처와 테스트 엔진을 위한 API를 제공한다. 
+ JUnit 주피티(Jupiter): JUnit5를 위한 테스트 API와 실행 엔진을 제공한다.
+ JUnit 빈티지(Vintage): JUnit 3과 4로 작성된 테스트를 Junit5 플랫폼에서 실행하기 위한 모듈로 제공한다.

### @Test 애노테이션 과 테스트 메소드
```
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {

    @Test
    void sum(){
        int result = 2 + 3;
        assertEquals(5,result);
    }
}
```
+ @Test 애노테이션 붙인 메소드는 private이면 안된다.

### JUnit Assertions클래스의 assertEquals() 메소드 값 검증하기
```
    @Test
    void one_month_verification(){
        LocalDate billingDate = LocalDate.of(2019,3,1);
        int payAmount = 10_000;

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate,payAmount);

        assertEquals(LocalDate.of(2019,4,1),expiryDate);
    }
```
```
 public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount){
       // return LocalDate.of(2019,4,1);
        return billingDate.plusMonths(1);
    }
```
+ calculateExpiryDate 메소드를 통해서 값  


