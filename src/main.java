import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Utility util = new Utility();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Masukkan nama file ");
        String filename = input.nextLine();
        util.inputPuzzle(filename);
    }
}
