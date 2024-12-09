import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader (new FileReader(".\\Day9\\src\\Test\\test2.txt"))){
            int[] data = Arrays.stream(br.readLine().split("")).mapToInt(c->Integer.parseInt(c)).toArray();
            int sum = Arrays.stream(data).reduce(0,Integer::sum);
            int[] input= new int[sum];
            boolean space = false;
            int num = 0;
            int next=0;
            for (int i = 0; i < data.length; i++) {
                if (space) {
                    for(int j=0;j<data[i];j++){
                        input[next]=-1;
                        next++;
                    }
                }
                else{
                    for(int j=0;j<data[i];j++){
                        input[next]=num;
                        next++;
                    }
                    num++;
                }
                
                space = !space;
            }
            num--;
            System.out.println(input);
            int i=0;
            int j = sum-1;
            while (i<j) {
                System.out.println(input.length+","+ i+","+j);
                while (-1 != input[i]) {
                    i++;
                }
                while (-1==input[j]) {
                    j--;
                }
                if(i>=j){
                    break;
                }
                int temp = input[i];
                input[i]=input[j];
                input[j]=-1;
            }
            i=0;
            long rez1 =0;
            while (-1!=input[i]) {
                rez1 = rez1 + i*input[i];
                i++;
                System.out.println(rez1);
            }
            System.out.println("Answer 1: "+rez1);
            System.err.println(num);

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
