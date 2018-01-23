/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.FlushModeType;
import javax.persistence.SynchronizationType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Conexion;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.vo.Empleados;
import modelo.vo.Restaurantes;
import modelo.vo.Ordenes;
import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author Usuario
 */
public class OrdenesDAO implements Serializable {

    public OrdenesDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
//    public EntityManager getEntityManagerPersonalizado() {
//        
//        Map parameters = new HashMap();
//        parameters.put("eclipselink.flush-clear.cache","Merge");
//        EntityManager em= emf.createEntityManager(parameters);
//        em.clear();
//        return em;
//    }

    public void crear(Ordenes ordenes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ordenes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(Ordenes ordenes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ordenes = em.merge(ordenes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ordenes.getId();
                if (findOrdenes(id) == null) {
                    throw new NonexistentEntityException("The ordenes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void eliminar(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordenes ordenes;
            try {
                ordenes = em.getReference(Ordenes.class, id);
                ordenes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordenes with id " + id + " no longer exists.", enfe);
            }
            em.remove(ordenes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordenes> findOrdenesEntities() {
        return findOrdenesEntities(true, -1, -1);
    }

    public List<Ordenes> findOrdenesEntities(int maxResults, int firstResult) {
        return findOrdenesEntities(false, maxResults, firstResult);
    }

    private List<Ordenes> findOrdenesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordenes.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ordenes findOrdenes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordenes.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdenesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordenes> rt = cq.from(Ordenes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
      public List<Ordenes> findOrdenesEntitiesPorFechas(Date fechaInicial,Date fechaFinal) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Ordenes> q= em.createNamedQuery("Ordenes.findByFechaInicialFinal", Ordenes.class);           
            q.setParameter("fechaInicial",fechaInicial);
            q.setParameter("fechaFinal",fechaFinal);
            q.setHint(QueryHints.CACHE_USAGE,"DoNotCheckCache");
           
            return q.getResultList();
        } finally {
            em.close();
        }
    }
      
       public List<Ordenes> findOrdenesEntitiesPorFechaEmpleado(Date fecha,Empleados empleado) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Ordenes> q= em.createNamedQuery("Ordenes.findByFechaEmpleado", Ordenes.class);           
            q.setParameter("fecha",fecha);
            q.setParameter("empleado",empleado);
            
            return q.getResultList();
        } finally {
            em.close();
        }
    }
       
        public int findOrdenesEntitiesPorFechasEmpleado(Date fechaInicial,Date fechaFinal,Empleados empleado) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery q= em.createNamedQuery("Ordenes.CantidadFechaInicialFinalEmpleado", Ordenes.class);           
            q.setParameter("fechaInicial",fechaInicial);
            q.setParameter("fechaFinal",fechaFinal);
            q.setParameter("empleado",empleado);
             int cantidad = ((Number) q.getSingleResult()).intValue();
            return cantidad;
        } finally {
            em.close();
        }
    }
        
        
             
             public List<Ordenes> findOrdenesEntitiesPorFechasRestaurante(Date fechaInicial,Date fechaFinal,Restaurantes restaurante) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Ordenes> q= em.createNamedQuery("Ordenes.findByFechaInicialFinalRestaurante", Ordenes.class);           
            q.setParameter("fechaInicial",fechaInicial);
            q.setParameter("fechaFinal",fechaFinal);
            q.setParameter("restaurante",restaurante);
            
            return q.getResultList();
        } finally {
            em.close();
        }
    }
        
      
         public Ordenes findOrdenesNumeroOrden(String parametro) {
             
            EntityManager em = getEntityManager();
               try {
                 
                 TypedQuery<Ordenes> consulta= em.createNamedQuery("Ordenes.findByCodigo", Ordenes.class);
                 consulta.setParameter("codigo",parametro);
                 Ordenes v=null;
                 try{
                v=(Ordenes)consulta.getSingleResult();

              }catch(Exception ex){
                 System.out.println("ERROR "+ex.getMessage());
              }
               return v;   
            } finally {
                 em.close();
             }
    }
    //TypedQuery<Usuarios> consultaAlumnos= em.createNamedQuery("Usuarios.findByUsuario", Usuarios.class);
    
}
