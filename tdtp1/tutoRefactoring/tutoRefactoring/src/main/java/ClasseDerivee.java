public class ClasseDerivee extends BaseClass{
    public static void main(String[] args) {
        ClasseDerivee subject = new ClasseDerivee();
        System.out.println("Doublement 21. Résultat = " + subject.doubleValue(21));
    }

    /**
     * @param number  - le nombre à doubler
     * @return  - 2*number
     */
    private int doubleValue(int number) {
        return number + number;
    }
}
