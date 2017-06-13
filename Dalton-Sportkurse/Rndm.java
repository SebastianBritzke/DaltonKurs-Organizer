import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rndm
{
    int plätze= 3;
    int array;
    public Rndm()
    {
    }

     void main (int anzahlSchüler)
    { 
        System.out.println(Arrays.toString(createArray(anzahlSchüler)));
        List<Integer> list = Arrays.asList();
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);      
    }

    int[] createArray(int n)
    {
        int[] array = new int[n];
        for(int i = 1; i<=n; i++)
        {
            array[i-1] = i;         
        }
        return array;
    }

    private void testFull(int...numbers) 
    {
        System.out.println(Arrays.toString(numbers));
        if(numbers.length<plätze)
        {
            System.out.println("Der Kurs ist mit "+numbers.length+" von "+plätze+" Plätzen belegt.");
            System.out.println("Es ist noch platz.");
        }
        if(numbers.length>=plätze)
        {
            System.out.println("Der Kurs ist mit "+numbers.length+" von "+plätze+" Plätzen belegt.");
            System.out.println("Er ist zu voll.");
        }
    }

}
