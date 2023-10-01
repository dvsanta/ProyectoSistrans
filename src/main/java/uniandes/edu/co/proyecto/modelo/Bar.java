package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "bares")
public class Bar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private TipoBar tipo;

    public Bar(TipoBar tipoBar){
        this.tipo = tipoBar;
    }

    public Bar()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoBar getTipoBar() {
        return tipo;
    }

    public void setTipoBar(TipoBar tipoBar) {
        this.tipo = tipoBar;
    }

    
}