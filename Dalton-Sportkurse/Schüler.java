
public class Schüler extends  Zuweisung{

    String nachname;
    //int Jahrgangsstufe;
    static String Erstwunsch;
    String Zweitwunsch;
    String Drittwunsch;
    static Kurse endkurs;
    static int id;

    public Schüler (int  schülerid,String lname,String Erst)
    {
        id = schülerid;
        nachname = lname;
        Erstwunsch = Erst;
        //Zweitwunsch = Zweit;
        //Drittwunsch = Dritt;
    }
    //  public static void main(String[] args) {
    //      
    //      Schüler sw = new Schüler("Volleyball","Fußball","Tischtennis");
    //      System.out.println(sw.getFW());
    // 
    //  }

    static String getFW()
    {
        return Erstwunsch;
    }
    
    int getID()
    {
        return id;
    }

}
