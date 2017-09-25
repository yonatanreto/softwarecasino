/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Conexion;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.dao.exceptions.PreexistingEntityException;
import modelo.vo.ConfiguracionImpresionOrden;

/**
 *
 * @author Usuario
 */
public class ConfiguracionImpresionOrdenDAO implements Serializable {
    
    public ConfiguracionImpresionOrdenDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void crear(ConfiguracionImpresionOrden configuracionImpresionOrden) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(configuracionImpresionOrden);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConfiguracionImpresionOrden(configuracionImpresionOrden.getId()) != null) {
                throw new PreexistingEntityException("ConfiguracionImpresionOrden " + configuracionImpresionOrden + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(ConfiguracionImpresionOrden configuracionImpresionOrden) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            configuracionImpresionOrden = em.merge(configuracionImpresionOrden);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = configuracionImpresionOrden.getId();
                if (findConfiguracionImpresionOrden(id) == null) {
                    throw new NonexistentEntityException("The configuracionImpresionOrden with id " + id + " no longer exists.");
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
            ConfiguracionImpresionOrden configuracionImpresionOrden;
            try {
                configuracionImpresionOrden = em.getReference(ConfiguracionImpresionOrden.class, id);
                configuracionImpresionOrden.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The configuracionImpresionOrden with id " + id + " no longer exists.", enfe);
            }
            em.remove(configuracionImpresionOrden);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ConfiguracionImpresionOrden> findConfiguracionImpresionOrdenEntities() {
        return findConfiguracionImpresionOrdenEntities(true, -1, -1);
    }

    public List<ConfiguracionImpresionOrden> findConfiguracionImpresionOrdenEntities(int maxResults, int firstResult) {
        return findConfiguracionImpresionOrdenEntities(false, maxResults, firstResult);
    }

    private List<ConfiguracionImpresionOrden> findConfiguracionImpresionOrdenEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ConfiguracionImpresionOrden.class));
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

    public ConfiguracionImpresionOrden findConfiguracionImpresionOrden(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ConfiguracionImpresionOrden.class, id);
        } finally {
            em.close();
        }
    }

    public int getConfiguracionImpresionOrdenCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ConfiguracionImpresionOrden> rt = cq.from(ConfiguracionImpresionOrden.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public static ConfiguracionImpresionOrden getConfiguracionImpresionOrden(){
        EntityManager em = Conexion.f.createEntityManager();
         try {
            TypedQuery<ConfiguracionImpresionOrden> consulta= em.createNamedQuery("ConfiguracionImpresionOrden.findAll", ConfiguracionImpresionOrden.class);
//            consulta.setParameter("cedula",parametro);
            ConfiguracionImpresionOrden v=null;
            try{
           v=(ConfiguracionImpresionOrden)consulta.getSingleResult();
            
         }catch(Exception ex){
            System.out.println("ERROR "+ex.getMessage());
         }
          return v;   
       } finally {
            em.close();
        }
    }
    
     public static void editarStatic(ConfiguracionImpresionOrden configuracionImpresionOrden) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = Conexion.f.createEntityManager();
            em.getTransaction().begin();
            configuracionImpresionOrden = em.merge(configuracionImpresionOrden);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                
                    throw new NonexistentEntityException("The configuracionImpresionOrden no longer exists.");
                
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
