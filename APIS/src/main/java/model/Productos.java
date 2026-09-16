package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Productos {
    private OffsetDateTime elaborado;
    private String title;
    private String idProvince;
    private String name;
    private String nameProvince;
    private String the0;
    private String description;
    private String id;
    private String max;
    private String min;
    private String productor;
    private String web;
    private String language;
    private String copyright;
    private String notaLegal;
    private String descripcion;
    private String codprov;
    private String nombreProvincia;
    private String codauton;
    private String comunidadCiudadAutonoma;
    private String capitalProvincia;
}
