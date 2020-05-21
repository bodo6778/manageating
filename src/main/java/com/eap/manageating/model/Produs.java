package com.eap.manageating.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "produs")
public class Produs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprodus")
    private int idProdus;

    @Column(name = "nume")
    private String nume;

    @Column(name = "tip") //de adaugat check tip
    private String tip;

    @Column(name = "cantitate")
    private String cantitate;

    @Column(name = "pret")
    private int pret;

    @Column(name = "popularitate")
    private int popularitate;

    @Column(name = "descriere")
    private String descriere;

    @OneToMany(mappedBy = "idProdus")
    private List<ListaProdus> listaProduse;

    public Produs() {
    }

    public Produs(int idProdus, String nume, String tip, String cantitate, int pret, int popularitate, String descriere) {
        this.idProdus = idProdus;
        this.nume = nume;
        this.tip = tip;
        this.cantitate = cantitate;
        this.pret = pret;
        this.popularitate = popularitate;
        this.descriere = descriere;
    }

    public Produs(int idProdus, String nume, String tip, String cantitate, int pret, int popularitate, String descriere, List<ListaProdus> listaProduse) {
        this.idProdus = idProdus;
        this.nume = nume;
        this.tip = tip;
        this.cantitate = cantitate;
        this.pret = pret;
        this.popularitate = popularitate;
        this.descriere = descriere;
        this.listaProduse = listaProduse;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getCantitate() {
        return cantitate;
    }

    public void setCantitate(String cantitate) {
        this.cantitate = cantitate;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getPopularitate() {
        return popularitate;
    }

    public void setPopularitate(int popularitate) {
        this.popularitate = popularitate;
    }

    public void crestePopularitate(int popularitate) { this.popularitate += popularitate; }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public List<ListaProdus> getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(List<ListaProdus> listaProduse) {
        this.listaProduse = listaProduse;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "idProdus=" + idProdus +
                ", nume='" + nume + '\'' +
                ", tip='" + tip + '\'' +
                ", cantitate='" + cantitate + '\'' +
                ", pret=" + pret +
                ", popularitate=" + popularitate +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
