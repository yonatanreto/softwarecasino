/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "configuracion_impresion_orden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracionImpresionOrden.findAll", query = "SELECT c FROM ConfiguracionImpresionOrden c")
    , @NamedQuery(name = "ConfiguracionImpresionOrden.findById", query = "SELECT c FROM ConfiguracionImpresionOrden c WHERE c.id = :id")
    , @NamedQuery(name = "ConfiguracionImpresionOrden.findByConsecutivoOrden", query = "SELECT c FROM ConfiguracionImpresionOrden c WHERE c.consecutivoOrden = :consecutivoOrden")
    , @NamedQuery(name = "ConfiguracionImpresionOrden.findByEncabezadoImpresionOrden", query = "SELECT c FROM ConfiguracionImpresionOrden c WHERE c.encabezadoImpresionOrden = :encabezadoImpresionOrden")
    , @NamedQuery(name = "ConfiguracionImpresionOrden.findByPiedepaginaImpresionOrden", query = "SELECT c FROM ConfiguracionImpresionOrden c WHERE c.piedepaginaImpresionOrden = :piedepaginaImpresionOrden")})
public class ConfiguracionImpresionOrden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "consecutivo_orden")
    private Integer consecutivoOrden;
    @Column(name = "encabezado_impresion_orden")
    private String encabezadoImpresionOrden;
    @Column(name = "piedepagina_impresion_orden")
    private String piedepaginaImpresionOrden;

    public ConfiguracionImpresionOrden() {
    }

    public ConfiguracionImpresionOrden(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConsecutivoOrden() {
        return consecutivoOrden;
    }

    public void setConsecutivoOrden(Integer consecutivoOrden) {
        this.consecutivoOrden = consecutivoOrden;
    }

    public String getEncabezadoImpresionOrden() {
        return encabezadoImpresionOrden;
    }

    public void setEncabezadoImpresionOrden(String encabezadoImpresionOrden) {
        this.encabezadoImpresionOrden = encabezadoImpresionOrden;
    }

    public String getPiedepaginaImpresionOrden() {
        return piedepaginaImpresionOrden;
    }

    public void setPiedepaginaImpresionOrden(String piedepaginaImpresionOrden) {
        this.piedepaginaImpresionOrden = piedepaginaImpresionOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracionImpresionOrden)) {
            return false;
        }
        ConfiguracionImpresionOrden other = (ConfiguracionImpresionOrden) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.vo.ConfiguracionImpresionOrden[ id=" + id + " ]";
    }
    
}
