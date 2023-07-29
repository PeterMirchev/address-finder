package service;

import model.ReaderCountry;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

public final class AddressReaderProvider implements Provider<AddressReader, ReaderCountry> {

    @Override
    public Set<AddressReader> getContent() throws IOException {
        Enumeration<URL> resources = ClassLoader.getSystemResources("src/main/java/service");

        System.out.println();

        return Set.of(
                new UsaAddressReader(),
                new SpainAddressReader()
        );
    }

    @Override
    public AddressReader getSingleContent(ReaderCountry flag) throws IOException {

        return getContent().stream()
                .filter(p -> p.getResponsibleCountry().equals(flag))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such provider exists."));
    }
}
