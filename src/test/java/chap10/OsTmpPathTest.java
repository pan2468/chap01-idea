package chap10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OsTmpPathTest {
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void windowTmpPath(){
        Path tmpPath = Paths.get("C:\\Temp");
        assertTrue(Files.isDirectory(tmpPath));
    }

    @Test
    @EnabledOnJre({JRE.JAVA_8,JRE.JAVA_9,JRE.JAVA_10,JRE.JAVA_11})
    void testOnJre(){
        assertEquals(LocalDate.of(1919,3,1),LocalDate.of(2019,3,1).minusYears(100));
    }

    @Test
    @EnabledIfSystemProperty(named = "java.vm.name",matches = ".*OpenJDK.*")
    void openjdk(){
        assertEquals(2,1 + 1);
    }
}
