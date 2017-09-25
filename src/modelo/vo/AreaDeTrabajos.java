/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import com.nextic.filtercomponent.components.AbstractCodigo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "area_de_trabajos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaDeTrabajos.findAll", query = "SELECT a FROM AreaDeTrabajos a")
    , @NamedQuery(name = "AreaDeTrabajos.findById", query = "SELECT a FROM AreaDeTrabajos a WHERE a.id = :id")
    , @NamedQuery(name = "AreaDeTrabajos.findByCodigo", query = "SELECT a FROM AreaDeTrabajos a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "AreaDeTrabajos.findByNombre", query = "SELECT a FROM AreaDeTrabajos a WHERE a.nombre = :nombre")})
public class AreaDeTrabajos implements Serializable,AbstractCodigo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false, length = 45)
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @OneToMany(mappedBy = "areaDeTrabajo", fetch = FetchType.LAZY)
    private List<Empleados> empleadosList;

    public AreaDeTrabajos() {
    }

    public AreaDeTrabajos(Integer id) {
        this.id = id;
    }

    public AreaDeTrabajos(Integer id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
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
        if (!(object instanceof AreaDeTrabajos)) {
            return false;
        }
        AreaDeTrabajos other = (AreaDeTrabajos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return   nombre;
    }

    @Override
    public String getCodigo_abs() {
       return codigo;
    }

    @Override
    public String getNombre_abs() {
       return nombre;
    }
    
}
