public class Main {
    public static void main(String[] args) {

        System.out.println("Let's staple some pages...");
        Stapler stapler = new StandartStapler(33);
        stapler.staple(20);

        stapler.staple(30);

        stapler.reloadStaples(50);

    }
}