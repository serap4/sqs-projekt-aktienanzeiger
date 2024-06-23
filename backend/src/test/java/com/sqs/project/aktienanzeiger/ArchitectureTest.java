package com.sqs.project.aktienanzeiger;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ArchitectureTest {

    @ArchTest
    public static final ArchRule services_should_not_depend_on_each_other =
            noClasses().that().resideInAPackage("..service..")
                    .should().dependOnEachOther();

    @ArchTest
    public static final ArchRule controllers_should_only_depend_on_services =
            classes().that().resideInAPackage("..controller..")
                    .should().onlyDependOnClassesThat().resideInAnyPackage("..service..", "..controller..");
}