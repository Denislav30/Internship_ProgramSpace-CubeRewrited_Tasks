public interface Storage {
    void put(String key, Object value);
    Object get(String key);
    boolean contains(String key);
    boolean remove(String key);
}
