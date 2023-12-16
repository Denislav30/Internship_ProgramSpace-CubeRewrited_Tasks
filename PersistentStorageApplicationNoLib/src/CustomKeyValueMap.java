import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CustomKeyValueMap implements CustomMap{
    private KeyValuePair[] entries;
    private static final int INITIAL_CAPACITY = 16;

    public CustomKeyValueMap() {
        entries = new KeyValuePair[INITIAL_CAPACITY];
    }

    @Override
    public void put(String key, Object value) {
        int index = getIndex(key);
        if (entries[index] == null) {
            entries[index] = new KeyValuePair(key, value);
        } else {
            KeyValuePair current = entries[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = new KeyValuePair(key, value);
        }
    }

    @Override
    public Object get(String key) {
        int index = getIndex(key);
        KeyValuePair current = entries[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean contains(String key) {
        int index = getIndex(key);
        KeyValuePair current = entries[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(String key) {
        int index = getIndex(key);
        KeyValuePair current = entries[index];
        KeyValuePair previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    entries[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public void persistToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (KeyValuePair entry : entries) {
                while (entry != null) {
                    writer.write(entry.key + "," + entry.value);
                    writer.newLine();
                    entry = entry.next;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getIndex(String key) {
        return key.hashCode() % INITIAL_CAPACITY;
    }



}
