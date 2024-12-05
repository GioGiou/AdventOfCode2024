import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new FileReader(".\\Day5\\src\\Test\\test2.txt"));
        String line = br.readLine();
        HashSet<String> page = new HashSet<>();
        while (line!=null && !line.equals("")) {
            page.add(line);
            line = br.readLine();
            System.out.println(line);
        }
        int rez1= 0;
        int rez2= 0;
        while (br.ready()) {
            line = br.readLine();
            String[] nums = line.split(",");
            int[] numbers = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                numbers[i]=Integer.parseInt(nums[i]);
            }
            boolean flage = true;
            for (int i = 0; i < nums.length-1; i++) {
                for (int j = i+1;j < nums.length; j++) {
                    if(page.contains(nums[i]+"|"+nums[j])){}
                    else{
                        flage = false;
                    }
                }
            }
            if (flage){
                rez1 = rez1 + numbers[numbers.length/2];
                continue;
            }
            for (int i = 0; i < numbers.length-1; i++) {
                for (int j = i+1;j < numbers.length; j++) {
                    if(page.contains(numbers[i]+"|"+numbers[j])){}
                    else{
                        int tmp = numbers[i];
                        numbers[i]=numbers[j];
                        numbers[j]=tmp;
                    }
                    
                }
            }
            rez2 = rez2 + numbers[numbers.length/2];
            
        }
        System.out.println("Answer 1: "+rez1);
        System.out.println("Answer 2: "+rez2);
        br.close();
    }
}
