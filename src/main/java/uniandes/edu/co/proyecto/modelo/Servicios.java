package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios")
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer precio_unitario;

    public Servicios(Integer precioUnitario) {
        this.precio_unitario = precioUnitario;
    }

    public Servicios()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrecioUnitario() {
        return precio_unitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precio_unitario = precioUnitario;
    }
}
