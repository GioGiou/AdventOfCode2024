import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader (new FileReader(".\\Day7\\src\\Test\\test2.txt"))) {
            ArrayList<Long> test = new ArrayList<>();
            ArrayList<ArrayList<Long>> data = new ArrayList<>();
            while (br.ready()) {
                String[] line = br.readLine().split(": ");
                test.add(Long.parseLong(line[0]));
                ArrayList<Long> temp = new ArrayList<>();
                for (String integer : line[1].split(" ")) {
                    temp.add(Long.parseLong(integer));
                }
                data.add(temp);
            }
            long rez1 =0;
            for (int i =0;i<test.size();i++){
                long target = test.get(i);
                if (findTarget(data.get(i),target,1,data.get(i).get(0))){
                    rez1=rez1+target;
                    System.out.println(target);                
                }
            }
            System.out.println("Answer 1: "+rez1);
        } catch (IOException e) {           
            e.printStackTrace();
        }
        
    }

    private static boolean findTarget(ArrayList<Long> arrayList, long target, int last,long acum) {
        if(last>=arrayList.size()){
            return target == acum;
        
        }
        boolean plus = findTarget(arrayList,target,last+1,acum+arrayList.get(last));
        if(plus){
            return plus;
        }
        boolean mult = findTarget(arrayList,target,last+1,acum*arrayList.get(last));
        if(mult){
            return mult;
        }
        long newAcum = Long.parseLong(acum+""+arrayList.get(last));
        return findTarget(arrayList,target,last+1,newAcum);

    }
}
