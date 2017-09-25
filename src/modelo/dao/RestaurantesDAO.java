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
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.vo.Restaurantes;

/**
 *
 * @author Usuario
 */
public class RestaurantesDAO implements Serializable,utilidades.CampoUnicoDAO  {

    public RestaurantesDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void crear(Restaurantes restaurantes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(restaurantes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(Restaurantes restaurantes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            restaurantes = em.merge(restaurantes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = restaurantes.getId();
                if (findRestaurantes(id) == null) {
                    throw new NonexistentEntityException("The restaurantes with id " + id + " no longer exists.");
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
            Restaurantes restaurantes;
            try {
                restaurantes = em.getReference(Restaurantes.class, id);
                restaurantes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The restaurantes with id " + id + " no longer exists.", enfe);
            }
            em.remove(restaurantes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
     public String relacionOtrasEntidades(Restaurantes objetoVO) {
       EntityManager em = getEntityManager();
        //entityManager.getTransaction().begin();
         try {
                String respuesta = "OK";
                Query q1 = null;

                //Relacion Abonos
                q1 = em.createQuery("select u from Ordenes as u where u.restaurante=:restaurante");
                q1.setParameter("restaurante", objetoVO);
                List l = q1.getResultList();
                if (!l.isEmpty()) {
                    respuesta = "Ordenes";
                    return respuesta;
                }
               

                return respuesta;
        } finally {
            em.close();
        }

    }

    public List<Restaurantes> findRestaurantesEntities() {
        return findRestaurantesEntities(true, -1, -1);
    }

    public List<Restaurantes> findRestaurantesEntities(int maxResults, int firstResult) {
        return findRestaurantesEntities(false, maxResults, firstResult);
    }

    private List<Restaurantes> findRestaurantesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Restaurantes.class));
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

    public Restaurantes findRestaurantes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Restaurantes.class, id);
        } finally {
            em.close();
        }
    }

    public int getRestaurantesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Restaurantes> rt = cq.from(Restaurantes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    @Override
    public Object getElementoPorCampoUnico(Object parametro) {
       EntityManager em = getEntityManager();
          try {
            TypedQuery<Restaurantes> consulta= em.createNamedQuery("Restaurantes.findByNit", Restaurantes.class);
            consulta.setParameter("nit",parametro);
            Restaurantes v=null;
            try{
           v=(Restaurantes)consulta.getSingleResult();
            
         }catch(Exception ex){
            System.out.println("ERROR "+ex.getMessage());
         }
          return v;   
       } finally {
            em.close();
        }
    }
    
}
