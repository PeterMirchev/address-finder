package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Listing {

    public static Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    public static void iterAndReadFiles(String directory, Set<String> files, Address address) throws IOException {
        for (String file : files) {

            File currentFile = new File(directory + file);

            if (currentFile.getName().endsWith(".tmp")) {
                continue;
            }

            BufferedReader br = new BufferedReader(new FileReader(currentFile));

            String st;
            while ((st = br.readLine()) != null) {
                boolean sameZipCode = st.substring(1, 6).equals(address.getZipCode());
                boolean containCity = st.contains(address.getCity().toUpperCase());
                if(containCity && sameZipCode) {
                    System.out.println(st);
                }
            }
        }
    }
}
