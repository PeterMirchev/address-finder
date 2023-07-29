package service;

import model.Address;
import model.ReaderCountry;

import java.io.IOException;
import java.util.Collection;

public interface AddressReader {

    Collection<String> getMatchedRecords(String directory, Address address) throws IOException;

    ReaderCountry getResponsibleCountry();
}
