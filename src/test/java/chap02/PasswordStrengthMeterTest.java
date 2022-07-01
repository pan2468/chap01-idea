package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();


    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL,result);
    }

    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal(){
        PasswordStrength result = meter.meter("ab!@ABqwer");
        assertEquals(PasswordStrength.NORMAL,result);
    }



    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    void meetsAllCriteria_Then_Strong(){
        assertStrength("ab12!@AB",PasswordStrength.STRONG);
        assertStrength("abc1!Add",PasswordStrength.STRONG);
    }

//    @Test
//    void name(){
//
//    }
//
//    @Test
//    void meetsAllCriteria_Then_Strong(){
//        PasswordStrengthMeter meter = new PasswordStrengthMeter();
//        PasswordStrength result2 = meter.meter("abc1!Add");
//        assertEquals(PasswordStrength.STRONG,result2);
//    }
//
//    @Test
//    void meetsOtherCriteria_except_for_Length_Then_Normal(){
//        PasswordStrengthMeter meter = new PasswordStrengthMeter();
//        PasswordStrength result = meter.meter("ab12!@A");
//        assertEquals(PasswordStrength.NORMAL,result);
//        PasswordStrength result3 = meter.meter("Ab12!c");
//        assertEquals(PasswordStrength.NORMAL,result);
//    }
//
//    @Test
//    void meetsOtherCriteria_except_for_number_Then_Normal(){
//        PasswordStrengthMeter meter = new PasswordStrengthMeter();
//        PasswordStrength result = meter.meter("ab!ABqwer");
//        assertEquals(PasswordStrength.NORMAL,result);
//    }

    @Test
    void nullInput_Then_Invalid(){
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void emptyInput_Then_Invalid(){
        assertStrength("",PasswordStrength.INVALID);
    }

    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStrength("ab12!@df",PasswordStrength.NORMAL);
    }

    @Test
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("abdefghi",PasswordStrength.WEAK);
    }

    @Test
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStrength("12345",PasswordStrength.WEAK);
    }

    @Test
    void meetsOnlyUpperCriteria_Then_Weak(){
        assertStrength("ABZEF",PasswordStrength.WEAK);
    }

    @Test
    void meetsNoCriteria_Then_Weak(){
        assertStrength("abc",PasswordStrength.WEAK);
    }
}