package com.assessment.Prueba_Empleabilidad.domain.enums;

import java.util.Collections;
import java.util.Set;

public enum Roles {

    DOCTOR(Set.of("VIEW_PATIENTS", "MANAGE_TREATMENTS")), // Permisos para el rol Doctor
    PATIENT(Set.of("VIEW_APPOINTMENTS", "REQUEST_MEDICAL_HISTORY")), // Permisos para el rol Patient
    ADMIN(Set.of("VIEW_PROFILE")); // Permisos para el rol User

    private final Set<String> permissions;

    Roles(Set<String> permissions) {
        this.permissions = permissions;
    }

    public Set<String> getPermissions() {
        return Collections.unmodifiableSet(permissions); // Devuelve un Set inmutable de permisos
    }
}
