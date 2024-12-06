import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new FileReader(".\\Day6\\src\\Test\\test2.txt"));
        ArrayList<String> data = new ArrayList<>();
        int x=0;
        int y=0;
        int rez1=0;
        boolean f = true;
        while (br.ready()) {
            String line = br.readLine();
            data.add(line);
            if(line.contains("^")){
                y=line.indexOf("^");
                f=false;
            }
            else{
                if(f){x++;}
                
            }
        }
        String position = "UP";
        while(x>=0 && x<data.size() && y>=0 && y<data.get(0).length()){
            System.out.println(data.size());
            switch (position) {
                case "UP":
                    StringBuilder myName = new StringBuilder(data.get(x));
                    myName.setCharAt(y, 'X');
                    data.remove(x);
                    data.add(x, myName.toString());
                    System.out.println("UP "+x+", "+y);
                    if(x==0){
                        x--;
                        break;
                    }
                    if(data.get(x-1).charAt(y)=='#'){
                        position="RIGHT";
                        x++;
                    }
                    x--;
                    
                    
                    break;

                case "DOWN":
                    myName = new StringBuilder(data.get(x));
                    myName.setCharAt(y, 'X');
                    data.remove(x);
                    data.add(x, myName.toString());
                    System.out.println("DOWN "+x+", "+y);
                    if(x==data.size()-1){
                        x++;
                        break;
                    }   
                    if(data.get(x+1).charAt(y)=='#'){
                        position="LEFT";
                        x--;

                    }
                    x++;
                    
                    
                    
                    break;

                case "RIGHT":
                    System.out.println("RIGHT "+x+", "+y);
                    myName = new StringBuilder(data.remove(x));
                    myName.setCharAt(y, 'X');                    
                    data.add(x, myName.toString());
                    if(y==data.get(x).length()-1){
                        y++;
                        break;
                    }   
                    if(data.get(x).charAt(y+1)=='#'){
                        position="DOWN";
                        y--;

                    }
                    y++;
                    
                    
                    break;

                case "LEFT":
                System.out.println("LEFT "+x+", "+y);
                myName = new StringBuilder(data.get(x));
                    myName.setCharAt(y, 'X');
                    data.remove(x);
                    data.add(x, myName.toString());
                    if(y==0){
                        y--;
                        break;
                    }   
                    if(data.get(x).charAt(y-1)=='#'){
                        position="UP";
                        y++;

                    }
                    
                    y--;
                    break;
            
                default:
                    return;
            }
        }
        for (String el : data) {
            for (int i = 0; i < el.length(); i++) {
                if(el.charAt(i)=='X'){
                    rez1++;
                }
            }
        }
        System.out.println("Answer 1: " + rez1);
        br.close();
    }


}
