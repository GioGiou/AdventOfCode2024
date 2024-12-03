import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader (new FileReader(".\\Day3\\src\\Test\\test2.txt"));
        String line = "";
        while (br.ready()) {
            line = line + br.readLine();
        }
        Pattern r = Pattern.compile("(mul\\([0-9]{1,3},[0-9]{1,3}\\))");

        Matcher m = r.matcher(line);
        int rez1= 0;
        while(m.find()){
            String temp = m.group();
            String [] nums = temp.split(",");
            int prvi = Integer.parseInt(nums[0].subSequence(4, nums[0].length()).toString());
            int drugi = Integer.parseInt(nums[1].replaceAll("\\)",""));
            rez1=rez1 + prvi*drugi;
        }
        System.out.println("Answer 1: "+rez1);
        int rez2 = 0;
        String[] check = line.split("(don't\\(\\).*?do\\(\\))");
        for (int i =0; i< check.length-1;i++){
            m=r.matcher(check[i]);
            while(m.find()){
                String temp = m.group();
                String [] nums = temp.split(",");
                int prvi = Integer.parseInt(nums[0].subSequence(4, nums[0].length()).toString());
                int drugi = Integer.parseInt(nums[1].replaceAll("\\)",""));
                rez2=rez2 + prvi*drugi;
            }
        }
        m=r.matcher(check[check.length-1].replaceAll("(don't.*?)", ""));
        while(m.find()){
            String temp = m.group();
            String [] nums = temp.split(",");
            int prvi = Integer.parseInt(nums[0].subSequence(4, nums[0].length()).toString());
            int drugi = Integer.parseInt(nums[1].replaceAll("\\)",""));
            rez2=rez2 + prvi*drugi;
        }
        System.out.println("Answer 2: "+rez2);
    }
}
