package com.aiep.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class JefeAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertJefeAllPropertiesEquals(Jefe expected, Jefe actual) {
        assertJefeAutoGeneratedPropertiesEquals(expected, actual);
        assertJefeAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertJefeAllUpdatablePropertiesEquals(Jefe expected, Jefe actual) {
        assertJefeUpdatableFieldsEquals(expected, actual);
        assertJefeUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertJefeAutoGeneratedPropertiesEquals(Jefe expected, Jefe actual) {
        assertThat(expected)
            .as("Verify Jefe auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertJefeUpdatableFieldsEquals(Jefe expected, Jefe actual) {
        assertThat(expected)
            .as("Verify Jefe relevant properties")
            .satisfies(e -> assertThat(e.getNombreJefe()).as("check nombreJefe").isEqualTo(actual.getNombreJefe()))
            .satisfies(e -> assertThat(e.getTelefonoJefe()).as("check telefonoJefe").isEqualTo(actual.getTelefonoJefe()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertJefeUpdatableRelationshipsEquals(Jefe expected, Jefe actual) {
        assertThat(expected)
            .as("Verify Jefe relationships")
            .satisfies(e -> assertThat(e.getDepartamentos()).as("check departamentos").isEqualTo(actual.getDepartamentos()));
    }
}
