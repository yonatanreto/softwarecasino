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
import modelo.vo.Cargos;
import modelo.vo.AreaDeTrabajos;
import modelo.vo.Empleados;

/**
 *
 * @author Usuario
 */
public class EmpleadosDAO implements Serializable,utilidades.CampoUnicoDAO  {

    public EmpleadosDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void crear(Empleados empleados) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargos cargo = empleados.getCargo();
            if (cargo != null) {
                cargo = em.getReference(cargo.getClass(), cargo.getId());
                empleados.setCargo(cargo);
            }
            AreaDeTrabajos areaDeTrabajo = empleados.getAreaDeTrabajo();
            if (areaDeTrabajo != null) {
                areaDeTrabajo = em.getReference(areaDeTrabajo.getClass(), areaDeTrabajo.getId());
                empleados.setAreaDeTrabajo(areaDeTrabajo);
            }
            em.persist(empleados);
            if (cargo != null) {
                cargo.getEmpleadosList().add(empleados);
                cargo = em.merge(cargo);
            }
            if (areaDeTrabajo != null) {
                areaDeTrabajo.getEmpleadosList().add(empleados);
                areaDeTrabajo = em.merge(areaDeTrabajo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(Empleados empleados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados persistentEmpleados = em.find(Empleados.class, empleados.getId());
            Cargos cargoOld = persistentEmpleados.getCargo();
            Cargos cargoNew = empleados.getCargo();
            AreaDeTrabajos areaDeTrabajoOld = persistentEmpleados.getAreaDeTrabajo();
            AreaDeTrabajos areaDeTrabajoNew = empleados.getAreaDeTrabajo();
            if (cargoNew != null) {
                cargoNew = em.getReference(cargoNew.getClass(), cargoNew.getId());
                empleados.setCargo(cargoNew);
            }
            if (areaDeTrabajoNew != null) {
                areaDeTrabajoNew = em.getReference(areaDeTrabajoNew.getClass(), areaDeTrabajoNew.getId());
                empleados.setAreaDeTrabajo(areaDeTrabajoNew);
            }
            empleados = em.merge(empleados);
            if (cargoOld != null && !cargoOld.equals(cargoNew)) {
                cargoOld.getEmpleadosList().remove(empleados);
                cargoOld = em.merge(cargoOld);
            }
            if (cargoNew != null && !cargoNew.equals(cargoOld)) {
                cargoNew.getEmpleadosList().add(empleados);
                cargoNew = em.merge(cargoNew);
            }
            if (areaDeTrabajoOld != null && !areaDeTrabajoOld.equals(areaDeTrabajoNew)) {
                areaDeTrabajoOld.getEmpleadosList().remove(empleados);
                areaDeTrabajoOld = em.merge(areaDeTrabajoOld);
            }
            if (areaDeTrabajoNew != null && !areaDeTrabajoNew.equals(areaDeTrabajoOld)) {
                areaDeTrabajoNew.getEmpleadosList().add(empleados);
                areaDeTrabajoNew = em.merge(areaDeTrabajoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleados.getId();
                if (findEmpleados(id) == null) {
                    throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.");
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
            Empleados empleados;
            try {
                empleados = em.getReference(Empleados.class, id);
                empleados.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.", enfe);
            }
            Cargos cargo = empleados.getCargo();
            if (cargo != null) {
                cargo.getEmpleadosList().remove(empleados);
                cargo = em.merge(cargo);
            }
            AreaDeTrabajos areaDeTrabajo = empleados.getAreaDeTrabajo();
            if (areaDeTrabajo != null) {
                areaDeTrabajo.getEmpleadosList().remove(empleados);
                areaDeTrabajo = em.merge(areaDeTrabajo);
            }
            em.remove(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List findEmpleadosEntities() {
        return findEmpleadosEntities(true, -1, -1);
    }

    public List<Empleados> findEmpleadosEntities(int maxResults, int firstResult) {
        return findEmpleadosEntities(false, maxResults, firstResult);
    }

    private List<Empleados> findEmpleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleados.class));
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

    public Empleados findEmpleados(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleados.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleados> rt = cq.from(Empleados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

     public String relacionOtrasEntidades(Empleados objetoVO) {
       EntityManager em = getEntityManager();
        //entityManager.getTransaction().begin();
         try {
                String respuesta = "OK";
                Query q1 = null;

                //Relacion Abonos
                q1 = em.createQuery("select u from Ordenes as u where u.empleado=:empleado");
                q1.setParameter("empleado", objetoVO);
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

    @Override
    public Object getElementoPorCampoUnico(Object parametro) {
        EntityManager em = getEntityManager();
          try {
            TypedQuery<Empleados> consulta= em.createNamedQuery("Empleados.findByCedula", Empleados.class);
            consulta.setParameter("cedula",parametro);
            Empleados v=null;
            try{
           v=(Empleados)consulta.getSingleResult();
            
         }catch(Exception ex){
            System.out.println("ERROR "+ex.getMessage());
         }
          return v;   
       } finally {
            em.close();
        }
    }
    
}
