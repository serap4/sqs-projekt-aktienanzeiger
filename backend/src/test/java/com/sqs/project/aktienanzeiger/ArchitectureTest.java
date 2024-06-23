package com.sqs.project.aktienanzeiger;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

public class ArchitectureTest {

    @Test
    void services_should_not_depend_on_controllers() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.sqs.project.aktienanzeiger");

        ArchRuleDefinition.noClasses()
                .that().resideInAnyPackage("..service..")
                .should().dependOnClassesThat().resideInAnyPackage("..controller..")
                .check(importedClasses);
    }

    @Test
    void controllers_should_only_depend_on_services() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.sqs.project.aktienanzeiger");

        ArchRuleDefinition.classes()
                .that().resideInAnyPackage("..controller..")
                .should().onlyDependOnClassesThat().resideInAnyPackage("..service..")
                .orShould().dependOnClassesThat().resideInAnyPackage("..model..")
                .check(importedClasses);
    }

    @Test
    void services_should_only_depend_on_other_services_or_models() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.sqs.project.aktienanzeiger");

        ArchRuleDefinition.classes()
                .that().resideInAnyPackage("..service..")
                .should().onlyDependOnClassesThat().resideInAnyPackage("..service..")
                .orShould().dependOnClassesThat().resideInAnyPackage("..model..")
                .orShould().dependOnClassesThat().resideInAnyPackage("java..")
                .orShould().dependOnClassesThat().resideInAnyPackage("javax..")
                .orShould().dependOnClassesThat().resideInAnyPackage("org.springframework..")
                .check(importedClasses);
    }
}
