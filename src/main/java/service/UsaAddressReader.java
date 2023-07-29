package service;

import model.ReaderCountry;
import org.apache.commons.io.FilenameUtils;
import model.Address;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static model.ReaderCountry.USA;

public class UsaAddressReader implements AddressReader {

    public final static List<String> DIRECTORIES_PATHS = new ArrayList<>();

    @Override
    public Collection<String> getMatchedRecords(Address address, String... directories) throws IOException {

        List<String> records = new ArrayList<>();

        for (String directory : directories) {

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
        }

        return records;
    }

    @Override
    public ReaderCountry getResponsibleCountry() {

        return USA;
    }

    @Override
    public void addDirectoryPath(String directoryPath) {

        DIRECTORIES_PATHS.add(directoryPath);
    }

    private Set<File> listFilesUsingJavaIO(String dir) {

        return Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
                .filter(file -> !file.isDirectory())
                .filter(file -> !FilenameUtils.isExtension(file.getName(), "tmp"))
                .collect(Collectors.toSet());
    }


}
