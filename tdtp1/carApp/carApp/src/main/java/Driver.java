public class Driver {
    public static final int MIN_AGE = 10;
    private String nom;
    private int age;

    public Driver(String name, int years) {
        this.nom = name;
        this.age = years;
    }

    public boolean estAdulte() {
        return age >= MIN_AGE;
    }

    public void demarrerVoiture(Car car) {
        if (estAdulte()) {
            System.out.println(nom + " démarre la car.");
        } else {
            System.out.println("Le conducteur n'est pas assez âgé pour conduire.");
        }
    }

    public void arreterVoiture(Car car) {
        System.out.println(nom + " arrête la car.");
    }

    public void changerVitesse(Car car, int nouvelleVitesse) {
        System.out.println(nom + " change la vitesse de la car à " + nouvelleVitesse);
        int vitesseActuelle;
        if (car.getVitesse() >= nouvelleVitesse) {
            while (car.getVitesse() > nouvelleVitesse) {
                car.ralentir();
            }
        } else  {
            while (car.getVitesse() < nouvelleVitesse) {
                car.accelerer();
            }
        }
    }
}
