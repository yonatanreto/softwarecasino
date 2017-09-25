/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenes.findAll", query = "SELECT o FROM Ordenes o")
    , @NamedQuery(name = "Ordenes.findById", query = "SELECT o FROM Ordenes o WHERE o.id = :id")
    , @NamedQuery(name = "Ordenes.findByCodigo", query = "SELECT o FROM Ordenes o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "Ordenes.findByEstado", query = "SELECT o FROM Ordenes o WHERE o.estado = :estado")
    , @NamedQuery(name = "Ordenes.findByFecha", query = "SELECT o FROM Ordenes o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "Ordenes.findByFechaInicialFinal", query = "SELECT o FROM Ordenes o WHERE o.fecha >=:fechaInicial and o.fecha <=:fechaFinal ")
    , @NamedQuery(name = "Ordenes.findByHora", query = "SELECT o FROM Ordenes o WHERE o.hora = :hora")
    , @NamedQuery(name = "Ordenes.findByEmpleado", query = "SELECT o FROM Ordenes o WHERE o.empleado = :empleado")
    , @NamedQuery(name = "Ordenes.findByRestaurante", query = "SELECT o FROM Ordenes o WHERE o.restaurante = :restaurante")
    , @NamedQuery(name = "Ordenes.findByUsuario", query = "SELECT o FROM Ordenes o WHERE o.usuario = :usuario")})
public class Ordenes implements Serializable {

    /**
     * @return the empleado
     */
    public Empleados getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the restaurante
     */
    public Restaurantes getRestaurante() {
        return restaurante;
    }

    /**
     * @param restaurante the restaurante to set
     */
    public void setRestaurante(Restaurantes restaurante) {
        this.restaurante = restaurante;
    }

    /**
     * @return the usuario
     */
    public Usuarios getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Column(name = "estado")
    private Integer estado;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date hora;
      
    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Empleados empleado;
    
   
    @JoinColumn(name = "restaurante", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Restaurantes restaurante;
    
   
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuarios usuario;

    public Ordenes() {
    }

    public Ordenes(Integer id) {
        this.id = id;
    }

    public Ordenes(Integer id, int codigo, Date fecha, Date hora, Empleados empleado, Restaurantes restaurante, Usuarios usuario) {
        this.id = id;
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.empleado = empleado;
        this.restaurante = restaurante;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
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
        if (!(object instanceof Ordenes)) {
            return false;
        }
        Ordenes other = (Ordenes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.vo.Ordenes[ id=" + id + " ]";
    }
    
}
