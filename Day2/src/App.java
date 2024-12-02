import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new FileReader(".\\AdventOfCode2024\\Day2\\src\\Test\\test2.txt"));
        int rez1 =0;
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
                }
            }
        }
        System.out.println("Answer 1: "+rez1);
        br = new BufferedReader (new FileReader(".\\AdventOfCode2024\\Day2\\src\\Test\\test1.txt"));
        int rez2 =0;
        while(br.ready()){
            String line = br.readLine();
            String[] split = line.split(" ");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                list.add(Integer.parseInt(split[i]));
            }
            list.sort(Comparator.naturalOrder());
            boolean remove = false;
            boolean bra = false;
            for (int i = 1; i <list.size(); i++) {
                if(3+list.get(i-1)>=list.get(i)){}
                else{
                    if(remove){
                        bra=true;
                        break;
                    }
                    remove=true;
                    list.remove(i);
                }
            }
            if(!bra){
                rez2++;
                continue;
            }
            list = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                list.add(Integer.parseInt(split[i]));
            }
            list.sort(Comparator.reverseOrder());
            bra=false;
            remove=false;
            for (int i = 1; i <list.size(); i++) {
                if(3+list.get(i)>=list.get(i-1)){}
                else{
                    if(remove){
                        bra=true;
                        break;
                    }
                    remove=true;
                    list.remove(i);
                }
            }
            if(!bra){
                rez2++;
                continue;
            }
        }
        System.out.println("Answer 2: "+rez2);
    }
}
