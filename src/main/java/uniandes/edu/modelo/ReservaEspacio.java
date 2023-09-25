package uniandes.edu.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservaEspacio")
public class ReservaEspacio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date fecha;
    private Integer hora;
    private Integer minuto;
   
   public ReservaEspacio()
   {;}
    
    public ReservaEspacio(Date fecha, Integer hora, Integer minuto) {
        this.fecha = fecha;
        this.hora = hora;
        this.minuto = minuto;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Integer getHora() {
        return hora;
    }
    public void setHora(Integer hora) {
        this.hora = hora;
    }
    public Integer getMinuto() {
        return minuto;
    }
    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    
}
