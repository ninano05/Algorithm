import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.write("\\    /\\\n");
        bw.write(" )  ( \')\n");
        bw.write("(  /  )\n");
        bw.write(" \\(__)|\n");
                 
        bw.flush();
        bw.close();
    }
}