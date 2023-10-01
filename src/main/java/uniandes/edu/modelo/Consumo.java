package uniandes.edu.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
@Entity
@Table(name = "consumos")
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String descripcion;
    private double precioTotal;
    private Date dia;
    private Date mes;
    private Date anio;

    public Consumo(String descripcion, double precioTotal, Date dia, Date mes, Date anio) {
        this.descripcion = descripcion;
        this.precioTotal = precioTotal;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Consumo()
    {;}
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecioTotal() {
        return precioTotal;
    }
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    public Date getDia() {
        return dia;
    }
    public void setDia(Date dia) {
        this.dia = dia;
    }
    public Date getMes() {
        return mes;
    }
    public void setMes(Date mes) {
        this.mes = mes;
    }
    public Date getAnio() {
        return anio;
    }
    public void setAnio(Date anio) {
        this.anio = anio;
    }    
}
