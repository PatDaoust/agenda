/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package agenda;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author catal
 */
@RunWith(Parameterized.class)
public class AgendaParamaterizedTest {

    private Agenda agenda;
    private Date date1;
    private Date date2;
    private String nomEvenement;
    private Date dateChercher;
    private String stringAttendue;

    public AgendaParamaterizedTest(Agenda aagenda, Date adate1, Date adate2, String anomEvenement, Date adateChercher, String astringAttendue) throws ErreurEvenement {
        agenda = aagenda;
        date1 = adate1;
        date2 = adate2;
        nomEvenement = anomEvenement;
        dateChercher = adateChercher;
        stringAttendue = astringAttendue;
    }

    @Parameterized.Parameters
    public static Collection listTest() throws ErreurDate {
        Object[][] lp = {
            {new Agenda(), new Date(2, 1, 2023, 6, 42), new Date(2, 1, 2024, 7, 42), "pet kittens", new Date(1, 1, 2024, 1, 1), "pet kittens"},
            {new Agenda(), new Date(6, 1, 2023, 5, 42), new Date(2, 1, 2025, 7, 42), "pet puppies", new Date(1, 1, 2025, 1, 1), "pet puppies"},
            {new Agenda(), new Date(3, 1, 2023, 7, 42), new Date(2, 1, 2029, 7, 42), "nap", new Date(1, 1, 2029, 1, 1), "nap"}
        };
        return Arrays.asList(lp);
    }

    @Test
    public void testChercherEvenementParameter() throws ErreurDate, ErreurEvenement {
        //arrange
        Evenement bevenement = new Evenement(nomEvenement, date1, date2);
        agenda.ajouter(bevenement);
        //act
        String stringObserver = agenda.chercherEvenement(dateChercher);
        //assert
        assertEquals(stringAttendue, stringObserver);
    }

}
