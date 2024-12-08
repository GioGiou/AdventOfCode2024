import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader (new FileReader(".\\Day8\\src\\Test\\test2.txt"))){
            HashMap<String,ArrayList<int[]>> data = new HashMap<>();
            int i =0;
            int j =0;
            while (br.ready()) {
                j =0;
                for (String c : br.readLine().split("")) {
                    if(!c.equals(".")) {
                        if (data.keySet().contains(c)){
                            ArrayList<int[]> temp = data.get(c);
                            temp.add(new int[]{i,j});
                            data.put(c,temp);
                        }
                        else{
                            ArrayList<int[]> temp = new ArrayList<>();
                            temp.add(new int[]{i,j});
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
            HashSet<int[]> rez = new HashSet<>();
            for (String key : data.keySet()) {
                ArrayList<int[]> antena = data.get(key);
                for ( int[] loc: antena) {
                    for ( int[] loc2: antena) {
                        if(!loc.equals(loc2)){
                            int x=loc[0]-loc2[0];
                            int y=loc[1]-loc2[1];
                            x = x + loc[0];
                            y= y + loc[1];

                            if(x>=0 && x <i&& y>=0 &&y<j){
                                boolean add = true;
                                for (int[] ks : rez) {
                                     if(ks[0]==x && ks[1]==y){
                                        add = false;
                                     }
                                }
                                if(add){
                                    rez.add(new int[]{x,y});
                                    
                                    System.out.println(x+", "+y);
                                }
                                rez1++;
                            }
                        }
                    }
                }

            }
            System.out.println("Answer 1: "+rez1+", set " + rez.size());


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
