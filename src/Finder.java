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

    private static final String INVALID = "INVALID KEY";
    // Prime number
    private static long P = 811L;
    // Base of 122 because it is y + 1, y is the lowest character in the elements csv file
    private static int R = 'y' + 1;
    // size of the arrays
    private static final int size = (int) P;
    public Finder() {}
    private String[] keys = new String[size];
    private String[] values = new String[size];
    private keyValuePairs[] pairs;
    //private String[] hashMap = new String[size];
    private CustomHashMap table;
    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
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
        // TODO: Complete the query() function!
        return table.getValue(key);
    }
}