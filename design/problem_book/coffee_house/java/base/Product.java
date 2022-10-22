package base;

public class Product {
    public Product(String name, boolean isNeedPrepare) {
        this.name = name;
        this.isNeedPrepare = isNeedPrepare;
    }

    public String getName() { return name; }
    public boolean isNeedPrepare() { return isNeedPrepare; }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Product(").append(hashCode()).append(")");
        builder.append(" name=").append(name);
        return builder.toString();
    }

    private final String name;
    private final boolean isNeedPrepare;
}
