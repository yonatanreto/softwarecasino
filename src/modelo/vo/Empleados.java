/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import com.nextic.filtercomponent.components.AbstractCodigo;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "empleados", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cedula"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findById", query = "SELECT e FROM Empleados e WHERE e.id = :id")
    , @NamedQuery(name = "Empleados.findByCedula", query = "SELECT e FROM Empleados e WHERE e.cedula = :cedula")
    , @NamedQuery(name = "Empleados.findByCodigo", query = "SELECT e FROM Empleados e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "Empleados.findByTipoDocumento", query = "SELECT e FROM Empleados e WHERE e.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Empleados.findByNombres", query = "SELECT e FROM Empleados e WHERE e.nombres = :nombres")
    , @NamedQuery(name = "Empleados.findByApellido1", query = "SELECT e FROM Empleados e WHERE e.apellido1 = :apellido1")
    , @NamedQuery(name = "Empleados.findByApellido2", query = "SELECT e FROM Empleados e WHERE e.apellido2 = :apellido2")})
public class Empleados implements Serializable,AbstractCodigo {

   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cedula", nullable = false, length = 50)
    private String cedula;
    @Column(name = "tipo_documento", length = 45)
    private String tipoDocumento;
    @Column(name = "nombres", length = 50)
    private String nombres;
    @Column(name = "apellido1", length = 50)
    private String apellido1;
    @Column(name = "apellido2", length = 50)
    private String apellido2;
    @JoinColumn(name = "cargo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cargos cargo;
    @JoinColumn(name = "area_de_trabajo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private AreaDeTrabajos areaDeTrabajo;
    
    @Column(name = "codigo", length = 100)
    private String codigo;
    
    @Column(name = "cupo_ordenes")
    private Integer cupoOrdenes;

    public Empleados() {
    }

    public Empleados(Integer id) {
        this.id = id;
    }

    public Empleados(Integer id, String cedula) {
        this.id = id;
        this.cedula = cedula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public AreaDeTrabajos getAreaDeTrabajo() {
        return areaDeTrabajo;
    }

    public void setAreaDeTrabajo(AreaDeTrabajos areaDeTrabajo) {
        this.areaDeTrabajo = areaDeTrabajo;
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
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return apellido1+" "+apellido2+" "+nombres;
    }

    @Override
    public String getCodigo_abs() {
        return cedula;
    }

    @Override
    public String getNombre_abs() {
       return toString();
    }
    
     /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cupoOrdenes
     */
    public Integer getCupoOrdenes() {
        return cupoOrdenes;
    }

    /**
     * @param cupoOrdenes the cupoOrdenes to set
     */
    public void setCupoOrdenes(Integer cupoOrdenes) {
        this.cupoOrdenes = cupoOrdenes;
    }

    
}
