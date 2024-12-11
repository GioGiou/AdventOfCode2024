import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class App {
    public record Point(int x,int y) {}
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader (new FileReader(".\\Day10\\src\\Test\\test2.txt"))){
            ArrayList<int[]> data =new ArrayList<>();
            HashSet<Point> start = new HashSet<>();
            int x=0;
            while (br.ready()) {
                int[] line = Arrays.stream(br.readLine().split("")).mapToInt(c->Integer.parseInt(c)).toArray();
                for (int i = 0; i < line.length; i++) {
                    if(line[i]==0){
                        start.add(new Point(x, i));
                    }
                }
                data.add(line);
                x++;
            }
            int rez1 = 0;
            for (Point point : start) {
                HashSet<Point> visit = new HashSet<>();
                x = point.x();
                int y = point.y();
                int rez = find(data,x,y,visit);
                System.out.println(rez);
                rez1 = rez1+rez;
            }
            System.out.println("Answer 1: "+ rez1);
            

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private static int find(ArrayList<int[]> data, int x, int y, HashSet<Point> visit) {
        int ret =0;
        if(data.get(x)[y]==9){
            System.out.println(new Point(x, y));
            /*if(visit.contains(new Point(x, y))){
                return 0;
            }*/
            visit.add(new Point(x, y));
            return 1;
        }
        if(x>0){
            if(data.get(x)[y]==data.get(x-1)[y]-1){
                if(data.get(x-1)[y]-1==9){

                }
                ret = ret + find(data, x-1, y,visit);
            }
        }
        if(x<data.size()-1){
            if(data.get(x)[y]==data.get(x+1)[y]-1){
                ret = ret + find(data, x+1, y,visit);
            }
        }
        if(y>0){
            if(data.get(x)[y]==data.get(x)[y-1]-1){
                ret = ret + find(data, x, y-1,visit);
            }
        }
        if(y<data.get(x).length-1){
            if(data.get(x)[y]==data.get(x)[1+y]-1){
                ret = ret + find(data, x, 1+y,visit);
            }
        }
        return ret;
    }
}
