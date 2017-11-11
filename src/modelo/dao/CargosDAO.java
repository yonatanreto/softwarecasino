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
import modelo.vo.Cargos;

/**
 *
 * @author Usuario
 */
public class CargosDAO implements Serializable,utilidades.CampoUnicoDAO  {

    public CargosDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void crear(Cargos cargo) {
        if (cargo.getEmpleadosList() == null) {
            cargo.setEmpleadosList(new ArrayList<Empleados>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Empleados> attachedEmpleadosList = new ArrayList<Empleados>();
            for (Empleados empleadosListEmpleadosToAttach : cargo.getEmpleadosList()) {
                empleadosListEmpleadosToAttach = em.getReference(empleadosListEmpleadosToAttach.getClass(), empleadosListEmpleadosToAttach.getId());
                attachedEmpleadosList.add(empleadosListEmpleadosToAttach);
            }
            cargo.setEmpleadosList(attachedEmpleadosList);
            em.persist(cargo);
            for (Empleados empleadosListEmpleados : cargo.getEmpleadosList()) {
                Cargos oldCargoOfEmpleadosListEmpleados = empleadosListEmpleados.getCargo();
                empleadosListEmpleados.setCargo(cargo);
                empleadosListEmpleados = em.merge(empleadosListEmpleados);
                if (oldCargoOfEmpleadosListEmpleados != null) {
                    oldCargoOfEmpleadosListEmpleados.getEmpleadosList().remove(empleadosListEmpleados);
                    oldCargoOfEmpleadosListEmpleados = em.merge(oldCargoOfEmpleadosListEmpleados);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(Cargos cargo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargos persistentCargo = em.find(Cargos.class, cargo.getId());
            List<Empleados> empleadosListOld = persistentCargo.getEmpleadosList();
            List<Empleados> empleadosListNew = cargo.getEmpleadosList();
            List<Empleados> attachedEmpleadosListNew = new ArrayList<Empleados>();
            for (Empleados empleadosListNewEmpleadosToAttach : empleadosListNew) {
                empleadosListNewEmpleadosToAttach = em.getReference(empleadosListNewEmpleadosToAttach.getClass(), empleadosListNewEmpleadosToAttach.getId());
                attachedEmpleadosListNew.add(empleadosListNewEmpleadosToAttach);
            }
            empleadosListNew = attachedEmpleadosListNew;
            cargo.setEmpleadosList(empleadosListNew);
            cargo = em.merge(cargo);
            for (Empleados empleadosListOldEmpleados : empleadosListOld) {
                if (!empleadosListNew.contains(empleadosListOldEmpleados)) {
                    empleadosListOldEmpleados.setCargo(null);
                    empleadosListOldEmpleados = em.merge(empleadosListOldEmpleados);
                }
            }
            for (Empleados empleadosListNewEmpleados : empleadosListNew) {
                if (!empleadosListOld.contains(empleadosListNewEmpleados)) {
                    Cargos oldCargoOfEmpleadosListNewEmpleados = empleadosListNewEmpleados.getCargo();
                    empleadosListNewEmpleados.setCargo(cargo);
                    empleadosListNewEmpleados = em.merge(empleadosListNewEmpleados);
                    if (oldCargoOfEmpleadosListNewEmpleados != null && !oldCargoOfEmpleadosListNewEmpleados.equals(cargo)) {
                        oldCargoOfEmpleadosListNewEmpleados.getEmpleadosList().remove(empleadosListNewEmpleados);
                        oldCargoOfEmpleadosListNewEmpleados = em.merge(oldCargoOfEmpleadosListNewEmpleados);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cargo.getId();
                if (findCargo(id) == null) {
                    throw new NonexistentEntityException("The cargo with id " + id + " no longer exists.");
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
            Cargos cargo;
            try {
                cargo = em.getReference(Cargos.class, id);
                cargo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargo with id " + id + " no longer exists.", enfe);
            }
            List<Empleados> empleadosList = cargo.getEmpleadosList();
            for (Empleados empleadosListEmpleados : empleadosList) {
                empleadosListEmpleados.setCargo(null);
                empleadosListEmpleados = em.merge(empleadosListEmpleados);
            }
            em.remove(cargo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List findCargoEntities() {
        return findCargoEntities(true, -1, -1);
    }
    
//    public List findCargoEntitiesAbstracCodigo() {
//        return findCargoEntities(true, -1, -1);
//    }

    public List<Cargos> findCargoEntities(int maxResults, int firstResult) {
        return findCargoEntities(false, maxResults, firstResult);
    }

    private List<Cargos> findCargoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cargos.class));
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

    public Cargos findCargo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cargos.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cargos> rt = cq.from(Cargos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public String relacionOtrasEntidades(Cargos objetoVO) {
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
    public Object getElementoPorCampoUnico1(Object parametro) {
        EntityManager em = getEntityManager();
          try {
            TypedQuery<Cargos> consulta= em.createNamedQuery("Cargos.findByCodigo", Cargos.class);
            consulta.setParameter("codigo",parametro);
            Cargos v=null;
            try{
           v=(Cargos)consulta.getSingleResult();
            
         }catch(Exception ex){
            System.out.println("ERROR "+ex.getMessage());
         }
          return v;   
       } finally {
            em.close();
        }
    }

    @Override
    public Object getElementoPorCampoUnico2(Object parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
