package logic.dataStorage;

public class StringDataStorage implements DataStorageInterface<String>{
    private String data;

    public StringDataStorage(String data) {
        this.data = data;
    }

    public StringDataStorage() {
        this.data = new String();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
