package src.com.Lrd.www.bean;

/**
 * @date 2020/2/19-11:29
 */
public class Library {
    private int id;
    private String curator;
    private String libraryName;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%5d%15s%15s%15s",id,libraryName,address,curator);
    }
}
