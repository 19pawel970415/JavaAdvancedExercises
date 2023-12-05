package enums.ex2;

public enum PackageSize {

    SMALL(1, 10),
    MEDIUM(11, 20),
    LARGE(21, 30);

    private float minPackageSize;
    private float maxPackageSize;

    PackageSize(float minPackageSize, float maxPackageSize) {
        this.minPackageSize = minPackageSize;
        this.maxPackageSize = maxPackageSize;
    }


    static PackageSize getPackageSize(float packageSize) {
        if (packageSize >= PackageSize.SMALL.minPackageSize && packageSize <= PackageSize.SMALL.maxPackageSize) {
            return PackageSize.SMALL;
        } else if (packageSize >= PackageSize.MEDIUM.minPackageSize && packageSize <= PackageSize.MEDIUM.maxPackageSize) {
            return PackageSize.MEDIUM;
        } else if (packageSize >= PackageSize.LARGE.minPackageSize && packageSize <= PackageSize.LARGE.maxPackageSize) {
            return PackageSize.LARGE;
        } else {
            System.out.println("None of our sizes matches your requirements");
            return null;
        }
    }
}
