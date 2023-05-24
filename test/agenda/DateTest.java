/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package agenda;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author catal
 */
public class DateTest {

    public DateTest() {
    }

    @Test
    public void testConstructeurSansException() throws ErreurDate {
        //arrange
        Date date = new Date(2, 1, 2023, 7, 42);
        int jourAttendue = 2;
        int moisAttendue = 1;
        int anneeAttendue = 2023;
        int heureAttendue = 7;
        int minuteAttendue = 42;
        //act
        int jourObserver = date.getJour();
        int moisObserver = date.getMois();
        int anneeObserver = date.getAnnee();
        int heureObserver = date.getHeure();
        int minuteObserver = date.getMinute();
        //assert
        assertEquals(jourAttendue, jourObserver);
        assertEquals(moisAttendue, moisObserver);
        assertEquals(anneeAttendue, anneeObserver);
        assertEquals(heureAttendue, heureObserver);
        assertEquals(minuteAttendue, minuteObserver);

    }

    @Test(expected = ErreurDate.class)
    public void testConstructeurAvecException() throws ErreurDate {
        Date date = new Date(2, 1, 1993, 7, 42);
    }

}
