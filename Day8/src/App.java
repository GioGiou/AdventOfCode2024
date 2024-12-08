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
            int rez2 = 0;
            HashSet<int[]> rez = new HashSet<>();
            HashSet<int[]> rezp2 = new HashSet<>();
            for (String key : data.keySet()) {
                ArrayList<int[]> antena = data.get(key);
                
                for ( int[] loc: antena) {
                    
                    
                    for ( int[] loc2: antena) {
                        if(!loc.equals(loc2)){
                            int x=loc[0]-loc2[0];
                            int y=loc[1]-loc2[1];
                            int ax = x + loc[0];
                            int ay= y + loc[1];

                            if(ax>=0 && ax <i&& ay>=0 &&ay<j){
                                boolean add = true;
                                for (int[] ks : rez) {
                                     if(ks[0]==ax && ks[1]==ay){
                                        add = false;
                                     }
                                }
                                if(add){
                                    rez.add(new int[]{ax,ay});
                                }
                                rez1++;
                            }
                            int k=0; 
                            while (k*x+ loc[0]>=0 && k*x+ loc[0] <i&& k*y+ loc[1]>=0 &&k*y+ loc[1]<j){
                                boolean add = true;
                                for (int[] ks : rezp2) {
                                     if(ks[0]==k*x+ loc[0] && ks[1]==k*y+ loc[1]){
                                        add = false;
                                     }
                                }
                                if(add){
                                    rezp2.add(new int[]{k*x+ loc[0],k*y+ loc[1]});
                                }
                                rez2++;
                                k++;
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
