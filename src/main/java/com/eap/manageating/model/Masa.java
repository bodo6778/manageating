package com.eap.manageating.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "masa")
public class Masa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmasa")
    private int idMasa;

    @Column(name = "locuri")
    private int locuri;

    @OneToMany(mappedBy = "masa")
    private List<Comanda> comenzi;

    public Masa() {
    }

    public Masa(int idMasa, int locuri) {
        this.idMasa = idMasa;
        this.locuri = locuri;
    }

    public Masa(int idMasa, int locuri, List<Comanda> comenzi) {
        this.idMasa = idMasa;
        this.locuri = locuri;
        this.comenzi = comenzi;
    }

    public int getIdMasa() {
        return idMasa;
    }

    public void setIdMasa(int idMasa) {
        this.idMasa = idMasa;
    }

    public int getLocuri() {
        return locuri;
    }

    public void setLocuri(int locuri) {
        this.locuri = locuri;
    }

    public List<Comanda> getComenzi() {
        return comenzi;
    }

    public void setComenzi(List<Comanda> comenzi) {
        this.comenzi = comenzi;
    }

    @Override
    public String toString() {
        return "Masa{" +
                "idMasa=" + idMasa +
                ", locuri=" + locuri +
                ", comenzi=" + comenzi +
                '}';
    }
}
