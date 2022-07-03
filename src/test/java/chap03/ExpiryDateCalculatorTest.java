package chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    @Test
    void Expiry_Date_Calculator(){
//        LocalDate billingDate = LocalDate.of(2019,3,1);
//        int payAmount = 10_000;
//
//        ExpiryDateCalculator cal = new ExpiryDateCalculator();
//        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);
//
//        assertEquals(LocalDate.of(2019,4,1),expiryDate);
//
//        LocalDate billingDate2 = LocalDate.of(2019,5,5);
//        int payAmount2 = 10_000;
//
//        ExpiryDateCalculator cal2 = new ExpiryDateCalculator();
//        LocalDate expiryDate2 = cal2.calculateExpiryDate(billingDate2, payAmount2);
//
//        assertEquals(LocalDate.of(2019,6,5),expiryDate2);

        assertExpiryDate(LocalDate.of(2019,3,1),10_000,LocalDate.of(2019,4,1));
        assertExpiryDate(LocalDate.of(2019,5,5),10_000,LocalDate.of(2019,6,5));

    }

    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate){
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(billingDate,payAmount);
        assertEquals(expectedExpiryDate,realExpiryDate);
    }



    @Test
    void one_month_verification(){
        LocalDate billingDate = LocalDate.of(2019,3,1);
        int payAmount = 10_000;

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate,payAmount);

        assertEquals(LocalDate.of(2019,4,1),expiryDate);
    }


}
