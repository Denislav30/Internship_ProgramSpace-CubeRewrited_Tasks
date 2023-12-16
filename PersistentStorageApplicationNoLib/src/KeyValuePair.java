public class KeyValuePair {
    String key;
    Object value;
    KeyValuePair next;

    KeyValuePair(String key, Object value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
