package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Lab {

    public int id;
    public String address;
    public String zip;
    public String country;

    public Lab( String address, String zip, String country) {
        this.address = address;
        this.zip = zip;
        this.country = country;
    }

    public Lab(int id, String address, String zip, String country) {
        this.id = id;
        this.address = address;
        this.zip = zip;
        this.country = country;
    }

    public Lab(ResultSet rs){
        try {
            this.country = rs.getString("country");
            this.address = rs.getString("address");
            this.zip = rs.getString("zip");
            this.id = rs.getInt("id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
