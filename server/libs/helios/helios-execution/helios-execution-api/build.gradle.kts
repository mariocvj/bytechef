dependencies {
    api(project(":server:libs:helios:helios-configuration:helios-configuration-api"))
    api(project(":server:libs:hermes:hermes-execution:hermes-execution-api"))

    implementation("org.springframework.data:spring-data-relational")
    implementation(project(":server:libs:core:commons:commons-data"))
    implementation(project(":server:libs:core:commons:commons-util"))
}
