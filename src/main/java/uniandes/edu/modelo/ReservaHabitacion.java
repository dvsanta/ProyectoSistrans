package uniandes.edu.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservasHabitaciones")
public class ReservaHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer numPersonas;
    private String tipoPlan;
    private Integer diaEntrada;
    private Integer mesEntrada;
    private Integer anioEntrada;
    private Integer horaEntrada;
    private Integer diaSalida;
    private Integer mesSalida;
    private Integer anioSalida;
    private Integer horaSalida;
    

    public ReservaHabitacion() {;}

    public ReservaHabitacion(Integer numPersonas, String tipoPlan, Integer diaEntrada, Integer mesEntrada,
            Integer anioEntrada, Integer horaEntrada, Integer diaSalida, Integer mesSalida, Integer anioSalida, Integer horaSalida) {
        this.numPersonas = numPersonas;
        this.tipoPlan = tipoPlan;
        this.diaEntrada = diaEntrada;
        this.mesEntrada = mesEntrada;
        this.anioEntrada = anioEntrada;
        this.horaEntrada = horaEntrada;
        this.diaSalida = diaSalida;
        this.mesSalida = mesSalida;
        this.anioSalida = anioSalida;
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

    public Integer getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(Integer diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public Integer getMesEntrada() {
        return mesEntrada;
    }

    public void setMesEntrada(Integer mesEntrada) {
        this.mesEntrada = mesEntrada;
    }

    public Integer getAnioEntrada() {
        return anioEntrada;
    }

    public void setAnioEntrada(Integer anioEntrada) {
        this.anioEntrada = anioEntrada;
    }

    public Integer getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Integer horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Integer getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(Integer diaSalida) {
        this.diaSalida = diaSalida;
    }

    public Integer getMesSalida() {
        return mesSalida;
    }

    public void setMesSalida(Integer mesSalida) {
        this.mesSalida = mesSalida;
    }

    public Integer getAnioSalida() {
        return anioSalida;
    }

    public void setAnioSalida(Integer anioSalida) {
        this.anioSalida = anioSalida;
    }

    public Integer getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Integer horaSalida) {
        this.horaSalida = horaSalida;
    }

    
}
