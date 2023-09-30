package uniandes.edu.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="planesConsumos")
public class PlanConsumo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tipo;
    private Integer descuentoGeneral;
    private Boolean bebidasIlimitadas;
    private Boolean internetIlimitado;

    public PlanConsumo(String tipo, Integer descuentoGeneral, Boolean bebidasIlimitadas, Boolean internetIlimitado) {
        this.tipo = tipo;
        this.descuentoGeneral = descuentoGeneral;
        this.bebidasIlimitadas = bebidasIlimitadas;
        this.internetIlimitado = internetIlimitado;
    }

    public PlanConsumo()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getDescuentoGeneral() {
        return descuentoGeneral;
    }

    public void setDescuentoGeneral(Integer descuentoGeneral) {
        this.descuentoGeneral = descuentoGeneral;
    }

    public Boolean getBebidasIlimitadas() {
        return bebidasIlimitadas;
    }

    public void setBebidasIlimitadas(Boolean bebidasIlimitadas) {
        this.bebidasIlimitadas = bebidasIlimitadas;
    }

    public Boolean getInternetIlimitado() {
        return internetIlimitado;
    }

    public void setInternetIlimitado(Boolean internetIlimitado) {
        this.internetIlimitado = internetIlimitado;
    }

    
}
