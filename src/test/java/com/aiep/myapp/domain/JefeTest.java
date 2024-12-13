package com.aiep.myapp.domain;

import static com.aiep.myapp.domain.DepartamentoTestSamples.*;
import static com.aiep.myapp.domain.JefeTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.aiep.myapp.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class JefeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Jefe.class);
        Jefe jefe1 = getJefeSample1();
        Jefe jefe2 = new Jefe();
        assertThat(jefe1).isNotEqualTo(jefe2);

        jefe2.setId(jefe1.getId());
        assertThat(jefe1).isEqualTo(jefe2);

        jefe2 = getJefeSample2();
        assertThat(jefe1).isNotEqualTo(jefe2);
    }

    @Test
    void departamentosTest() {
        Jefe jefe = getJefeRandomSampleGenerator();
        Departamento departamentoBack = getDepartamentoRandomSampleGenerator();

        jefe.addDepartamentos(departamentoBack);
        assertThat(jefe.getDepartamentos()).containsOnly(departamentoBack);

        jefe.removeDepartamentos(departamentoBack);
        assertThat(jefe.getDepartamentos()).doesNotContain(departamentoBack);

        jefe.departamentos(new HashSet<>(Set.of(departamentoBack)));
        assertThat(jefe.getDepartamentos()).containsOnly(departamentoBack);

        jefe.setDepartamentos(new HashSet<>());
        assertThat(jefe.getDepartamentos()).doesNotContain(departamentoBack);
    }
}