import java.io.*;
import java.util.*;

public class Utility {
    String[][] puzzle;  // matriks puzzle
    String[][] keyword; // array untuk word & boolean found
    int rows=0, cols=0;
    Scanner input = new Scanner(System.in);
    
    public void inputPuzzle(String filename) {
        String text = "";
        try {
            FileReader reader = new FileReader(filename);
            int data = reader.read();
            while(data != -1){
                text += (char) data;
                data = reader.read();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String[] def = text.split("\\r?\\n");   // array default yang menyimpan tiap baris file input
        int idx = 0;

        while (def[idx] != "") {
            idx++;
        }
        
        this.rows = idx;
        this.cols = def[0].split(" ").length;
        this.puzzle = new String[rows][cols];
        for(int i = 0; i < rows; i++){
            String[] temp = def[i].split(" ");
            for(int j = 0; j < cols;j++){
                puzzle[i][j] = temp[j];
            }
        }

        int n = def.length - 1 - idx;
        this.keyword = new String[n][2];
        int k = 0;
        for (int i = idx+1; i < def.length; i++) {
            keyword[k][0] = def[i];
            keyword[k][1] = "notFound";
            k++;
        }
        
    }
}