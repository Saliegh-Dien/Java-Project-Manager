public class architect {

    //attributes initiation section=================================================================================
    String name;
    String tele_num;
    String email;
    String address;

    //methods creation section======================================================================================
    public architect(String name, String tele_num, String email, String address) {
        this.name = name;
        this.tele_num = tele_num;
        this.email = email;
        this.address = address;
    }
    //calling methods section=======================================================================================
    public String getName() {
        return name;
    }
    public String getTele_num() {
        return tele_num;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    //string creation section=======================================================================================
    public String toString() {
        String output = "," + name;
        output += "," + tele_num;
        output += "," + email;
        output += "," + address;

        return output;
    }
}
