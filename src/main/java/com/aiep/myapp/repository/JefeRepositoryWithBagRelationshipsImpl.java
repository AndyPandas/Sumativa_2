package com.aiep.myapp.repository;

import com.aiep.myapp.domain.Jefe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/**
 * Utility repository to load bag relationships based on https://vladmihalcea.com/hibernate-multiplebagfetchexception/
 */
public class JefeRepositoryWithBagRelationshipsImpl implements JefeRepositoryWithBagRelationships {

    private static final String ID_PARAMETER = "id";
    private static final String JEFES_PARAMETER = "jefes";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Jefe> fetchBagRelationships(Optional<Jefe> jefe) {
        return jefe.map(this::fetchDepartamentos);
    }

    @Override
    public Page<Jefe> fetchBagRelationships(Page<Jefe> jefes) {
        return new PageImpl<>(fetchBagRelationships(jefes.getContent()), jefes.getPageable(), jefes.getTotalElements());
    }

    @Override
    public List<Jefe> fetchBagRelationships(List<Jefe> jefes) {
        return Optional.of(jefes).map(this::fetchDepartamentos).orElse(Collections.emptyList());
    }

    Jefe fetchDepartamentos(Jefe result) {
        return entityManager
            .createQuery("select jefe from Jefe jefe left join fetch jefe.departamentos where jefe.id = :id", Jefe.class)
            .setParameter(ID_PARAMETER, result.getId())
            .getSingleResult();
    }

    List<Jefe> fetchDepartamentos(List<Jefe> jefes) {
        HashMap<Object, Integer> order = new HashMap<>();
        IntStream.range(0, jefes.size()).forEach(index -> order.put(jefes.get(index).getId(), index));
        List<Jefe> result = entityManager
            .createQuery("select jefe from Jefe jefe left join fetch jefe.departamentos where jefe in :jefes", Jefe.class)
            .setParameter(JEFES_PARAMETER, jefes)
            .getResultList();
        Collections.sort(result, (o1, o2) -> Integer.compare(order.get(o1.getId()), order.get(o2.getId())));
        return result;
    }
}
