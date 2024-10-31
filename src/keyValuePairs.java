public class keyValuePairs {
    //Instance variables
    private String key;
    private String value;
    private long hash;
    // Constructor
    public keyValuePairs(String key, String value, long hash){
        this.key = key;
        this.value = value;
        this.hash = hash;
    }
    public String getKey(){
        return key;
    }
    public String getValue(){
        return value;
    }
    public void setKey(String key){
        this.key = key;
    }
    public void setValue(String value){
        this.value = value;
    }
    public long getHash(){
        return hash;
    }
    public void setHash(int hash){
        this.hash = hash;
    }

}
