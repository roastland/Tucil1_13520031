import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Operations ops = new Operations();
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan nama file ");
        String filename = input.nextLine();
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
        Matrix puzzle;      
        String[] keyword;   
        int rows=0, cols=0; 

        // mencari index baris pembatas matriks puzzle dan list word
        int idx = 0;
        while (def[idx] != "") {
            idx++;
        }
        
        // mengisi matriks puzzle
        rows = idx;
        cols = def[0].split(" ").length;
        puzzle = new Matrix(rows, cols);
        for(int i = 0; i < rows; i++){
            String[] temp = def[i].split(" ");
            for(int j = 0; j < cols;j++){
                puzzle.M[i][j] = temp[j].charAt(0);
            }
        }

        // mengisi list word
        int n = def.length - 1 - idx;
        keyword = new String[n];
        int k = 0;
        for (int i = idx+1; i < def.length; i++) {
            keyword[k] = def[i];
            k++;
        }

        // menjalankan word search tiap keyword
        for (int i = 0; i < n; i++) {
            int rPivot=0, cPivot=0;
            String findNow = keyword[i];
            //System.out.println(keyword[i]);
            boolean wordFound = false;
            //int tes=0;
            while ((rPivot < puzzle.rows) && (cPivot < puzzle.cols) && (!wordFound)) {
                /*tes++;
                //System.out.println("test\n");
                int asc = (int) puzzle.M[rPivot][cPivot];
                int asc2 = (int) findNow.charAt(0);
                System.out.println(asc);
                System.out.println(asc2);
                System.out.println();*/
                if (puzzle.M[rPivot][cPivot] == findNow.charAt(0)) {
                    //System.out.println("test\n");
                    if (ops.checkEast(puzzle, findNow, rPivot, cPivot)) {
                        //System.out.println("test\n");
                        ops.printEast(puzzle, findNow, rPivot, cPivot);
                        wordFound = true;
                    } else if (ops.checkSouthEast(puzzle, findNow, rPivot, cPivot)) {
                        ops.printSouthEast(puzzle, findNow, rPivot, cPivot);
                        wordFound = true;
                    } else if (ops.checkSouth(puzzle, findNow, rPivot, cPivot)) {
                        ops.printSouth(puzzle, findNow, rPivot, cPivot);
                        wordFound = true;
                    } else if (ops.checkSouthWest(puzzle, findNow, rPivot, cPivot)) {
                        ops.printSouthWest(puzzle, findNow, rPivot, cPivot);
                        wordFound = true;
                    } else if (ops.checkWest(puzzle, findNow, rPivot, cPivot)) {
                        ops.printWest(puzzle, findNow, rPivot, cPivot);
                        wordFound = true;
                    } else if (ops.checkNorthWest(puzzle, findNow, rPivot, cPivot)) {
                        ops.printNorthWest(puzzle, findNow, rPivot, cPivot);
                        wordFound = true;
                    } else if (ops.checkNorth(puzzle, findNow, rPivot, cPivot)) {
                        ops.printNorth(puzzle, findNow, rPivot, cPivot);
                        wordFound = true;
                    } else if (ops.checkNorthEast(puzzle, findNow, rPivot, cPivot)) {
                        ops.printNorthEast(puzzle, findNow, rPivot, cPivot);
                        wordFound = true;
                    } else {
                        if (cPivot == cols-1) {
                            cPivot = 0;
                            rPivot++;
                        } else {
                            cPivot++;
                        }
                    }
                }
                else {
                    if (cPivot == cols-1) {
                        cPivot = 0;
                        rPivot++;
                    } else {
                        cPivot++;
                    }
                }
            }
            //System.out.println(tes);
        }
        //System.out.println(keyword[8]);
        input.close();
    }
}
