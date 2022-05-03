import java.util.ArrayList;

public class Aramkor {

    private ArrayList<Alkatresz> alkatreszek = new ArrayList<>();


    public void add(Alkatresz alkatresz){
        alkatreszek.add(alkatresz);
    }

    public void remove(Alkatresz alkatresz){
        for(Alkatresz alkat: alkatreszek){
            if(alkat.equals(alkatresz)){
                alkatreszek.remove(alkatresz);
            }
        }
    }

    public ArrayList<Alkatresz> getAlkatreszek() {
        return alkatreszek;
    }

    public int getAlkatreszekSzama(){
        return alkatreszek.size();
    }

    public double getAlkatreszekOsszara(){
        double sum = 0;
        for(Alkatresz alkatresz: alkatreszek){
            sum+=alkatresz.getPrice();
        }
        return sum;
    }
}
