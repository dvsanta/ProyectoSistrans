package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "gimnasios")
public class Gimnasio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer maquinas;

    public Gimnasio(Integer maquinas) {
        this.maquinas = maquinas;
    }
    public Gimnasio()
    {;}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getMaquinas() {
        return maquinas;
    }
    public void setMaquinas(Integer maquinas) {
        this.maquinas = maquinas;
    }

    
}
