package model;

public class Produs {
    private int idProdus;
    private String nume;
    private int cantitate;

    public Produs(int idProdus, String nume, int cantitate) {
        this.idProdus = idProdus;
        this.nume = nume;
        this.cantitate = cantitate;
    }

    public int getIdPprodus() {
        return idProdus;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setIdPprodus(int idPprodus) {
        this.idProdus = idPprodus;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public int getCantitate() {
        return cantitate;
    }

    @Override
    public String toString() {
        return "Main.Product{" +
                "idPprodus=" + idProdus +
                ", nume='" + nume + '\'' +
                ", cantitate=" + cantitate +
                '}';
    }
}
