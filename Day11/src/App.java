import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static int[] ret;
    
    static class Run implements Runnable{
        String stone;
        int i;
        Run(String stone, int i){
            this.stone=stone;
            this.i = i;
        }
        @Override
        public void run() {
            ArrayList<String> Data = new ArrayList<>();
            Data.add(stone);
            for (int x = 0; x < 43; x++) {
                System.out.println(i+" je na "+x+ " in ima velikost "+Data.size());
                ArrayList<String> newData = new ArrayList<>();
                for (int j = 0; j < Data.size(); j++) {
                    
                    if(Long.parseLong(Data.get(j))==0){
                        newData.add(j, "1");
                    }
                    else if(Data.get(j).length()%2==0){
                        int half=Data.get(j).length()/2;
                        String left = Long.parseLong(Data.get(j).substring(0,half))+"";
                        String right = Long.parseLong(Data.get(j).substring(half))+"";
                        newData.add(left);
                        newData.add(right);
                    }
                    else{
                        long temp = Long.parseLong(Data.get(j));
                        String added = ""+(temp*2024);
                        newData.add(added);
                    }
                }
                Data = newData;
                newData=null;

            }

            App.ret[i]=Data.size();
        }
    }
    
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader(".\\Day11\\src\\Test\\test2.txt"))) {
            String[] line = br.readLine().split(" ");
            ArrayList<String> data = new ArrayList<>();
            for (int i = 0; i < line.length; i++) {
                data.add(line[i]);
            }
            //Part 1
            for (int x = 0; x < 32; x++) {
                ArrayList<String> newData = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    if(Long.parseLong(data.get(i))==0){
                        newData.add(i, "1");
                    }
                    else if(data.get(i).length()%2==0){
                        int half=data.get(i).length()/2;
                        String left = Long.parseLong(data.get(i).substring(0,half))+"";
                        String right = Long.parseLong(data.get(i).substring(half))+"";
                        newData.add(left);
                        newData.add(right);
                    }
                    else{
                        long temp = Long.parseLong(data.get(i));
                        String added = ""+(temp*2024);
                        newData.add(added);
                    }
                }
                data = newData;
                newData=null;
                System.out.println(x+". Size="+data.size());
            }
            //Part2
            try (ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
                Future<?>[] t = new Future[data.size()];
                ret = new int[data.size()];
                for (int i = 0; i < data.size(); i++) {
                    t[i] = myExecutor.submit(new Run(data.get(i),i));
                }
                long rez2 = 0;
                for (int i = 0; i < line.length; i++) {
                    t[i].get();
                    rez2 = rez2 + ret[i];
                }
                System.out.println("Answer 2: "+rez2);
            }
            catch (Exception e){
                e.printStackTrace();
            }

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
