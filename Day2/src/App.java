import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new FileReader(".\\AdventOfCode2024\\Day2\\src\\Test\\test2.txt"));
        int rez1 =0;
        int rez2 =0;
        while(br.ready()){
            String line = br.readLine();
            String[] split = line.split(" ");
            int[] nums = new int[split.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i]=Integer.parseInt(split[i]);
            }
            if(nums[0]>nums[1]&&nums[0]<=3+nums[1]){
                boolean flag = true;
                for (int j = 1; j < nums.length; j++) {
                    if(!(nums[j-1]>nums[j]&&nums[j-1]<=3+nums[j])){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    rez1++;
                    continue;
                }
            }
            if(nums[0]<nums[1]&&nums[1]<=3+nums[0]){
                boolean flag = true;
                for (int j = 1; j < nums.length; j++) {
                    if(!(nums[j-1]<nums[j]&&nums[j]<=3+nums[j-1])){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    rez1++;
                    continue;
                }
                
            }
            boolean bra=false;
            System.out.print(line);
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list =Arrays.stream(nums).boxed() .collect(Collectors.toList());
                list.remove(i);
                if(list.get(0)>list.get(1)&&list.get(0)<=3+list.get(1)){
                    boolean flag = true;
                    for (int j = 1; j < list.size(); j++) {
                        if(!(list.get(j-1)>list.get(j)&&list.get(j-1)<=3+list.get(j))){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        rez2++;
                        bra = true;
                        System.out.println(" --");
                    }
                }
                if(bra) break;
                if(list.get(0)<list.get(1)&&list.get(1)<=3+list.get(0)){
                    boolean flag = true;
                    for (int j = 1; j < list.size(); j++) {
                        if(!(list.get(j-1)<list.get(j)&&list.get(j)<=3+list.get(j-1))){
                            flag=false;
                        }
                    }
                    if(flag){
                        System.out.println(" --");
                        rez2++;
                        bra = true;
                    }
                    
                }
                if(bra) break;                
            }
            System.out.println();

        }
        System.out.println("Answer 1: "+rez1);
        
        System.out.println("Answer 2: "+(rez2+rez1));
    }
}
