import java.io.*;
import java.util.LinkedList;
import java.util.Random;


public class BankWarden {

    //member fields
    protected Random myNumber;
    protected LinkedList<LinkedList<Word>> bank;

    //constructor
    public BankWarden() {


        this.instatiateLists();
        this.generateList();
        myNumber = new Random();
    }


    public void generateList() {


        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        LinkedList<LinkedList<Word>> fullBank = this.bank;


        try {
            fileReader = new FileReader("words.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line;
            boolean finished = false;
            int count = 0;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty())
                    ++count;

                else
                    fillListSetup(fullBank.get(count), line, count);
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

    }

    public static void fillListSetup(LinkedList<Word> subBank, String line, int count) {

        if (count == 0) {
            subBank.add(new Noun(line));
        } else if (count == 1) {
            subBank.add(new Verb(line));
        } else if (count == 2) {
            subBank.add(new Adjective(line));
        } else if (count == 3) {
            subBank.add(new Adverb(line));
        }
    }

    public void printList() {
        for (int i = 0; i < this.bank.size(); ++i) {
            if (i == 0)
                System.out.println("\nNouns:");

            if (i == 1)
                System.out.println("\nVerbs:");

            if (i == 2)
                System.out.println("\nAdjectives:");

            if (i == 3)
                System.out.println("\nAdverbs:");

            printListEngine(this.bank.get(i));
        }
    }

    public static void printListEngine(LinkedList<Word> bank) {
        for (int i = 0; i < bank.size(); ++i) {
            System.out.println(bank.get(i).getContent());
        }
    }

    public void instatiateLists() {
        bank = new LinkedList<LinkedList<Word>>();

        for (int i = 0; i < 4; ++i)
            this.bank.add(new LinkedList<Word>());
    }

    public Word findAWord(Word typeOfWord) {

        LinkedList<Word> individualBank;

        if (typeOfWord instanceof Noun )
        {
            individualBank = this.bank.get( 0 );
            return individualBank.get( this.getRandomNumber() );
        }

        else if ( typeOfWord instanceof Verb )
        {
            individualBank = this.bank.get( 1 );
            return individualBank.get( this.getRandomNumber() );
        }

        else if ( typeOfWord instanceof Adjective )
        {
            individualBank = this.bank.get( 2 );
            return individualBank.get( this.getRandomNumber() );
        }

        else if ( typeOfWord instanceof Adverb )
        {
            individualBank = this.bank.get( 3 );
            return individualBank.get( this.getRandomNumber() );
        }

        return null;
    }

    public int getRandomNumber()
    {
        int value = myNumber.nextInt(9 ) + 1;
        return value;
    }


}
