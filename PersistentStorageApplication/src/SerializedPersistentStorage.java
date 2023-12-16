import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SerializedPersistentStorage implements Storage{
    private Map<String, Object> storage;
    private String filePath;

    public SerializedPersistentStorage(String filePath) {
        this.filePath = filePath;
        this.storage = loadFromFile();
    }

    @Override
    public void put(String key, Object value) {
        storage.put(key, value);
        saveToFile();
    }

    @Override
    public Object get(String key) {
        return storage.get(key);
    }

    @Override
    public boolean contains(String key) {
        return storage.containsKey(key);
    }

    @Override
    public boolean remove(String key) {
        if (storage.containsKey(key)) {
            storage.remove(key);
            saveToFile();
            return true;
        }
        return false;
    }

    private Map<String, Object> loadFromFile() {
        Map<String, Object> loadedData = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    loadedData.put(parts[0], parts[1]);
                }
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedData;
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Object> entry : storage.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
