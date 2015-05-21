package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.*;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Datum;
import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class VormerkkarteTest
{
    
    @Test
    public void testConstruction()
    {
        Datum testdatum = Datum.heute();
        Medium testmedium = new CD("Titel", "Kommentar", "Interpret", 1337);
        Kunde testkunde = new Kunde(new Kundennummer(123456), "Atze", "Peng");
        Vormerkkarte karte = new Vormerkkarte(testkunde, testmedium, testdatum);
        
        assertTrue(karte != null);
    }

    @Test
    public void testGetVormerkDatum()
    {
        Datum testdatum = Datum.heute();
        Medium testmedium = new CD("Titel", "Kommentar", "Interpret", 1337);
        Kunde testkunde = new Kunde(new Kundennummer(123456), "Atze", "Peng");
        Vormerkkarte karte = new Vormerkkarte(testkunde, testmedium, testdatum);

        assertEquals(karte.getVormerkdatum(), Datum.heute());

    }

    @Test
    public void testGetVormerker()
    {
        Datum testdatum = Datum.heute();
        Medium testmedium = new CD("Titel", "Kommentar", "Interpret", 1337);
        Kunde testkunde = new Kunde(new Kundennummer(123456), "Atze", "Peng");
        Vormerkkarte karte = new Vormerkkarte(testkunde, testmedium, testdatum);

        assertEquals(karte.getVormerker(), testkunde);
    }

//    @Test
//    public void testGetMediumsbezeichner()
//    {
//        Datum testdatum = Datum.heute();
//        Medium testmedium = new CD("Titel", "Kommentar", "Interpret", 1337);
//        Kunde testkunde = new Kunde(new Kundennummer(123456), "Atze", "Peng");
//        Vormerkkarte karte = new Vormerkkarte(testkunde, testmedium, testdatum);
//        String Mediumsbezeichner = testmedium.getMedienBezeichnung()
//        						   +" "
//        						   +testmedium.getTitel()
//        						   +"  ("
//        						   +((CD)testmedium).getInterpret()
//        						   +")";
//        
//        assertEquals(karte.getMediumsbezeichner(), Mediumsbezeichner);
//    }

}
