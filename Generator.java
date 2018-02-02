import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class Generator {

    public static void main( String[] args )
    {
        Constituents determinerPhrase = new Constituents();
        Constituents verbPhrase = new Constituents();

        determinerPhrase.buildDeterminerPhrase();
        verbPhrase.buildVerbPhrase();

        determinerPhrase.getMyConstituents();
        verbPhrase.getMyConstituents();

    }



}
