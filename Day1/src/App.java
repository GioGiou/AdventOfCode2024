import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

record Pair(int left, int right){}

void main() throws IOException{
    BufferedReader br = new BufferedReader (new FileReader(".\\AdventOfCode2024\\Day1\\src\\Test\\test2.txt"));
    List<Integer> left = new ArrayList<Integer>();
    List<Integer> right = new ArrayList<Integer>();
    
    while(br.ready()){
        String line = br.readLine();
        String[] nums = line.split("   ");
        left.add(Integer.parseInt(nums[0]));
        right.add(Integer.parseInt(nums[1]));
    }
    Collections.sort(left);
    Collections.sort(right);

    List<Pair> pair = new ArrayList<>();
    for(int i =0;i<left.size();i++){
        pair.add(new Pair(left.get(i), right.get(i)));
    }

    int rez1 = pair.stream().mapToInt(s ->Math.abs(s.left-s.right)).sum();
    System.out.println("Answer 1: " + rez1);

    long rez2 = 0;
    for (int i: left) {
        long a = right.stream().filter(r->r==i).count();
        rez2 = rez2 + a*i;        
    }
    System.out.println("Answer 2: " + rez2);
}
