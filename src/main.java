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
        long startTime = System.nanoTime();
        int compTotal = 0;
        for (int i = 0; i < n; i++) {
            long tempTimeIn = System.nanoTime();
            int rPivot=0, cPivot=0;
            int comp = 0;
            String findNow = keyword[i];
            boolean wordFound = false;
            
            while ((rPivot < puzzle.rows) && (cPivot < puzzle.cols) && (!wordFound)) {
                comp++;
                if (puzzle.M[rPivot][cPivot] == findNow.charAt(0)) {
                    if (ops.checkEast(puzzle, findNow, rPivot, cPivot, comp)) {
                        ops.printEast(puzzle, findNow, rPivot, cPivot);
                        long tempTimeOut = System.nanoTime();
                        long totalTempTime = tempTimeOut - tempTimeIn;
                        System.out.println("Waktu untuk menemukan kata (dalam nanosecond): " + totalTempTime);
                        compTotal += comp;
                        System.out.println("Jumlah perbandingan huruf untuk menemukan kata: " + comp);
                        System.out.println();
                        wordFound = true;
                    } else if (ops.checkSouthEast(puzzle, findNow, rPivot, cPivot, comp)) {
                        ops.printSouthEast(puzzle, findNow, rPivot, cPivot);
                        long tempTimeOut = System.nanoTime();
                        long totalTempTime = tempTimeOut - tempTimeIn;
                        System.out.println("Waktu untuk menemukan kata (dalam nanosecond): " + totalTempTime);
                        compTotal += comp;
                        System.out.println("Jumlah perbandingan huruf untuk menemukan kata: " + comp);
                        System.out.println();
                        wordFound = true;
                    } else if (ops.checkSouth(puzzle, findNow, rPivot, cPivot, comp)) {
                        ops.printSouth(puzzle, findNow, rPivot, cPivot);
                        long tempTimeOut = System.nanoTime();
                        long totalTempTime = tempTimeOut - tempTimeIn;
                        System.out.println("Waktu untuk menemukan kata (dalam nanosecond): " + totalTempTime);
                        compTotal += comp;
                        System.out.println("Jumlah perbandingan huruf untuk menemukan kata: " + comp);
                        System.out.println();
                        wordFound = true;
                    } else if (ops.checkSouthWest(puzzle, findNow, rPivot, cPivot, comp)) {
                        ops.printSouthWest(puzzle, findNow, rPivot, cPivot);
                        long tempTimeOut = System.nanoTime();
                        long totalTempTime = tempTimeOut - tempTimeIn;
                        System.out.println("Waktu untuk menemukan kata (dalam nanosecond): " + totalTempTime);
                        compTotal += comp;
                        System.out.println("Jumlah perbandingan huruf untuk menemukan kata: " + comp);
                        System.out.println();
                        wordFound = true;
                    } else if (ops.checkWest(puzzle, findNow, rPivot, cPivot, comp)) {
                        ops.printWest(puzzle, findNow, rPivot, cPivot);
                        long tempTimeOut = System.nanoTime();
                        long totalTempTime = tempTimeOut - tempTimeIn;
                        System.out.println("Waktu untuk menemukan kata (dalam nanosecond): " + totalTempTime);
                        compTotal += comp;
                        System.out.println("Jumlah perbandingan huruf untuk menemukan kata: " + comp);
                        System.out.println();
                        wordFound = true;
                    } else if (ops.checkNorthWest(puzzle, findNow, rPivot, cPivot, comp)) {
                        ops.printNorthWest(puzzle, findNow, rPivot, cPivot);
                        long tempTimeOut = System.nanoTime();
                        long totalTempTime = tempTimeOut - tempTimeIn;
                        System.out.println("Waktu untuk menemukan kata (dalam nanosecond): " + totalTempTime);
                        compTotal += comp;
                        System.out.println("Jumlah perbandingan huruf untuk menemukan kata: " + comp);
                        System.out.println();
                        wordFound = true;
                    } else if (ops.checkNorth(puzzle, findNow, rPivot, cPivot, comp)) {
                        ops.printNorth(puzzle, findNow, rPivot, cPivot);
                        long tempTimeOut = System.nanoTime();
                        long totalTempTime = tempTimeOut - tempTimeIn;
                        System.out.println("Waktu untuk menemukan kata (dalam nanosecond): " + totalTempTime);
                        compTotal += comp;
                        System.out.println("Jumlah perbandingan huruf untuk menemukan kata: " + comp);
                        System.out.println();
                        wordFound = true;
                    } else if (ops.checkNorthEast(puzzle, findNow, rPivot, cPivot, comp)) {
                        ops.printNorthEast(puzzle, findNow, rPivot, cPivot);
                        long tempTimeOut = System.nanoTime();
                        long totalTempTime = tempTimeOut - tempTimeIn;
                        System.out.println("Waktu untuk menemukan kata (dalam nanosecond): " + totalTempTime);
                        compTotal += comp;
                        System.out.println("Jumlah perbandingan huruf untuk menemukan kata: " + comp);
                        System.out.println();
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
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Waktu eksekusi program (dalam nanosecond): " + totalTime);
        System.out.println("Jumlah total perbandingan huruf untuk menemukan seluruh kata: " + compTotal);
        input.close();
    }
}
