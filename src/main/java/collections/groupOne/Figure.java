package collections.groupOne;

public abstract class Figure implements Comparable<Figure> {

    public abstract double countArea();

    @Override
    public int compareTo(Figure o) {
        double thisArea = this.countArea();
        double otherArea = o.countArea();

        if (thisArea < otherArea) {
            return -1;
        } else if (thisArea > otherArea) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "The area is " + this.countArea();
    }

    //6. Utwórz kilka obiektów typu Kwadrat i Prostokąt i umieść w Secie
    //przechowującym typ Figura
    //7. Wydrukuj wszystkie obiekty
    //8. Podmień implementację seta i zaobserwuj różnice
    //1. HashSet
    //2. LinkedHashSet
    //3. TreeSet

}
