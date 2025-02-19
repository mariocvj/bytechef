group = "com.bytechef.execution"
description = ""

springBoot {
    mainClass.set("com.bytechef.execution.ExecutionApplication")
}

dependencies {
    implementation("org.apache.commons:commons-lang3")
    implementation(libs.org.openapitools.jackson.databind.nullable)
    implementation(libs.org.springdoc.springdoc.openapi.starter.common)
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    implementation("org.springframework.retry:spring-retry")
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-converter"))
    implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-repository:atlas-execution-repository-jdbc"))
    implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-config"))
    implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-service"))
    implementation(project(":server:libs:atlas:atlas-file-storage:atlas-file-storage-service"))
    implementation(project(":server:libs:core:async-config"))
    implementation(project(":server:libs:core:environment-config"))
    implementation(project(":server:libs:core:data-storage:data-storage-db:data-storage-db-service"))
    implementation(project(":server:libs:core:commons:commons-data"))
    implementation(project(":server:libs:core:commons:commons-util"))
    implementation(project(":server:libs:core:file-storage:file-storage-base64-service"))
    implementation(project(":server:libs:core:file-storage:file-storage-filesystem-service"))
    implementation(project(":server:libs:core:jackson-config"))
    implementation(project(":server:libs:core:jdbc-config"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-amqp"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-kafka"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-redis"))
    implementation(project(":server:libs:core:message:message-event:message-event-impl"))
    implementation(project(":server:libs:core:rest:rest-impl"))
    implementation(project(":server:libs:helios:helios-execution:helios-execution-rest"))
    implementation(project(":server:libs:helios:helios-execution:helios-execution-service"))
    implementation(project(":server:libs:helios:helios-swagger"))
    implementation(project(":server:libs:hermes:hermes-execution:hermes-execution-service"))
    implementation(project(":server:libs:hermes:hermes-file-storage:hermes-file-storage-service"))
    implementation(project(":server:libs:hermes:hermes-test-executor:hermes-test-executor-impl"))
    implementation(project(":server:libs:core:liquibase-config"))

    implementation(project(":ee:server:libs:atlas:atlas-execution:atlas-execution-remote-rest"))
    implementation(project(":ee:server:libs:atlas:atlas-worker:atlas-worker-remote-client"))
    implementation(project(":ee:server:libs:core:discovery:discovery-redis"))
    implementation(project(":ee:server:libs:core:data-storage:data-storage-db:data-storage-db-remote-rest"))
    implementation(project(":ee:server:libs:helios:helios-configuration:helios-configuration-remote-client"))
    implementation(project(":ee:server:libs:hermes:hermes-component:hermes-component-registry:hermes-component-registry-remote-client"))
    implementation(project(":ee:server:libs:hermes:hermes-configuration:hermes-configuration-remote-client"))
    implementation(project(":ee:server:libs:hermes:hermes-execution:hermes-execution-remote-rest"))
    implementation(project(":ee:server:libs:hermes:hermes-scheduler:hermes-scheduler-remote-client"))

    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("com.zaxxer:HikariCP")
    runtimeOnly(libs.org.springdoc.springdoc.openapi.starter.webmvc.ui)
    runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")
    runtimeOnly("org.springframework.boot:spring-boot-starter-aop")
    runtimeOnly("org.springframework.boot:spring-boot-starter-data-redis")

    testImplementation(project(":server:libs:test:test-int-support"))
}
