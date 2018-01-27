package com.iesemilidarder.restaurants.web;

public class Restaurante {

        /* clase restaurante con atributos privados y un metodo set y otro get, pùblicos, para obtener y establecer cada atributo */

    private String nombre;
    private String direcc;
    private String vveb;
    private String telef;
    private String tipo;
    private double media;
    private String img;
    private Opinion op;

    public double getMedia(){
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDirecc() {

        return direcc;
    }

    public void setDirecc(String direcc) {
        this.direcc = direcc;

    }
    public String getVveb() {
        return vveb;
    }

    public void setVveb(String vveb) {

        this.vveb = vveb;
    }
    public String getTelef() {

        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String nombre) {
        this.tipo = nombre;
    }

    public String getImg(){
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Opinion getOp() {
        return op;
    }

    public void setOp(Opinion op) {
        this.op = op;
    }
}

