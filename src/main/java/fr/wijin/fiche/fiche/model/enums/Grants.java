package fr.wijin.fiche.fiche.model.enums;

public enum Grants {

    ROLE_SUPER_ADMIN("ROLE_SUPER_ADMIN"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    private final String name;

    Grants(String name) {
        this.name = name;
    }

}
