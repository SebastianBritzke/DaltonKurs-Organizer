import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Alg
{
    ArrayList<String> list;
    List out;
    Object obj;
    public Alg()
    {
        list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
    }
    void createArray(String schüler){
        list.add(schüler);
    }
    void shuffle(){
        Collections.shuffle(list);
        System.out.println("Output: ");
        for(String str: list){
            System.out.println(str);
        }
    }
    boolean testFull(int länge){
        if(list.size() < länge){
            System.out.println("Die Liste ist noch nicht voll");
            return false;
        }
        else{
            System.out.println("Die Liste ist voll");
            return true;
        }
    }
    void getElements(int i){
        out = list.subList(0, i);
        System.out.println("Unterliste beinhaltet: ");
        for(int a = 0; a < out.size(); a++){
            System.out.println(out.get(a));
        }
    }
    void getRemainingElements(int i){
        int b = 0;
        while(b < i){
            obj = out.remove(0);
            b = b + 1;
        }
        System.out.println(obj + " wurde entfernt.");
        System.out.println("Die Originalliste beinhaltet nun: ");
        for(int a = 0; a < list.size(); a++){
            System.out.println(list.get(a));
        }
    }
}