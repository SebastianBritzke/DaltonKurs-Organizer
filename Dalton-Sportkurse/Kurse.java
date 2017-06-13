
public class Kurse extends Zuweisung{

    static int plätze;
    static String name;
    private static int i;
    static Schüler endschüler;

    public Kurse(int pl,String n) 
    {
        plätze = pl;
        name = n;
    }
    // 	public static void main(String[] args) {
    // 		
    // 		addKurs(22,"Fußball");
    // 		addKurs(15,"Volleyball");
    // 		addKurs(13,"Tischtennis");
    // 		//System.out.println(kurs.getPlätze());
    // 		//currentKurs(kurs[i]);
    // 
    // 	}
    static int getPlätze()
    {
        return plätze;
    }

    static void addKurs(int pl,String n)
    {
        Kurse[] kurs = new Kurse [5];
        for(i = 0; i<1; i++)
        {
            kurs[i] = new Kurse(pl,n);
            System.out.println(kurs[i].getPlätze());
        }
    }		 
}
