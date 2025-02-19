dependencies {
    implementation(libs.io.swagger.core.v3.swagger.annotations)
    implementation("jakarta.validation:jakarta.validation-api")
    implementation("org.springframework:spring-context")
    implementation("org.springframework:spring-web")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation(project(":server:libs:core:commons:commons-util"))
    implementation(project(":server:libs:hermes:hermes-task-dispatcher:hermes-task-dispatcher-registry:hermes-task-dispatcher-registry-api"))
}
