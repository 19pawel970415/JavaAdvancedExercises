package OOP.tickets;

public enum Ticket {

    NORMLANY_GODZINA(1.70f),
    ULGOWY_STUDENCKI(0.90f),
    ULGOWY_EMERYT(0.30f),
    NORMALNY_CALODNIOWY(5.30f);

    private float price;

    Ticket(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
