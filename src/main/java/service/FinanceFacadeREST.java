/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Finance;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Convert;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Kabiraj
 */
@Stateless
@Path("entities.finance")
public class FinanceFacadeREST extends AbstractFacade<Finance> {
    @PersistenceContext(unitName = "com.mycompany_FinanceCompany_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public FinanceFacadeREST() {
        super(Finance.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Finance entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Finance entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Finance find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Finance> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Finance> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    


//    Find Amount of given Account Number
    @GET
    @Path("findMyAmount/{AccountNo}")
    @Produces({"text/plain"})
    public double getAmount(@PathParam("AccountNo") String account){
       // System.out.println(id);
//        try{
//            Finance f = super.findAmount(account);
//            return f.getAmount();
//        }catch(Exception e){
//            return 0;
//        }
        return super.findAmount(account);
    }
    

    
    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
