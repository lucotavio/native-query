package br.com.luciano.nativequery.repository;

import br.com.luciano.nativequery.entity.Dependente;
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
public class DependenteRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Dependente> listarTodos(){
        Query query= em.createNamedQuery(Dependente.QUERY_NATIVA_DEPENDETE);
        List<Object[]> listaSocios = query.getResultList() ;

        List<Dependente> listaDependentes = new ArrayList<>();

        for (Object[] campos : listaSocios){
            Dependente dependente = new Dependente();

            Integer id = (Integer) campos[0];
            dependente.setId(id);

            String nome = campos[1].toString();
            dependente.setNome(nome);

            String cpf = campos[2].toString();
            dependente.setCpf(cpf);

            Integer idSocio = (Integer) campos[3];
            Socio socio = new Socio();
            socio.setId(idSocio);
            dependente.setSocio(socio);

            listaDependentes.add(dependente);
        }

        return listaDependentes;


    }
}
