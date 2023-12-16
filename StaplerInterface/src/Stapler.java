public interface Stapler {
    void staple(int numPages);

    int getStapleCapacity();

    void reloadStaples(int newCapacity);
}
