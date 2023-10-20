group = "com.bytechef.configuration"
description = ""

springBoot {
    mainClass.set("com.bytechef.configuration.ConfigurationApplication")
}

dependencies {
    implementation("org.apache.commons:commons-lang3")
    implementation(libs.org.openapitools.jackson.databind.nullable)
    implementation(libs.org.springdoc.springdoc.openapi.starter.common)
    implementation("org.springframework:spring-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    implementation("org.springframework.retry:spring-retry")
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-config"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-converter"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-repository:atlas-configuration-repository-jdbc"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-repository:atlas-configuration-repository-git"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-repository:atlas-configuration-repository-resource"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-service"))
    implementation(project(":server:libs:core:async-config"))
    implementation(project(":server:libs:core:cache-config"))
    implementation(project(":server:libs:core:category:category-service"))
    implementation(project(":server:libs:core:commons:commons-data"))
    implementation(project(":server:libs:core:environment-config"))
    implementation(project(":server:libs:core:jackson-config"))
    implementation(project(":server:libs:core:jdbc-config"))
    implementation(project(":server:libs:core:liquibase-config"))
    implementation(project(":server:libs:core:rest:rest-impl"))
    implementation(project(":server:libs:core:tag:tag-service"))
    implementation(project(":server:libs:helios:helios-configuration:helios-configuration-api"))
    implementation(project(":server:libs:helios:helios-configuration:helios-configuration-rest:helios-configuration-rest-impl"))
    implementation(project(":server:libs:helios:helios-configuration:helios-configuration-service"))
    implementation(project(":server:libs:helios:helios-demo-config"))
    implementation(project(":server:libs:helios:helios-swagger"))
    implementation(project(":server:libs:hermes:hermes-configuration:hermes-configuration-rest"))
    implementation(project(":server:libs:hermes:hermes-configuration:hermes-configuration-service"))
    implementation(project(":server:libs:hermes:hermes-oauth2:hermes-oauth2-service"))
    implementation(project(":server:libs:hermes:hermes-swagger"))

    implementation(project(":server:ee:libs:athena:athena-configuration:athena-configuration-rest"))
    implementation(project(":server:ee:libs:athena:athena-configuration:athena-configuration-service"))
    implementation(project(":server:ee:libs:athena:athena-swagger"))
    implementation(project(":server:ee:libs:atlas:atlas-execution:atlas-execution-remote-client"))
    implementation(project(":server:ee:libs:core:discovery:discovery-redis"))
    implementation(project(":server:ee:libs:helios:helios-configuration:helios-configuration-remote-rest"))
    implementation(project(":server:ee:libs:hermes:hermes-component:hermes-component-registry:hermes-component-registry-remote-client"))
    implementation(project(":server:ee:libs:hermes:hermes-configuration:hermes-configuration-remote-rest"))
    implementation(project(":server:ee:libs:hermes:hermes-connection:hermes-connection-remote-client"))
    implementation(project(":server:ee:libs:hermes:hermes-execution:hermes-execution-remote-client"))
    implementation(project(":server:ee:libs:hermes:hermes-task-dispatcher-registry:hermes-task-dispatcher-registry-remote-client"))

    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("com.zaxxer:HikariCP")
    runtimeOnly(libs.org.springdoc.springdoc.openapi.starter.webmvc.ui)
    runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")
    runtimeOnly("org.springframework.boot:spring-boot-starter-aop")
    runtimeOnly("org.springframework.boot:spring-boot-starter-cache")

    testImplementation(project(":server:libs:test:test-int-support"))
}
