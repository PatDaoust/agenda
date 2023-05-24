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
public class EvenementTest {

    public EvenementTest() {
    }

    @Test
    public void testConstructeurSansException() throws ErreurEvenement, ErreurDate {
        //arrange
        Date date1 = new Date(2, 1, 2023, 7, 42);
        Date date2 = new Date(2, 1, 2024, 7, 42);
        Evenement evenement = new Evenement("pet kittens", date1, date2);
        String nomAttendue = "pet kittens";
        Date dateDebutAttendue = date1;
        Date dateFinAttendue = date2;
        //act
        String nomObserver = evenement.getNom();
        Date dateDebutObserver = evenement.getDebut();
        Date dateFinObserver = evenement.getFin();
        //assert
        assertEquals(nomAttendue, nomObserver);
        assertEquals(dateDebutAttendue, dateDebutObserver);
        assertEquals(dateFinAttendue, dateFinObserver);

    }

    @Test(expected = ErreurEvenement.class)
    public void testConstructeurAvecException() throws ErreurEvenement, ErreurDate {
        Date date1 = new Date(2, 1, 2023, 7, 42);
        Date date2 = new Date(2, 1, 2024, 7, 42);
        Evenement evenement = new Evenement("pet kittens", date2, date1);
    }

}
