subprojects {
    tasks.jar {
        archiveBaseName.set("task-dispatcher-" + project.name)
    }

    dependencies {
        implementation("org.springframework:spring-context")
        implementation("org.springframework:spring-core")
        implementation("org.springframework.boot:spring-boot-autoconfigure")
        implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-api"))
        implementation(project(":server:libs:atlas:atlas-coordinator:atlas-coordinator-api"))
        implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-api"))
        implementation(project(":server:libs:core:commons:commons-util"))
        implementation(project(":server:libs:core:event:event-listener:event-listener-api"))
        implementation(project(":server:libs:core:message-broker:message-broker-api"))
        implementation(project(":server:libs:hermes:hermes-task-dispatcher:hermes-task-dispatcher-api"))

        testImplementation(project(":server:libs:atlas:atlas-worker:atlas-worker-api"))
        testImplementation(project(":server:libs:hermes:hermes-task-dispatcher:hermes-task-dispatcher-test-int-support"))
        testImplementation(project(":server:libs:test:test-support"))
    }
}
