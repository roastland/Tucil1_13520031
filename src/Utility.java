import java.io.*;
import java.util.*;

public class Utility {
    String[] puzzle;  // array untuk puzzle
    String[][] M;   // matriks puzzle
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
        int emptyLine = 0;

        while (def[emptyLine] != "") {
            this.puzzle[emptyLine] = def[emptyLine];
            emptyLine++;
        }
        
        this.rows = puzzle.length;
        this.cols = puzzle[0].split(" ").length;
        this.M = new String[rows][cols];
        for(int i = 0; i < rows; i++){
            String[] temp = puzzle[i].split(" ");
            for(int j = 0; j <cols;j++){
                M[i][j] = temp[j];
            }
        }

        for (int idx = emptyLine+1; idx < def.length; idx++) {
            keyword[idx][0] = def[idx];
            keyword[idx][1] = "notFound";
        }

        for (int idx2 = 0; idx2 < keyword.length; idx2++) {
            System.out.println(keyword[idx2][0]);
            System.out.println(keyword[idx2][1]);
        }
    }
}