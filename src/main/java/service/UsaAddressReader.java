package service;

import model.ReaderCountry;
import org.apache.commons.io.FilenameUtils;
import model.Address;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static model.ReaderCountry.USA;

public class UsaAddressReader implements AddressReader {

    @Override
    public Collection<String> getMatchedRecords(String directory, Address address) throws IOException {

        List<String> records = new ArrayList<>();

        for (File file : listFilesUsingJavaIO(directory)) {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String currentLine;

            while ((currentLine = br.readLine()) != null) {

                if (currentLine.length() <= 6) {
                    continue;
                }

                boolean sameZipCode = currentLine.substring(1, 6).equals(address.getZipCode());
                boolean containCity = currentLine.contains(address.getCity().toUpperCase());

                if (containCity && sameZipCode && currentLine.startsWith("D")) {
                    records.add(currentLine);
                    System.out.println(currentLine);
                }
            }
        }


        return records;
    }

    @Override
    public ReaderCountry getResponsibleCountry() {
        return USA;
    }

    private Set<File> listFilesUsingJavaIO(String dir) {

        return Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
                .filter(file -> !file.isDirectory())
                .filter(file -> !FilenameUtils.isExtension(file.getName(), "tmp"))
                .collect(Collectors.toSet());
    }


}
