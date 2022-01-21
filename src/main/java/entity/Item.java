package entity;

public class Item {
    private String name;
    private String originalPrise;
    private String actualPrise;
    private String discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginalPrise(String originalPrise) {
        this.originalPrise = originalPrise;
    }

    public void setActualPrise(String actualPrise) {
        this.actualPrise = actualPrise;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
