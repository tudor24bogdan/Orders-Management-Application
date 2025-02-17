package model;
public class Client {
    private int idClient;
    private String nume;
    private String email;
    private String adresa;
    public Client(int idClient, String nume, String email ,String adresa){
        this.idClient = idClient;
        this.nume = nume;
        this.email = email;
        this.adresa = adresa;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Main.Client{" +
                "idClient=" + idClient +
                ", nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
