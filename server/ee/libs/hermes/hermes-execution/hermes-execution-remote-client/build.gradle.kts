dependencies {
    implementation("org.springframework:spring-context")
    implementation(project(":server:libs:hermes:hermes-execution:hermes-execution-api"))

    implementation(project(":server:ee:libs:core:commons:commons-webclient"))
}
