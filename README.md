## π TDD νμ€νΈ μ£Όλ κ°λ° 
### π TDD λ?

+ <strong>TDD</strong>λ νμ€νΈλΆν° μμνλ€.
+  κ΅¬νμ λ¨Όμ  νκ³  λμ€μ νμ€νΈνλ κ²μ΄ μλλΌ <strong>λ¨Όμ  νμ€νΈλ₯Ό νκ³  κ·Έλ€μμ κ΅¬ννλ€.</strong></br>
+ κ΅¬ν μ½λκ° μλλ° μ΄λ»κ² νμ€νΈν  μ μμκΉ? μ¬κΈ°μ νμ€νΈλ₯Ό λ¨Όμ  νλ€λ κ²μ κΈ°λ₯μ΄ μ¬λ°λ₯Όκ² λμνλμ§ κ²μ¦νλ νμ€νΈ μ½λλ₯Ό μμ±νλ€λ κ²μ μλ―Ένλ€.</br>
+ κΈ°λ₯μ κ²μ¦νλ νμ€νΈ μ½λλ₯Ό λ¨Όμ  μμ±νκ³  νμ€νΈλ₯Ό ν΅κ³Όμν€κΈ° μν΄ κ°λ°μ μ§ννλ€.

### π TDD μ₯μ 
+ κΈ°λ₯κ΅¬νμ λ¨Όμ  νκΈ°μ μ νμ€νΈ κΈ°λ₯ κ²μ¦νμΈν΄λ³΄κΈ°
+ νμ€νΈ μ½λ μμ±νλ©΄ κ°λ°μ μμ°μ±μ΄ μ’λ€.
+ μ μ§λ³΄μ μ½λμμ λ¦¬ν©ν λ§ ν΅ν΄μ λ²κ·Έ, μ¬μμ  λ± 
+ νμ€νΈ κΈ°λ₯ κ΅¬ν ν΅ν΄μ μμ€μ½λλ μ¬μ©μκ° μ½κ² μ΄ν΄ν  μ μλλ‘ κ΅¬νλ¨ 

### π JUnit 5
+ JUnit νλ«νΌ: νμ€ν νλ μμν¬λ₯Ό κ΅¬λνκΈ° μν λ°μ²μ νμ€νΈ μμ§μ μν <strong>API</strong>λ₯Ό μ κ³΅νλ€. 
+ JUnit μ£ΌνΌν°(Jupiter): JUnit5λ₯Ό μν νμ€νΈ APIμ μ€ν μμ§μ μ κ³΅νλ€.
+ JUnit λΉν°μ§(Vintage): JUnit 3κ³Ό 4λ‘ μμ±λ νμ€νΈλ₯Ό Junit5 νλ«νΌμμ μ€ννκΈ° μν λͺ¨λλ‘ μ κ³΅νλ€.

### π @Test μ λΈνμ΄μ κ³Ό νμ€νΈ λ©μλ
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
+ @Test μ λΈνμ΄μ λΆμΈ λ©μλλ <strong>private</strong>μ΄λ©΄ μλλ€.

### π JUnit Assertionsν΄λμ€μ assertEquals() λ©μλ κ° κ²μ¦νκΈ°
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
+ <strong>calculateExpiryDate</strong> λ©μλλ₯Ό ν΅ν΄μ κ°  
### π @BeforeAll μ λΈνμ΄μκ³Ό @AfterAll μ λΈνμ΄μ
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
+ @BeforeEach μ λΈνμ΄μκ³Ό @AfterEach μ λΈνμ΄μ λΆμΈ λ©μλλ @Test μ λΈνμ΄μκ³Ό λ§μ°¬κ°μ§λ‘ <strong>private</strong>μ΄λ©΄ μλλ€.
### π @DisplayName, @Disabled
```
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("@DisplayName")
public class DisplayNameTest {

    @DisplayName("κ° κ°μμ§ λΉκ΅")
    @Test
    void assertEqualsMethod(){

    }

    @Disabled
    @Test
    void failMethod(){
        System.out.println("νμ€νΈ μ€ν μ€μ§");
    }

    @DisplayName("μ΅μμ λ°μ μ¬λΆ νμ€νΈ")
    @Test
    void assertThrowsTest(){

    }

    @Test
    void assertAllTest(){

    }
}

```
+ @DisplayName() μ€νν΄μ μ¬μ©νλ©΄ νμ€νΈμ νμ μ΄λ¦μ λΆμΌ μ μλ€. 
+ @Disabled() μ λΈνμ΄μμ μ μλμ μ€νμμ μ μΈμν¨λ€.

### β‘ νμ€νΈ λ²μμ μ’λ₯
+ νλμ κΈ°λ₯μ΄ μ¬λ°λ₯΄κ² λμνλ €λ©΄ μ»¨νΈλ‘€λ¬, μλΉμ€, λͺ¨λΈκ³Ό κ°μ μλ° μ½λμ νλ μμν¬ μ€μ μ λ¬Έμ κ° μμ΄μΌ νλ€. 
+ λΈλΌμ°μ μμ μ€νλλ μλ°μ€ν¬λ¦½νΈ μ½λ, HTMLκ³Ό CSS λ±μ΄ μ μ λμν΄μΌ νλ€. DBμ νμ΄λΈλ μ¬λ°λ₯΄κ² μμ±λμ΄ μμ΄μΌ νλ€.



