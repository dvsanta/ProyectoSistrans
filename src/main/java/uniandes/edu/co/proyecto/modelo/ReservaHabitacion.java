package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "reservas_habitaciones")
public class ReservaHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer num_personas;
    private Integer dia_entrada;
    private Integer mes_entrada;
    private Integer anio_entrada;
    private Integer dia_salida;
    private Integer mes_salida;
    private Integer anio_salida;

    @ManyToOne
    @JoinColumn(name = "id_suario", referencedColumnName = "id")
    private Usuario id_usuario;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    private Usuario id_habitacion;

    public ReservaHabitacion() {;}

    public ReservaHabitacion(Integer numPersonas, Integer diaEntrada, Integer mesEntrada,
            Integer anioEntrada, Integer diaSalida, Integer mesSalida, Integer anioSalida) {
        this.num_personas = numPersonas;
        this.dia_entrada = diaEntrada;
        this.mes_entrada = mesEntrada;
        this.anio_entrada = anioEntrada;
        this.dia_salida = diaSalida;
        this.mes_salida = mesSalida;
        this.anio_salida = anioSalida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumPersonas() {
        return num_personas;
    }

    public void setNumPersonas(Integer numPersonas) {
        this.num_personas = numPersonas;
    }

    public Integer getDiaEntrada() {
        return dia_entrada;
    }

    public void setDiaEntrada(Integer diaEntrada) {
        this.dia_entrada = diaEntrada;
    }

    public Integer getMesEntrada() {
        return mes_entrada;
    }

    public void setMesEntrada(Integer mesEntrada) {
        this.mes_entrada = mesEntrada;
    }

    public Integer getAnioEntrada() {
        return anio_entrada;
    }

    public void setAnioEntrada(Integer anioEntrada) {
        this.anio_entrada = anioEntrada;
    }

    public Integer getDiaSalida() {
        return dia_salida;
    }

    public void setDiaSalida(Integer diaSalida) {
        this.dia_salida = diaSalida;
    }

    public Integer getMesSalida() {
        return mes_salida;
    }

    public void setMesSalida(Integer mesSalida) {
        this.mes_salida = mesSalida;
    }

    public Integer getAnioSalida() {
        return anio_salida;
    }

    public void setAnioSalida(Integer anioSalida) {
        this.anio_salida = anioSalida;
    }

    public Usuario getIdUsuario() {return id_usuario;}

    public void setIdUsuario(Usuario id_usuario) {this.id_usuario = id_usuario;}

    public Usuario getIdHabitacion() {return id_habitacion;}

    public void setIdHabitacion(Usuario id_habitacion) {this.id_habitacion = id_habitacion;}
    
}
