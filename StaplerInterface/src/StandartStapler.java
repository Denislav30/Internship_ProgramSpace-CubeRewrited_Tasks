public class StandartStapler implements Stapler{
    private int Capacity;
    public StandartStapler(int capacity) {
        Capacity = capacity;
    }
    @Override
    public void staple(int numPages) {
        if(Capacity >= numPages) {
            System.out.println("Stapling " + numPages + " pages.");
            Capacity = Capacity - numPages;
        }else {
            System.out.println("Error: Stapler capacity exceeded!");
        }
    }
    @Override
    public int getStapleCapacity() {
        return Capacity;
    }
    @Override
    public void reloadStaples(int newCapacity) {
        System.out.println("Reloading...");
        Capacity = newCapacity;
        System.out.println("Stapler is ready to use with the Capacity of: " + Capacity + " staples.");

    }
}
