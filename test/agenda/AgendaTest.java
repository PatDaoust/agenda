/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package agenda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author catal
 */
public class AgendaTest {

    public AgendaTest() {
    }

    @Test
    public void testConstructeur() {
        //arrange
        Agenda agenda = new Agenda();
        //act
        //assert
        assertNotNull(agenda);
        assertTrue(agenda instanceof Agenda);
    }

    /**
     * Test of ajouter method, of class Agenda.
     */
    @Test
    public void testAjouter() throws ErreurDate, ErreurEvenement {
        //arrange
        Agenda agenda = new Agenda();
        Date date1 = new Date(2, 1, 2023, 7, 42);
        Date date2 = new Date(2, 1, 2024, 7, 42);
        Evenement evenement = new Evenement("pet kittens", date1, date2);
        boolean booleanAttendue1 = true;
        boolean booleanAttendue2 = false;
        //act
        boolean booleanObserver1 = agenda.ajouter(evenement);
        boolean booleanObserver2 = agenda.ajouter(evenement);
        //assert
        assertEquals(booleanAttendue1, booleanObserver1);
        assertEquals(booleanAttendue2, booleanObserver2);
    }

    /**
     * Test of supprimer method, of class Agenda.
     */
    @Test
    public void testSupprimer() throws ErreurDate, ErreurEvenement {
        //arrange
        Agenda agenda = new Agenda();
        Date date1 = new Date(2, 1, 2023, 7, 42);
        Date date2 = new Date(2, 1, 2024, 7, 42);
        Evenement evenement = new Evenement("pet kittens", date1, date2);
        agenda.ajouter(evenement);
        boolean booleanAttendue1 = false;
        boolean booleanAttendue2 = true;
        //act
        boolean booleanObserver1 = agenda.supprimer("pet puppies");
        boolean booleanObserver2 = agenda.supprimer("pet kittens");
        //assert
        assertEquals(booleanAttendue1, booleanObserver1);
        assertEquals(booleanAttendue2, booleanObserver2);
    }

    /**
     * Test of chercherEvenement method, of class Agenda.
     */
    @Test
    public void testChercherEvenement() throws ErreurDate, ErreurEvenement {
        //arrange
        Agenda agenda = new Agenda();
        Date date1 = new Date(2, 1, 2023, 7, 42);
        Date date2 = new Date(2, 1, 2024, 7, 42);
        Date dateChercher1 = new Date(1, 1, 2024, 1, 1);
        Date dateChercher2 = new Date(1, 1, 2027, 1, 1);
        Evenement evenement1 = new Evenement("pet kittens", date1, date2);
        agenda.ajouter(evenement1);
        String stringAttendue1 = "pet kittens";
        String stringAttendue2 = "vide";
        //act
        String stringObserver1 = agenda.chercherEvenement(dateChercher1);
        String stringObserver2 = agenda.chercherEvenement(dateChercher2);
        //assert
        assertEquals(stringAttendue1, stringObserver1);
        assertEquals(stringAttendue2, stringObserver2);
    }

    /**
     * Test of dateDebut method, of class Agenda.
     */
    @Test
    public void testDateDebutSansException() throws Exception {
        //arrange
        Agenda agenda = new Agenda();
        Date date1 = new Date(2, 1, 2023, 7, 42);
        Date date2 = new Date(2, 1, 2024, 7, 42);
        String stringChercher = "pet kittens";
        Evenement evenement1 = new Evenement("pet kittens", date1, date2);
        agenda.ajouter(evenement1);
        Date dateAttendue = date1;
        //act
        Date dateAObserver = agenda.dateDebut(stringChercher);
        //assert
        assertEquals(dateAttendue, dateAObserver);
    }

    /**
     * Test of dateFin method, of class Agenda.
     */
    @Test
    public void testDateFinSansException() throws Exception {
        //arrange
        Agenda agenda = new Agenda();
        Date date1 = new Date(2, 1, 2023, 7, 42);
        Date date2 = new Date(2, 1, 2024, 7, 42);
        String stringChercher = "pet kittens";
        Evenement evenement1 = new Evenement("pet kittens", date1, date2);
        agenda.ajouter(evenement1);
        Date dateAttendue = date2;
        //act
        Date dateAObserver = agenda.dateFin(stringChercher);
        //assert
        assertEquals(dateAttendue, dateAObserver);
    }

    /**
     * Test of dateDebut method, of class Agenda.
     */
    @Test(expected = ErreurAgenda.class)
    public void testDateDebutAvecException() throws Exception {
        //test event that doesn't exist, throw exception
        //arrange
        Agenda agenda = new Agenda();
        String stringChercher = "pet puppies";
        //act
        Date dateAObserver = agenda.dateDebut(stringChercher);

    }

    /**
     * Test of dateFin method, of class Agenda.
     */
    @Test(expected = ErreurAgenda.class)
    public void testDateFinAvecException() throws Exception {
        //test event that doesn't exist, throw exception
        Agenda agenda = new Agenda();
        String stringChercher = "pet puppies";
        //act
        Date dateAObserver = agenda.dateFin(stringChercher);
    }

    /**
     * Test of prevu method, of class Agenda.
     */
    @Test
    public void testPrevu() throws ErreurDate, ErreurEvenement {
        //arrange
        Agenda agenda = new Agenda();
        Date date1 = new Date(2, 1, 2023, 7, 42);
        Date date2 = new Date(2, 1, 2024, 7, 42);
        String nomChercher1 = "pet kittens";
        String nomChercher2 = "pet puppies";
        Evenement evenement1 = new Evenement("pet kittens", date1, date2);
        agenda.ajouter(evenement1);
        boolean boolAttendue1 = true;
        boolean boolAttendue2 = false;
        //act
        boolean boolObserver1 = agenda.prevu(nomChercher1);
        boolean boolObserver2 = agenda.prevu(nomChercher2);
        //assert
        assertEquals(boolAttendue1, boolObserver1);
        assertEquals(boolAttendue2, boolObserver2);
    }

}
