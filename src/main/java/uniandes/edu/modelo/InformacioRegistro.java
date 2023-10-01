package uniandes.edu.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "informacionRegistros")
public class InformacioRegistro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private Integer diaEntrada;
    private Integer mesEntrada;
    private Integer anioEntrada;
    private Integer diaSalida;
    private Integer mesSalida;
    private Integer anioSalida;

    public InformacioRegistro() {;}
    public InformacioRegistro(Integer diaEntrada, Integer mesEntrada, Integer anioEntrada, Integer diaSalida, Integer mesSalida, Integer anioSalida) {
        this.diaEntrada = diaEntrada;
        this.mesEntrada = mesEntrada;
        this.anioEntrada = anioEntrada;
        this.diaSalida = diaSalida;
        this.mesSalida = mesSalida;
        this.anioSalida = anioSalida;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
}
