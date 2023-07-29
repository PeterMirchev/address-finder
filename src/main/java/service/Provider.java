package service;

import java.io.IOException;
import java.util.Set;

public interface Provider<T, E> {

    Set<T> getContent() throws IOException;
    T getSingleContent(E flag) throws IOException;

}
