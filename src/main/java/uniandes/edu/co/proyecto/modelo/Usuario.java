package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String correo_electronico;
    @ManyToOne
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    private TipoUsuario tipo;

    public Usuario(String nombre,String correo_electronico,TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.tipo = tipoUsuario;
    }

    public Usuario()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    public TipoUsuario getTipoUsuario() {
        return tipo;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipo = tipoUsuario;
    }


}
