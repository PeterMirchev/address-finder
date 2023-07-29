package service;

import model.ReaderCountry;

import java.util.Set;

public final class AddressReaderProvider implements Provider<AddressReader, ReaderCountry> {

    @Override
    public Set<AddressReader> getContent() {
        return Set.of(
                new UsaAddressReader(),
                new SpainAddressReader()
        );
    }

    @Override
    public AddressReader getSingleContent(ReaderCountry flag) {

        return getContent().stream()
                .filter(p -> p.getResponsibleCountry().equals(flag))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such provider exists."));
    }
}
