package model;

public enum ReaderCountry {

    USA("USPS", "cityState", "zip4"),
    AUS("AUSPS", "banana", "tomato"),
    GBR("RoyalMail", "peach", "beach"),
    ESP("Banana", "city", "rprprprpr"),
    TEST("Ivan", "Streams, Files And Directories - Lab");

    private String countryAddressProvider;
    private String[] directories;

    ReaderCountry(String countryAddressProvider, String... directories) {

        this.countryAddressProvider = countryAddressProvider;
        this.directories = directories;
    }

    public String getCountryAddressProvider() {
        return this.countryAddressProvider;
    }

    public String[] getDirectories() {
        return this.directories;
    }
}
