public class Main {
    public static void main(String[] args) {
        CustomMap customMap = new CustomKeyValueMap();

        customMap.put("Boris", "0897888888");
        customMap.put("Vasil", "0896555555");

        System.out.println("Is Boris in the customMap: " + customMap.contains("Boris"));
        System.out.println("The number of Vasil is: " + customMap.get("Vasil"));

        System.out.println("Removing Boris from the customMap");
        customMap.remove("Boris");

        System.out.println("Is Boris still in the customMap: " + customMap.contains("Boris"));

        customMap.persistToFile("storage.txt");
    }
}