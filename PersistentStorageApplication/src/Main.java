public class Main {
    public static void main(String[] args) {
        Storage persistentStorage = new SerializedPersistentStorage("PersistentStorage.txt");

        persistentStorage.put("Gosho", "0878111111");
        persistentStorage.put("Pesho", "0877222222");

        System.out.println("Is Gosho in the map? " + persistentStorage.contains("Gosho"));

        System.out.println("What is the number of Pesho in the map? " + persistentStorage.get("Pesho"));

        System.out.println("Removing Gosho from the map!");
        persistentStorage.remove("Gosho");

        System.out.println("Check if Gosho is still in the map: " + persistentStorage.contains("Gosho"));
    }
}