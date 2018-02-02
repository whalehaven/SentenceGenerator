import java.util.LinkedList;
import java.util.Random;

public class Constituents {

    //member fields
    protected String[] vowels = {"a", "e", "i", "o", "u"};
    protected BankWarden bank;
    protected Constituents daughterPhrase;
    protected LinkedList<Word> myConstituents;
    protected String typeOfPhrase;


    //constructor
    public Constituents() {
        myConstituents = new LinkedList<Word>();
        bank = new BankWarden();
    }

    //member methods


    public void buildVerbPhrase() {

        this.setTypeOfPhrase("Verb");

        this.buildDeterminerPhrase();

        this.myConstituents.addFirst( buildVerb() );


    }

    public Verb buildVerb()
    {
        Verb value = (Verb)bank.findAWord( new Verb("" ));
        return value;
    }


    /* -------------------COMPLETE DETERMINER PHRASE ALGORITHM--------------------- */

	public void buildDeterminerPhrase()
	{
	    int randomValue;
	    boolean adjectivePresent = false;

		this.setTypeOfPhrase( "Object" );
		
		this.buildNounPhrase();

        randomValue = this.bank.myNumber.nextInt(3) + 1;

        //random condition to add adjective
        if ( randomValue == 2 )
        {
            this.buildAdjectivePhrase();
            adjectivePresent = true;
        }

        randomValue = this.bank.myNumber.nextInt(3) + 1;

        //random condition to add adverb
        if ( randomValue == 2  && adjectivePresent )
        this.buildAdverbPhrase();
		
		this.myConstituents.addFirst( buildDeterminer() );

	}
	

	public Determiner buildDeterminer()
	{
		LinkedList<Word> controller = this.daughterPhrase.myConstituents;
		
		if ( controller.getLast().getContent().substring( controller.getLast().getContent().length() - 1, controller.getLast().getContent().length()).equals( "s" ))
		{
			return new Determiner( "the" );
		}
		
		for ( int i = 0; i < vowels.length; ++i )
		{
			if ( controller.getFirst().getContent().substring( 0, 1 ).equals( this.vowels[i] ))
			{
				return new Determiner( "an" );
			}
			
		}
		
		return new Determiner( "a" );
		
	}
	
	public void buildNounPhrase()
	{
		this.daughterPhrase = new Constituents();

		this.daughterPhrase.myConstituents.addFirst( buildNoun() );
	}

	public Noun buildNoun()
	{
	    Noun value = (Noun)bank.findAWord( new Noun("" ));
	    int rand = this.bank.myNumber.nextInt(4) + 1;

	    if ( rand == 1)
        {
            value.makePlural();
        }
		return value;
	}

    public void buildAdjectivePhrase()
    {
        this.daughterPhrase.myConstituents.addFirst( buildAdjective() );
    }

    public Adjective buildAdjective()
    {
        Adjective value = (Adjective) bank.findAWord( new Adjective("" ));
        return value;
    }

    public void buildAdverbPhrase()
    {
        this.daughterPhrase.myConstituents.addFirst( buildAdverb() );
    }

    public Adverb buildAdverb()
    {
        Adverb value = (Adverb) bank.findAWord( new Adverb("" ));
        return value;
    }
	
	public String getTypeOfPhrase()
	{
		return this.typeOfPhrase;
	}
	
	public void setTypeOfPhrase( String typeOfPhrase )
	{
		this.typeOfPhrase = typeOfPhrase;
	}
	
	
	public void getMyConstituents()
	{
		for ( int i = 0; i < this.myConstituents.size(); ++i )
		{
			System.out.print( this.myConstituents.get(i).getContent() + " " );
		}
		
		if ( this.daughterPhrase != null )
			this.daughterPhrase.getMyConstituents();
			
			
	}
		
	
	
	
	
	
	
	/*
	 * ideas:
	 * fields:
	 * Linked List of type Word
	 * string to determine phrase type
	 * methods:
	 * get type of phrase
	 * get constituent phrase?
	 * tag phrase as type( takes string as type parameter )
	 * */
	 
	
	
	
	
	
	
}
