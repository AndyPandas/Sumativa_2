package com.aiep.myapp.repository;

import com.aiep.myapp.domain.Jefe;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface JefeRepositoryWithBagRelationships {
    Optional<Jefe> fetchBagRelationships(Optional<Jefe> jefe);

    List<Jefe> fetchBagRelationships(List<Jefe> jefes);

    Page<Jefe> fetchBagRelationships(Page<Jefe> jefes);
}
