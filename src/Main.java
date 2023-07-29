import utils.Address;
import utils.Listing;
import java.io.*;
import java.util.Set;
import static utils.Listing.iterAndReadFiles;
public class Main {
    public static void main(String[] args) throws IOException {
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

        Address address = new Address(zipCode, city, street);
        Set<String> files = Listing.listFilesUsingJavaIO(ctyStateDirectory);


        iterAndReadFiles(ctyStateDirectory, files, address);


    }

}