package uniandes.edu.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservaHabitacion")
public class ReservaHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer numPersonas;
    private String tipoPlan;
    private Date diaEntrada;
    private Date mesEntrada;
    private Date anoEntrada;
    private Integer horaEntrada;
    private Date diaSalida;
    private Date mesSalida;
    private Date anoSalida;
    private Integer horaSalida;
    

    public ReservaHabitacion() {;}

    public ReservaHabitacion(Integer numPersonas, String tipoPlan, Date diaEntrada, Date mesEntrada,
            Date anoEntrada, Integer horaEntrada, Date diaSalida, Date mesSalida, Date anoSalida, Integer horaSalida) {
        this.numPersonas = numPersonas;
        this.tipoPlan = tipoPlan;
        this.diaEntrada = diaEntrada;
        this.mesEntrada = mesEntrada;
        this.anoEntrada = anoEntrada;
        this.horaEntrada = horaEntrada;
        this.diaSalida = diaSalida;
        this.mesSalida = mesSalida;
        this.anoSalida = anoSalida;
        this.horaSalida = horaSalida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(Integer numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public Date getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(Date diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public Date getMesEntrada() {
        return mesEntrada;
    }

    public void setMesEntrada(Date mesEntrada) {
        this.mesEntrada = mesEntrada;
    }

    public Date getAnoEntrada() {
        return anoEntrada;
    }

    public void setAnoEntrada(Date anoEntrada) {
        this.anoEntrada = anoEntrada;
    }

    public Integer getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Integer horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(Date diaSalida) {
        this.diaSalida = diaSalida;
    }

    public Date getMesSalida() {
        return mesSalida;
    }

    public void setMesSalida(Date mesSalida) {
        this.mesSalida = mesSalida;
    }

    public Date getAnoSalida() {
        return anoSalida;
    }

    public void setAnoSalida(Date anoSalida) {
        this.anoSalida = anoSalida;
    }

    public Integer getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Integer horaSalida) {
        this.horaSalida = horaSalida;
    }

    
}
