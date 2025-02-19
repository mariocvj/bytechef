dependencies {
    implementation("org.apache.commons:commons-lang3")
    implementation("org.springframework:spring-context")
    implementation("org.springframework.data:spring-data-jdbc")
    api(project(":server:libs:atlas:atlas-configuration:atlas-configuration-api"))
    implementation(project(":server:libs:core:commons:commons-util"))
    implementation(project(":server:libs:hermes:hermes-component:hermes-component-api"))
    implementation(project(":server:libs:hermes:hermes-oauth2:hermes-oauth2-api"))
    implementation(project(":server:libs:hermes:hermes-configuration:hermes-configuration-api"))
    implementation(project(":server:libs:hermes:hermes-configuration:hermes-configuration-instance-api"))
    implementation(project(":server:libs:hermes:hermes-connection:hermes-connection-api"))

    testImplementation("com.fasterxml.jackson.core:jackson-databind")
    testImplementation(project(":server:libs:core:commons:commons-data"))
    testImplementation(project(":server:libs:core:encryption:encryption-impl"))
    testImplementation(project(":server:libs:core:tag:tag-service"))
    testImplementation(project(":server:libs:core:liquibase-config"))
    testImplementation(project(":server:libs:test:test-int-support"))
}
