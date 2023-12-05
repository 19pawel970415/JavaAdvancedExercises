package enums.ex2;

public class MainExercise2 {

    public static void main(String[] args) {

        //Zadanie 2
        //Stwórz klasę enum PackageSize ze stałymi SMALL , MEDIUM , LARGE . Enum
        //powinien przyjmować w konstruktorze dwa parametry:
        //minimalny rozmiar paczki w cm
        //maksymalny rozmiar paczki w cm
        //Dodatkowo enum PackageSize powinien zawierać metodę statyczną
        //getPackageSize , która przyjmuje na wejściu minimalny i maksymalny rozmiar
        //paczki, a jako rezultat powinna zwracać konkretny obiekt PackageSize na
        //podstawie przekazanego rozmiaru paczki.

        float packageSize1 = 5.0f;
        PackageSize size1 = PackageSize.getPackageSize(packageSize1);
        System.out.println("Package size " + packageSize1 + " is: " + size1);

        float packageSize2 = 15.0f;
        PackageSize size2 = PackageSize.getPackageSize(packageSize2);
        System.out.println("Package size " + packageSize2 + " is: " + size2);

        float packageSize3 = 25.0f;
        PackageSize size3 = PackageSize.getPackageSize(packageSize3);
        System.out.println("Package size " + packageSize3 + " is: " + size3);

        float packageSize4 = 35.0f;
        PackageSize size4 = PackageSize.getPackageSize(packageSize4);
        System.out.println("Package size " + packageSize4 + " is: " + size4);


    }

}
