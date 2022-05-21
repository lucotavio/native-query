package br.com.luciano.nativequery.repository;

import br.com.luciano.nativequery.entity.Socio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class SocioRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Socio> listarTodos(){
        TypedQuery<Socio> query= em.createNamedQuery("socio_todos", Socio.class);
        List<Socio> socios = query.getResultList() ;


        return socios;


    }
}
