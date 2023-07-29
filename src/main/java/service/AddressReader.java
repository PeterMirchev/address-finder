package service;

import model.Address;
import model.ReaderCountry;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static service.UsaAddressReader.DIRECTORIES_PATHS;

public interface AddressReader {

    Collection<String> getMatchedRecords(Address address, String... directory) throws IOException;

    ReaderCountry getResponsibleCountry();

    void addDirectoryPath(String directoryPath);

    default List<String> getDirectories(String month) {

        String base = "C:\\input\\" + this.getResponsibleCountry();

        for (String directoryName : this.getResponsibleCountry().getDirectories()) {
            fillFolderPaths(base, month, directoryName);
        }

        return DIRECTORIES_PATHS;
    }

    default void fillFolderPaths(String base, String month, String directory) {

        File[] files = new File(base).listFiles();

        for (File file : files) {

            if (file.isDirectory()) {
                if (file.getName().equals(directory)) {
                    if (file.getAbsolutePath().contains(month) && file.getAbsolutePath().contains(String.valueOf(LocalDate.now().getYear()))) {
                        this.addDirectoryPath(file.getAbsolutePath());
                    }
                    return;
                } else {
                    fillFolderPaths(file.getAbsolutePath(), month, directory);
                }
            }

        }
    }
}
