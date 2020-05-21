package com.eap.manageating.model;

import javax.persistence.*;

@Entity
@Table(name = "listaprodus")
public class ListaProdus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlistaprodus")
    private int idListaProdus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcomanda")
    private Comanda idComanda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprodus")
    private Produs idProdus;

    @Column(name = "cantitate")
    private int cantitate;

    public ListaProdus() {
    }

    public ListaProdus(int idListaProdus, Comanda idComanda, Produs idProdus, int cantitate) {
        this.idListaProdus = idListaProdus;
        this.idComanda = idComanda;
        this.idProdus = idProdus;
        this.cantitate = cantitate;
    }

    public int getIdListaProdus() {
        return idListaProdus;
    }

    public void setIdListaProdus(int idListaProdus) {
        this.idListaProdus = idListaProdus;
    }

    public Comanda getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Comanda idComanda) {
        this.idComanda = idComanda;
    }

    public Produs getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(Produs idProdus) {
        this.idProdus = idProdus;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }


}
