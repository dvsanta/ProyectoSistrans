package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurantes")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private TipoRestaurante tipo;

    public Restaurante(TipoRestaurante tipoRestaurante) {
        this.tipo = tipoRestaurante;
    }

    public Restaurante()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoRestaurante getTipoRestaurante() {
        return tipo;
    }

    public void setTipoRestaurante(TipoRestaurante tipoRestaurante) {
        this.tipo = tipoRestaurante;
    }

    
}