import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new FileReader(".\\Day4\\src\\Test\\test1.txt"));
        ArrayList<String> lines = new ArrayList<>();
        int i =0;
        int rez1 =0;
        while (br.ready()) {
            String line =br.readLine();
            lines.add(i,line);
            int index = line.indexOf("XMAS");

            while (index !=-1){
                if(index+4> line.length()){break;}
                rez1++;
                index=line.indexOf("XMAS",index+4);
            }
            index = line.indexOf("SAMX");

            while (index !=-1){
                rez1++;
                if(index+4> line.length()){break;}
                index=line.indexOf("SAMX",index+4);
            }
            i++;
        }
        for (int j = 0; j < lines.size()-3; j++) {
            for (int k = 0; k < lines.get(j).length(); k++) {
                if(lines.get(j).charAt(k)=='X' && lines.get(j+1).charAt(k)=='M'
                && lines.get(j+2).charAt(k)=='A' && lines.get(j+3).charAt(k)=='S'){
                    System.out.println(j);
                    rez1++;
                }
                if(lines.get(j).charAt(k)=='S' && lines.get(j+1).charAt(k)=='A'
                && lines.get(j+2).charAt(k)=='M' && lines.get(j+3).charAt(k)=='X'){
                    System.out.println(j);
                    rez1++;
                }
            }
        }

        for (int j = 0; j < lines.size()-3; j++) {
            for (int k = 0; k < lines.get(j).length()-3; k++) {
                if(lines.get(j).charAt(k)=='X' && lines.get(j+1).charAt(k+1)=='M'
                && lines.get(j+2).charAt(k+2)=='A' && lines.get(j+3).charAt(k+3)=='S'){
                    System.out.println(j);
                    rez1++;
                }
                if(lines.get(j).charAt(k)=='S' && lines.get(j+1).charAt(k+1)=='A'
                && lines.get(j+2).charAt(k+2)=='M' && lines.get(j+3).charAt(k+3)=='X'){
                    System.out.println(j);
                    rez1++;
                }
            }
        }

        for (int j = 0; j < lines.size()-3; j++) {
            for (int k = lines.get(j).length()-1; k >=3; k--) {
                if(lines.get(j).charAt(k)=='X' && lines.get(j+1).charAt(k-1)=='M'
                && lines.get(j+2).charAt(k-2)=='A' && lines.get(j+3).charAt(k-3)=='S'){
                    System.out.println(j);
                    rez1++;
                }
                if(lines.get(j).charAt(k)=='S' && lines.get(j+1).charAt(k-1)=='A'
                && lines.get(j+2).charAt(k-2)=='M' && lines.get(j+3).charAt(k-3)=='X'){
                    System.out.println(j);
                    rez1++;
                }
            }
        }

        System.out.println("Answer 1: "+rez1);

        int rez2=0;

        for (int j = 1; j < lines.size()-1; j++) {
            for (int k = 1; k <lines.get(j).length()-1; k++) {
                if(lines.get(j).charAt(k)=='A'){
                    if(lines.get(j-1).charAt(k-1)=='M'&&lines.get(j-1).charAt(k+1)=='M' &&
                    lines.get(j+1).charAt(k-1)=='S'&&lines.get(j+1).charAt(k+1)=='S'){
                        rez2++;
                    }
                    if(lines.get(j-1).charAt(k-1)=='S'&&lines.get(j-1).charAt(k+1)=='M' &&
                    lines.get(j+1).charAt(k-1)=='S'&&lines.get(j+1).charAt(k+1)=='M'){
                        rez2++;
                    }
                    if(lines.get(j-1).charAt(k-1)=='S'&&lines.get(j-1).charAt(k+1)=='S' &&
                    lines.get(j+1).charAt(k-1)=='M'&&lines.get(j+1).charAt(k+1)=='M'){
                        rez2++;
                    }
                    if(lines.get(j-1).charAt(k-1)=='M'&&lines.get(j-1).charAt(k+1)=='S' &&
                    lines.get(j+1).charAt(k-1)=='M'&&lines.get(j+1).charAt(k+1)=='S'){
                        rez2++;
                    }
                }
            }
        }
        System.out.println("Answer 2: "+rez2);
        br.close();
    }
}
