package personal.model;

public class Toy {
    private String id = "";
    private String toy;
    private String drop;
    private String quantity;

    public Toy(String toy, String drop, String quantity) {
        this.toy = toy;
        this.drop = drop;
        this.quantity = quantity;
    }

    public Toy(String id, String toy, String drop, String quan) {
        this(toy, drop, quan);
        this.id = id;

    }

    @Override
    public String toString() {
        return String.format("Идентафикатор: %s\nНазвание: %s,\nШанс выйгрыша: %s,\nКоличество: %s", id, toy, drop, quantity);
    }

    public String getToy() {
        return toy;
    }

    public void setToy(String toy) {
        this.toy = toy;
    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String text) {
        this.drop = text;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
