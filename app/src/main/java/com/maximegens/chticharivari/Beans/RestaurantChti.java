package com.maximegens.chticharivari.beans;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Un restaurant ChtiCharivari.
 */
public class RestaurantChti implements Parcelable {

    private Integer id;
    private String nom;
    private String adresse;
    private String telephone;
    private String url_img;
    private String url_local;
    private String ouverture;
    private String nb_place;
    private String wifi;
    private String terrasse;
    private String parking;
    private String acces_handicapes;
    private String infos_complementaires;


    public RestaurantChti(Parcel in) {
        this.id = in.readInt();
        this.nom = in.readString();
        this.adresse = in.readString();
        this.telephone = in.readString();
        this.url_img = in.readString();
        this.url_local = in.readString();
        this.ouverture = in.readString();
        this.nb_place = in.readString();
        this.wifi = in.readString();
        this.terrasse = in.readString();
        this.parking = in.readString();
        this.acces_handicapes = in.readString();
        this.infos_complementaires = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(adresse);
        dest.writeString(telephone);
        dest.writeString(url_img);
        dest.writeString(url_local);
        dest.writeString(ouverture);
        dest.writeString(nb_place);
        dest.writeString(wifi);
        dest.writeString(terrasse);
        dest.writeString(parking);
        dest.writeString(acces_handicapes);
        dest.writeString(infos_complementaires);
    }

    public static final Parcelable.Creator<RestaurantChti> CREATOR = new Parcelable.Creator<RestaurantChti>()
    {
        @Override
        public RestaurantChti createFromParcel(Parcel source)
        {
            return new RestaurantChti(source);
        }

        @Override
        public RestaurantChti[] newArray(int size)
        {
            return new RestaurantChti[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getUrl_local() { return url_local; }

    public void setUrl_local(String url_local) { this.url_local = url_local; }

    public String getOuverture() {
        return ouverture;
    }

    public void setOuverture(String ouverture) {
        this.ouverture = ouverture;
    }

    public String getNb_place() {
        return nb_place;
    }

    public void setNb_place(String nb_place) {
        this.nb_place = nb_place;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getTerrasse() {
        return terrasse;
    }

    public void setTerrasse(String terrasse) {
        this.terrasse = terrasse;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getAcces_handicapes() {
        return acces_handicapes;
    }

    public void setAcces_handicapes(String acces_handicapes) {
        this.acces_handicapes = acces_handicapes;
    }

    public String getInfos_complementaires() {
        return infos_complementaires;
    }

    public void setInfos_complementaires(String infos_complementaires) {
        this.infos_complementaires = infos_complementaires;
    }

    @Override
    public String toString() {
        return "RestaurantChti{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", url_img='" + url_img + '\'' +
                ", url_local='" + url_local + '\'' +
                ", ouverture='" + ouverture + '\'' +
                ", nb_place='" + nb_place + '\'' +
                ", wifi='" + wifi + '\'' +
                ", terrasse='" + terrasse + '\'' +
                ", parking='" + parking + '\'' +
                ", acces_handicapes='" + acces_handicapes + '\'' +
                ", infos_complementaires='" + infos_complementaires + '\'' +
                '}';
    }
}

