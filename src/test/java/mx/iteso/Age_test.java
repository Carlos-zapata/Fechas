package mx.iteso;

import mx.iteso.Age;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Carlos Flores on 29/09/2016.
 */
public class Age_test {

        Age_test  testCase;
        @Before
        public void SetUp() {
            testCase = new Age_test();
        }
        @Test
        public void ValidDate() {
            String valDate = Age.getAge(Age.Validate("25/08/1996"));
            assertEquals(valDate, "21 años 1 mes y 3 días");
        }
        @Test
        public void DiffFormat() {
            String invalDate = Age.Validate("Hola Mundo");
            assertEquals(invalDate, "Formato inválido");
        }
        @Test
        public void InvalidDay() {
            String invalDay = Age.Validate("44/10/1991");
            assertEquals(invalDay, "Día inválido");
        }
        @Test
        public void InvalidMonth() {
            String invalMonth = Age.Validate("22/22/1999");
            assertEquals(invalMonth, "Mes inválido");
        }
        @Test
        public void InvalidYear() {
            String invalYear = Age.Validate("16/01/ABCD");
            assertEquals(invalYear, "Formato inválido");
        }
        @Test
        public void FutureDate() {
            String futDate = Age.Validate("01/01/2123");
            assertEquals(futDate, "Año inválido");
        }


}
