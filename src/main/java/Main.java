import service.AddressReader;
import service.UsaAddressReader;
import model.Address;

import java.io.*;
import java.util.Collection;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Please select country for investigation: 1- USA | 2- AUS | 3-GBR");
        String country = "USA";
        System.out.println("Please enter CtyStateDirectory:");
        String ctyStateDirectory = "D:\\";
        System.out.println("Please enter zip4 directory:");
        String zip4Directory = "";


        System.out.println("Please enter zipCode:");
        String zipCode = "49725";
        System.out.println("Please enter City:");
        String city = "MICHIGAN";
        System.out.println("Please enter Street:");
        String street = "126 Lang Avenue";

        AddressReader addressReader = new UsaAddressReader();
        Address address = new Address(zipCode, city, street);

        Collection<String> recordsFound = addressReader.getMatchedRecords(ctyStateDirectory, address);

        //String sityStateKey =


    }
}