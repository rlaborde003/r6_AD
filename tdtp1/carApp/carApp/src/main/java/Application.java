public class Application {
    public static void main(String[] args) {
        Car myCar = new Car("Sedan", "Bleu");
        Driver moi = new Driver("John", 20);

        moi.demarrerVoiture(myCar);
        myCar.accelerer();
        moi.changerVitesse(myCar, 80);
        myCar.ralentir();
        moi.changerVitesse(myCar,30);
        moi.arreterVoiture(myCar);
        System.out.println("fini");
    }
}
