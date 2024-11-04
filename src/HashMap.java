public class HashMap {
    public static final int DEFAULT_TABLE_SIZE = 103;
    // number of key-value pairs in the table
    private int n;
    // size of linear-probing table
    private int tableSize;
    private String[] keys;
    private String[] values;
    public HashMap(int tableSize){
        this.tableSize = tableSize;
        keys = new String[tableSize];
        values = new String[tableSize];
    }
    private void resize(){
        int newHash = 0;
        tableSize *= 2;
        String[] newKeys = new String[tableSize];
        String[] newValues = new String[tableSize];
        // Transfer all existing key-value pairs to new array
        for(int i = 0; i < keys.length; i++){
            if(keys[i] != null){
                newHash = hash(keys[i]);
                newKeys[newHash] = keys[i];
                newValues[newHash] = values[i];

            }
        }
        keys = newKeys;
        values = newValues;
    }
    public void put(String key, String value){
        // Check if resize is needed
        if ((double) n / tableSize > 0.5){
            resize();
        }
        int keyHash = hash(key);
        if(keys[keyHash] != null){
            // Linear probing
            while(keys[keyHash] != null){
                // Wrap around the array if keyHash/index is greater than array length
                if(keyHash > keys.length){
                    keyHash = 0;
                }
                else{
                    keyHash++;
                }
            }
        }
        n++;
        keys[keyHash] = key;
        values[keyHash] = value;
    }
    public String getValue(String key){
        int keyHash = hash(key);
        if(!keys[keyHash].equals(key)){
            // Continue checking to the right until we find the correct key
            while(!keys[keyHash].equals(key)){
                // Wrap around the around if keyHash is too big
                if(keyHash > keys.length){
                    keyHash = 0;
                }
                else{
                    keyHash++;
                }
            }
        }
        return values[keyHash];
    }
    // Horner's Method
    public int hash(String t){
        // R is the biggest character in elements + 1
        int R = 'y' + 1;
        long h = 0;
        for(int i = 0; i < t.length(); i++){
            h = (R * h + t.charAt(i)) % tableSize;
        }
        return (int) h;
    }
}
