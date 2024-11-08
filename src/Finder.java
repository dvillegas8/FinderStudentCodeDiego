import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Diego Villegas
 **/

public class Finder {
    private CustomHashMap table;
    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        table = new CustomHashMap();
        String line = "";
        String[] parts;
        int i = 1;
        // For every line in cvs file
        while((line = br.readLine()) != null){
            parts = line.split(",");
            table.put(parts[keyCol], parts[valCol]);
            i++;
        }
        br.close();
    }

    public String query(String key){
        return table.getValue(key);
    }
}