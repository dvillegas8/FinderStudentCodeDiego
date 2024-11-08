public class CustomHashMap {
    private static final String INVALID = "INVALID KEY";
    private static final int DEFAULT_TABLE_SIZE = 4500;
    // number of key-value pairs in the table
    private int n;
    private int tableSize;
    private String[] keys;
    private String[] values;
    public CustomHashMap(){
        this.tableSize = DEFAULT_TABLE_SIZE;
        keys = new String[tableSize];
        values = new String[tableSize];
    }
    private void resize(){
        tableSize *= 2;
        String[] newKeys = new String[tableSize];
        String[] newValues = new String[tableSize];
        String[] originalKeys = keys;
        String[] originalValues = values;
        keys = newKeys;
        values = newValues;
        // Set the number of keys in array to 0 so that we don't accidentally count more keys when rehashing
        n = 0;
        // Transfer all existing key-value pairs to new array
        for(int i = 0; i < originalKeys.length; i++){
            if(originalKeys[i] != null){
                rehash(originalKeys[i], originalValues[i]);

            }
        }
    }
    public void put(String key, String value){
        int keyHash = hash(key);
        // Check if a collision occurs
        if(keys[keyHash] != null){
            // Linear probing, continue checking until empty index
            while(keys[keyHash] != null){
                // Wrap around the array if keyHash/index is greater than array length
                if(keyHash >= keys.length -1){
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
        // Check if resize is needed/load factor is greater or equal to 1/2
        double loadfactor = (double) n / tableSize;
        if(loadfactor >= 0.5){
            resize();
        }
    }
    public String getValue(String key){
        int keyHash = hash(key);
        // Check if index
        if(keys[keyHash] == null){
            return INVALID;
        }
        // Check if keys match
        else if(!keys[keyHash].equals(key) ){
            // Continue checking to the right until we find the correct key
            while(keys[keyHash] == null || !keys[keyHash].equals(key)){
                // Wrap around the around if keyHash is too big
                if(keyHash >= keys.length - 1){
                    keyHash = 0;
                }
                else{
                    keyHash++;
                }
            }
        }
        return values[keyHash];
    }
    // Method for resize, same as put but don't do checks on load factor since it is unnecessary
    public void rehash(String key, String value){
        int keyHash = hash(key);
        // Check if a collision occurs
        if(keys[keyHash] != null){
            // Linear probing, continue checking until empty index
            while(keys[keyHash] != null){
                // Wrap around the array if keyHash/index is greater than array length
                if(keyHash >= keys.length - 1){
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
    // Horner's Method
    public int hash(String t){
        // Biggest character value + 1
        int R = 256;
        long h = 0;
        for(int i = 0; i < t.length(); i++){
            h = (R * h + t.charAt(i)) % tableSize;
        }
        return (int) h;
    }
}
