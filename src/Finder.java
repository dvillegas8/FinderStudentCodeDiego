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
    private String[] hashMap = new String[size];
    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        String line = "";
        pairs = new keyValuePairs[size];
        // For every line in cvs file
        String[] parts;
        // Array which holds the keys
        long hash = 0L;
        int i = 1;
        while((line = br.readLine()) != null){

            /*
            parts = line.split(",");
            pairs[i] = new keyValuePairs(parts[keyCol], parts[valCol], hash(parts[keyCol], parts[keyCol].length(), 0));
            //keys[i] = parts[keyCol];
            //values[i] = parts[valCol];
            i++;

             */
            parts = line.split(",");
            hash = hash(parts[keyCol], parts[keyCol].length(), 0);
            hashMap[(int) hash] = parts[valCol];
            i++;
        }
        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        // keyValuePairs[] pairs = new keyValuePairs[numElements];
        // for(int i = 1; i < pairs.length; i++){
            //pairs[i] = new keyValuePairs(keys[i], values[i], hash(keys[i], keys[i].length(), 0));
        //}
        long hashKey = hash(key, key.length(), 0);
        if(hashMap[(int)hashKey] == null){
            return INVALID;
        }
        else{
            return hashMap[(int)hashKey];
        }
        /*
        for(int i = 1; i < pairs.length; i++){
            if(pairs[i].getHash() == hashKey){
                return pairs[i].getValue();
            }
        }

         */
        //return INVALID;
    }
    // Horner's Method
    public long hash(String t, int m, int start){
        long h = 0;
        for(int i = start; i < start + m; i++){
            h = (R * h + t.charAt(i)) % P;
        }
        return h;
    }
}