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
+ JUnit 플랫폼: 테스팅 프레임워크를 구동하기 위한 런처와 테스트 엔진을 위한 <strong>API</strong>를 제공한다. 
+ JUnit 주피티(Jupiter): JUnit5를 위한 테스트 API와 실행 엔진을 제공한다.
+ JUnit 빈티지(Vintage): JUnit 3과 4로 작성된 테스트를 Junit5 플랫폼에서 실행하기 위한 모듈로 제공한다.

### 👉 @Test 애노테이션 과 테스트 메소드
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
+ @Test 애노테이션 붙인 메소드는 <strong>private</strong>이면 안된다.

### 👉 JUnit Assertions클래스의 assertEquals() 메소드 값 검증하기
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
+ <strong>calculateExpiryDate</strong> 메소드를 통해서 값  
### 👉 @BeforeAll 애노테이션과 @AfterAll 애노테이션
```
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifecycleTest {
    public LifecycleTest(){
        System.out.println("new LifecycleTest");
    }

    @BeforeEach
    void setUp(){
        System.out.println("setUp");
    }

    @Test
    void a(){
        System.out.println("A");
    }

    @Test
    void b(){
        System.out.println("B");
    }

    @AfterEach
    void tearDown(){
        System.out.println("tearDown");
    }
}

```
+ @BeforeEach 애노테이션과 @AfterEach 애노테이션 붙인 메서드는 @Test 애노테이션과 마찬가지로 <strong>private</strong>이면 안된다.
### 👉 @DisplayName, @Disabled
```
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

```
+ @DisplayName() 실행해서 사용하면 테스트에 표시 이름을 붙일 수 있다. 
+ @Disabled() 애노테이션은 잠시동안 실행에서 제외시킨다.

### 테스트 범우와 종류
+ 하나의 기능이 올바르게 동작하려면 컨트롤러, 서비스, 모델과 같은 자바 코드와 프레임워크 설정에 문제가 없어야 한다. 
+ 브라우저에서 실행되는 자바스크립트 코드, HTML과 CSS 등이 정상 동작해야 한다. DB의 테이블도 올바르게 생성되어 있어야 한다.


