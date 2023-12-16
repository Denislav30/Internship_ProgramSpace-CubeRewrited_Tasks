public interface CustomMap {
    void put(String key, Object value);
    Object get(String key);
    boolean contains(String key);
    boolean remove(String key);
    void persistToFile(String filePath);
}
