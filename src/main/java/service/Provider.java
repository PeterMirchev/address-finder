package service;

import java.util.Set;

public interface Provider<T, E> {

    Set<T> getContent();
    T getSingleContent(E flag);

}
