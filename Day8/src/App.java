import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class App {
    public record Coordinate(int x, int y) {}
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader (new FileReader(".\\Day8\\src\\Test\\test2.txt"))){
            HashMap<String,ArrayList<Coordinate>> data = new HashMap<>();
            int i =0;
            int j =0;
            while (br.ready()) {
                j =0;
                for (String c : br.readLine().split("")) {
                    if(!c.equals(".")) {
                        if (data.keySet().contains(c)){
                            ArrayList<Coordinate> temp = data.get(c);
                            temp.add(new Coordinate(i, j));
                            data.put(c,temp);
                        }
                        else{
                            ArrayList<Coordinate> temp = new ArrayList<>();
                            temp.add(new Coordinate(i, j));
                            data.put(c,temp);
                        }
                        System.out.println(i+", "+j);
                    }
                    j++;
                }
            i++;   
            }
            System.out.println("size: "+i + ", "+j);
            int rez1 = 0;
            int rez2 = 0;
            HashSet<Coordinate> rez = new HashSet<>();
            HashSet<Coordinate> rezp2 = new HashSet<>();
            for (String key : data.keySet()) {
                ArrayList<Coordinate> antena = data.get(key);                
                for ( Coordinate loc: antena) {
                    for (Coordinate loc2: antena) {
                        if(!loc.equals(loc2)){
                            int x=loc.x()-loc2.x();
                            int y=loc.y()-loc2.y();
                            int ax = x + loc.x();
                            int ay= y + loc.y();
                            Coordinate anti  =  new Coordinate(ax, ay);
                            if(anti.x()>=0 && anti.x() <i&& anti.y()>=0 &&anti.y()<j){
                                rez.add(anti);
                                rez1++;
                            }
                            int k=0;
                            anti  =  new Coordinate(k*x+loc.x(), k*y+loc.y());
                            while(anti.x()>=0 && anti.x() <i&& anti.y() >=0 && anti.y()<j){                                
                                rezp2.add(anti);
                                rez2++;
                                k++;
                                anti  =  new Coordinate(k*x+loc.x(), k*y+loc.y());
                            }
                        }
                    }
                }

            }
            System.out.println("Answer 1: "+rez1+", set " + rez.size());
            System.out.println("Answer 2: "+rez2+", set " + rezp2.size());


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
