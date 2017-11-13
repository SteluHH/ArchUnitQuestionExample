package com.lucka;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packagesOf = TestAggregate.class)
public class ArchUnitTest {

    @ArchTest
    public static void compliant_example(JavaClasses javaClasses) throws Exception {

        noClasses()
                .that().areAssignableTo(Entity.class)
                .should().accessClassesThat().areAssignableTo(ForbiddenException.class)
                .check(javaClasses);
    }

    @ArchTest
    public static void noncompliant_example(JavaClasses javaClasses) throws Exception {

        noClasses()
                .that().areAssignableTo(Entity.class)
                .should().accessClassesThat().areAssignableTo(Exception.class)
                .check(javaClasses);
    }
}
