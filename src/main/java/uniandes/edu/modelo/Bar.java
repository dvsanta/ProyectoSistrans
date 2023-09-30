package uniandes.edu.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "bares")
public class Bar {
    @id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private TipoBar tipoBar;

    public Bar(TipoBar tipoBar){
        this.tipoBar = tipoBar;
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
        return tipoBar;
    }

    public void setTipoBar(TipoBar tipoBar) {
        this.tipoBar = tipoBar;
    }

    
}