package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="planes_consumo")
public class PlanConsumo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tipo;
    private Integer descuento_general;
    private Boolean bebidas_ilimitadas;
    private Boolean internet_ilimitado;
    
    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "id")
    private Hotel id_hotel;

    public PlanConsumo(String tipo, Integer descuentoGeneral, Boolean bebidasIlimitadas, Boolean internetIlimitado) {
        this.tipo = tipo;
        this.descuento_general = descuentoGeneral;
        this.bebidas_ilimitadas = bebidasIlimitadas;
        this.internet_ilimitado = internetIlimitado;
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
        return descuento_general;
    }

    public void setDescuentoGeneral(Integer descuentoGeneral) {
        this.descuento_general = descuentoGeneral;
    }

    public Boolean getBebidasIlimitadas() {
        return bebidas_ilimitadas;
    }

    public void setBebidasIlimitadas(Boolean bebidasIlimitadas) {
        this.bebidas_ilimitadas = bebidasIlimitadas;
    }

    public Boolean getInternetIlimitado() {
        return internet_ilimitado;
    }

    public void setInternetIlimitado(Boolean internetIlimitado) {
        this.internet_ilimitado = internetIlimitado;
    }

    
}
