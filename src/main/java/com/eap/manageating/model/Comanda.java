package com.eap.manageating.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "comanda")
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcomanda")
    private int idComanda;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "idstaff")
    private Staff staff;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "idmasa")
    private Masa masa;

    @Column(name = "datacomanda")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataComanda;

    @Column(name = "total")
    private int total;

    @Column(name = "finalizata")
    private boolean finalizata;

    @OneToMany(mappedBy = "idComanda")
    private List<ListaProdus> listaProduse;


    public List<ListaProdus> getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(List<ListaProdus> listaProduse) {
        this.listaProduse = listaProduse;
    }

    public Comanda() {
    }

    public Comanda(int idComanda, Staff staff, Masa masa, Date dataComanda, int total, boolean finalizata) {
        this.idComanda = idComanda;
        this.staff = staff;
        this.masa = masa;
        this.dataComanda = dataComanda;
        this.total = total;
        this.finalizata = finalizata;
    }

    public Comanda(int idComanda, Staff staff, Masa masa, Date dataComanda, int total, boolean finalizata, List<ListaProdus> listaProduse) {
        this.idComanda = idComanda;
        this.staff = staff;
        this.masa = masa;
        this.dataComanda = dataComanda;
        this.total = total;
        this.finalizata = finalizata;
        this.listaProduse = listaProduse;
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Masa getMasa() {
        return masa;
    }

    public void setMasa(Masa masa) {
        this.masa = masa;
    }

    public Date getDataComanda() {
        return dataComanda;
    }

    public void setDataComanda(Date dataComanda) {
        this.dataComanda = dataComanda;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void addTotal(int deAdaugat) {
        this.total = total + deAdaugat;
    }

    public boolean isFinalizata() {
        return finalizata;
    }

    public void setFinalizata(boolean finalizata) {
        this.finalizata = finalizata;
    }


}
