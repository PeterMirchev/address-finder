package service;

import model.Address;
import model.ReaderCountry;

import java.io.IOException;
import java.util.Collection;

import static model.ReaderCountry.ESP;

public class SpainAddressReader implements AddressReader {


    @Override
    public Collection<String> getMatchedRecords(Address address, String... directories) throws IOException {
        return null;
    }

    @Override
    public ReaderCountry getResponsibleCountry() {
        return ESP;
    }

    @Override
    public void addDirectoryPath(String directoryPath) {

    }
}
