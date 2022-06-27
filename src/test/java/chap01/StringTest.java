package chap01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringTest {

    @Test
    void substring(){
        java.lang.String str = "abcde";
        assertEquals("cd",str.substring(2,4));
    }
}