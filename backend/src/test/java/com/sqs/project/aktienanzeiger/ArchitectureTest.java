package com.sqs.project.aktienanzeiger;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest {

    @ArchTest
    public static final ArchRule services_should_not_have_cyclic_dependencies =
            classes().that().resideInAPackage("..service..")
                    .should().haveNoCycles();

    @ArchTest
    public static final ArchRule controllers_should_only_depend_on_services =
            classes().that().resideInAPackage("..controller..")
                    .should().onlyDependOnClassesThat().resideInAnyPackage("..service..", "..controller..");
}