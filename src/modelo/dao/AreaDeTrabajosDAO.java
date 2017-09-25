/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.vo.Empleados;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.vo.AreaDeTrabajos;

/**
 *
 * @author Usuario
 */
public class AreaDeTrabajosDAO implements Serializable,utilidades.CampoUnicoDAO  {

    public AreaDeTrabajosDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void crear(AreaDeTrabajos areaDeTrabajo) {
        if (areaDeTrabajo.getEmpleadosList() == null) {
            areaDeTrabajo.setEmpleadosList(new ArrayList<Empleados>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Empleados> attachedEmpleadosList = new ArrayList<Empleados>();
            for (Empleados empleadosListEmpleadosToAttach : areaDeTrabajo.getEmpleadosList()) {
                empleadosListEmpleadosToAttach = em.getReference(empleadosListEmpleadosToAttach.getClass(), empleadosListEmpleadosToAttach.getId());
                attachedEmpleadosList.add(empleadosListEmpleadosToAttach);
            }
            areaDeTrabajo.setEmpleadosList(attachedEmpleadosList);
            em.persist(areaDeTrabajo);
            for (Empleados empleadosListEmpleados : areaDeTrabajo.getEmpleadosList()) {
                AreaDeTrabajos oldAreaDeTrabajoOfEmpleadosListEmpleados = empleadosListEmpleados.getAreaDeTrabajo();
                empleadosListEmpleados.setAreaDeTrabajo(areaDeTrabajo);
                empleadosListEmpleados = em.merge(empleadosListEmpleados);
                if (oldAreaDeTrabajoOfEmpleadosListEmpleados != null) {
                    oldAreaDeTrabajoOfEmpleadosListEmpleados.getEmpleadosList().remove(empleadosListEmpleados);
                    oldAreaDeTrabajoOfEmpleadosListEmpleados = em.merge(oldAreaDeTrabajoOfEmpleadosListEmpleados);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(AreaDeTrabajos areaDeTrabajo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AreaDeTrabajos persistentAreaDeTrabajo = em.find(AreaDeTrabajos.class, areaDeTrabajo.getId());
            List<Empleados> empleadosListOld = persistentAreaDeTrabajo.getEmpleadosList();
            List<Empleados> empleadosListNew = areaDeTrabajo.getEmpleadosList();
            List<Empleados> attachedEmpleadosListNew = new ArrayList<Empleados>();
            for (Empleados empleadosListNewEmpleadosToAttach : empleadosListNew) {
                empleadosListNewEmpleadosToAttach = em.getReference(empleadosListNewEmpleadosToAttach.getClass(), empleadosListNewEmpleadosToAttach.getId());
                attachedEmpleadosListNew.add(empleadosListNewEmpleadosToAttach);
            }
            empleadosListNew = attachedEmpleadosListNew;
            areaDeTrabajo.setEmpleadosList(empleadosListNew);
            areaDeTrabajo = em.merge(areaDeTrabajo);
            for (Empleados empleadosListOldEmpleados : empleadosListOld) {
                if (!empleadosListNew.contains(empleadosListOldEmpleados)) {
                    empleadosListOldEmpleados.setAreaDeTrabajo(null);
                    empleadosListOldEmpleados = em.merge(empleadosListOldEmpleados);
                }
            }
            for (Empleados empleadosListNewEmpleados : empleadosListNew) {
                if (!empleadosListOld.contains(empleadosListNewEmpleados)) {
                    AreaDeTrabajos oldAreaDeTrabajoOfEmpleadosListNewEmpleados = empleadosListNewEmpleados.getAreaDeTrabajo();
                    empleadosListNewEmpleados.setAreaDeTrabajo(areaDeTrabajo);
                    empleadosListNewEmpleados = em.merge(empleadosListNewEmpleados);
                    if (oldAreaDeTrabajoOfEmpleadosListNewEmpleados != null && !oldAreaDeTrabajoOfEmpleadosListNewEmpleados.equals(areaDeTrabajo)) {
                        oldAreaDeTrabajoOfEmpleadosListNewEmpleados.getEmpleadosList().remove(empleadosListNewEmpleados);
                        oldAreaDeTrabajoOfEmpleadosListNewEmpleados = em.merge(oldAreaDeTrabajoOfEmpleadosListNewEmpleados);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = areaDeTrabajo.getId();
                if (findAreaDeTrabajo(id) == null) {
                    throw new NonexistentEntityException("The areaDeTrabajo with id " + id + " no longer exists.");
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
            AreaDeTrabajos areaDeTrabajo;
            try {
                areaDeTrabajo = em.getReference(AreaDeTrabajos.class, id);
                areaDeTrabajo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The areaDeTrabajo with id " + id + " no longer exists.", enfe);
            }
            List<Empleados> empleadosList = areaDeTrabajo.getEmpleadosList();
            for (Empleados empleadosListEmpleados : empleadosList) {
                empleadosListEmpleados.setAreaDeTrabajo(null);
                empleadosListEmpleados = em.merge(empleadosListEmpleados);
            }
            em.remove(areaDeTrabajo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List findAreaDeTrabajoEntities() {
        return findAreaDeTrabajoEntities(true, -1, -1);
    }
    
//    public List findAreaDeTrabajoEntitiesAbstractCodigo() {
//        return findAreaDeTrabajoEntities(true, -1, -1);
//    }

    public List<AreaDeTrabajos> findAreaDeTrabajoEntities(int maxResults, int firstResult) {
        return findAreaDeTrabajoEntities(false, maxResults, firstResult);
    }

    private List<AreaDeTrabajos> findAreaDeTrabajoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AreaDeTrabajos.class));
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

    public AreaDeTrabajos findAreaDeTrabajo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AreaDeTrabajos.class, id);
        } finally {
            em.close();
        }
    }

    public int getAreaDeTrabajoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AreaDeTrabajos> rt = cq.from(AreaDeTrabajos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public String relacionOtrasEntidades(AreaDeTrabajos objetoVO) {
       EntityManager em = getEntityManager();
        //entityManager.getTransaction().begin();
         try {
                String respuesta = "OK";
//                Query q1 = null;
//
//                //Relacion Abonos
//                q1 = em.createQuery("select u from Usuarios as u where u.usuarios=:id");
//                q1.setParameter("usuario", usuario);
//                List l = q1.getResultList();
//                if (!l.isEmpty()) {
//                    respuesta = "Entidad";
//                    return respuesta;
//                }
               

                return respuesta;
        } finally {
            em.close();
        }

    }

    @Override
    public Object getElementoPorCampoUnico(Object parametro) {
        EntityManager em = getEntityManager();
          try {
            TypedQuery<AreaDeTrabajos> consulta= em.createNamedQuery("AreaDeTrabajos.findByCodigo", AreaDeTrabajos.class);
            consulta.setParameter("codigo",parametro);
            AreaDeTrabajos v=null;
            try{
           v=(AreaDeTrabajos)consulta.getSingleResult();
            
         }catch(Exception ex){
            System.out.println("ERROR "+ex.getMessage());
         }
          return v;   
       } finally {
            em.close();
        }
    }
    
}
