import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class App {
    static List<String> newData;
    static Map<String,Long> newDataMap;
    
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader(".\\Day11\\src\\Test\\test2.txt"))) {
            String[] line = br.readLine().split(" ");
            List<String> data = Collections.synchronizedList(new LinkedList<>());
            Map<String,Long> dataMap = new HashMap<>();
            for (int i = 0; i < line.length; i++) {
                data.add(line[i]);
                if(dataMap.containsKey(line[i])){
                    long temp = dataMap.get(line[i]);
                    dataMap.put(line[i], temp+1);
                }
                else{
                    dataMap.put(line[i], 1l);
                }
            }
            //Part 1
            for (int x = 0; x < 25; x++) {
                newData = Collections.synchronizedList(new LinkedList<>());
                for (String stone : data) {
                    if(Long.parseLong(stone)==0){
                        newData.add( "1");
                    }
                    else if(stone.length()%2==0){
                        int half=stone.length()/2;
                        String left = Long.parseLong(stone.substring(0,half))+"";
                        String right = Long.parseLong(stone.substring(half))+"";
                        newData.add(left);
                        newData.add(right);
                    }
                    else{
                        long temp = Long.parseLong(stone);
                        String added = ""+(temp*2024);
                        newData.add(added);
                    }
                }
                data = newData;
                newData=null;
                System.out.println(x+". Size="+data.size());
            }
            //Part2
            for (int x = 1; x <= 75 ; x++) {
                newDataMap = new HashMap<>();
                for (Map.Entry<String, Long> map: dataMap.entrySet()) {                
                    String stone = map.getKey();
                    long numb = map.getValue();
                    if(Long.parseLong(stone)==0){
                        if(newDataMap.containsKey("1")){
                            long temp = newDataMap.get("1");
                            newDataMap.put("1", temp+numb);
                        }
                        else{
                            newDataMap.put("1", numb);
                        }
                    }
                    else if(stone.length()%2==0){
                        int half=stone.length()/2;
                        String left = Long.parseLong(stone.substring(0,half))+"";
                        String right = Long.parseLong(stone.substring(half))+"";
                        if(newDataMap.containsKey(left)){
                            Long temp = newDataMap.get(left);
                            newDataMap.put(left, temp+numb);
                        }
                        else{
                            newDataMap.put(left, numb);
                        }
                        if(newDataMap.containsKey(right)){
                            Long temp = newDataMap.get(right);
                            newDataMap.put(right, temp+numb);
                        }
                        else{
                            newDataMap.put(right, numb);
                        }
                    }
                    else{
                        long temp = Long.parseLong(stone);
                        String added = ""+(temp*2024);
                        if(newDataMap.containsKey(added)){
                            long temp1 = newDataMap.get(added);
                            newDataMap.put(added, temp1+numb);
                        }
                        else{
                            newDataMap.put(added, numb);
                        }
                    }
                }
                dataMap = newDataMap;
                newDataMap=null;
                
                long rez =0;
                for (Map.Entry<String, Long> map: dataMap.entrySet()) {
                    rez = rez + map.getValue(); 
                }
                System.out.println(x+". Size="+dataMap.size()+", Total="+rez);
            }

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
