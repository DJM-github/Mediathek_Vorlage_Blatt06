package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Datum;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.DVD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * Mit Hilfe von Vormerkkarten werden beim vormerken eines Mediums alle relevanten
 * Daten notiert.
 * 
 * Sie beantwortet die folgenden Fragen: Welches Medium wurde vorgemerkt? Wer
 * hat das Medium vorgemerkt? Wann wurde das Medium vorgemerkt?
 * 
 * Wenn Medien zurück gegeben werden, kann die Vormerkkarte aufgerufen werden
 * werden. Um die Verwaltung der Karten kümmert sich der VerleihService
 * 
 * @author DJM
 * @version SoSe 2015
 */
public class Vormerkkarte
{

    // Eigenschaften einer Vormerkkarte
    private final Datum _vormerkdatum;
    private final Kunde _vormerker;
    private final Medium _medium;

    /**
     * Initialisert eine neue Vormerkkarte mit den gegebenen Daten.
     * 
     * @param vormerker Ein Kunde, der ein Medium vorgemerkt hat.
     * @param mediumsbezeichner Art und Title des vorgemerkten Mediums.
     * @param vormerkdatum Ein Datum, an dem der Kunde ein Medium vorgemerkt
     *            hat.
     * 
     * @require vormerker != null
     * @require mediumsbezeichner != null
     * @require vormerkdatum != null
     * 
     * @ensure #getVormerker() == vormerker
     * @ensure #getMediumsbezeichner() == mediumsbezeichner
     * @ensure #getVormerkdatum() == vormerkdatum
     */
    public Vormerkkarte(Kunde vormerker, Medium medium, Datum vormerkdatum)
    {
        assert vormerker != null : "Vorbedingung verletzt: vormerker != null";
        assert medium != null : "Vorbedingung verletzt: medium != null";
        assert vormerkdatum != null : "Vorbedingung verletzt: ausleihdatum != null";

        _vormerker = vormerker;
        _vormerkdatum = vormerkdatum;
		_medium =  medium;
    }

    /**
     * Gibt das Vormerkdatum zurück.
     * 
     * @return Das Vormerkdatum.
     * 
     * @ensure result != null
     */
    public Datum getVormerkdatum()
    {
        return _vormerkdatum;
    }

    /**
     * Gibt den Vormerker zurück.
     * 
     * @return den Kunden, der das Medium vorgemerkt hat.
     * 
     * @ensure result != null
     */
    public Kunde getVormerker()
    {
        return _vormerker;
    }

    /**
     * Gibt eine String-Darstellung der Vormerkkarte (enhält Zeilenumbrüche)
     * zurück.
     * 
     * @return Eine formatierte Stringrepäsentation der Vormerkkarte. Enthält
     *         Zeilenumbrüche.
     * 
     * @ensure result != null
     */
    public String getFormatiertenString()
    {
        return _medium.getTitel()+ " am "
                + _vormerkdatum.toString() + " vorgemerkt für\n"
                + _vormerker.getFormatiertenString();
    }

    /**
     * Gibt das Medium, dessen Vormerkung auf der Karte vermerkt ist, zurück.
     * 
     * @return Das Medium, dessen Vormerkung auf dieser Karte vermerkt ist.
     * 
     * @ensure result != null
     */
    public Medium getMedium()
    {
        return _medium;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((_vormerkdatum == null) ? 0 : _vormerkdatum.hashCode());
        result = prime * result
                + ((_vormerker == null) ? 0 : _vormerker.hashCode());
        result = prime * result + ((_medium == null) ? 0 : _medium.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;
        if (obj instanceof Vormerkkarte)
        {
            Vormerkkarte other = (Vormerkkarte) obj;

            if (other.getVormerkdatum().equals(_vormerkdatum)
                    && other.getVormerker().equals(_vormerker)
                    && other.getMedium().equals(_medium))

                result = true;
        }
        return result;
    }

    @Override
    public String toString()
    {
        return getFormatiertenString();
    }
}
