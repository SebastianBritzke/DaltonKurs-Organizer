import java.util.Random;
import java.util.Arrays;

public class Zuweisung {
    public Zuweisung()
    {

    }
    //     public static void main(String[] args) {
    //         
    //         Kurse.addKurs(15,"Tischtennis");
    //         
    //         //zuweisen("Tischtennis","sw");
    //     }

    static void zuweisen(Kurse k, Schüler zuweisendeS )
    {
        Schüler.endkurs = k;
        Kurse.endschüler = zuweisendeS;
        System.out.println(Kurse.endschüler.getID());
    }

    public void addSchüler(Schüler n){
        Schüler[]schüler = new Schüler [5];
        for(int i=0;i<schüler.length;i++){
            if(schüler[i]==null){
                schüler[i]=n;
                break;
            }
        }
        System.out.println(Arrays.deepToString(schüler));
    }

    void addSchülernew(Schüler n)
    {
        Schüler[]schüler = new Schüler [5];
        for(int i=0;i<schüler.length;i++){
            try
            {
                if (schüler[i]== null)
                {
                    schüler[i].getID();
                }
            }
            catch(Exception e)
            {
                System.out.println("Error");
            }
        }

    }
}