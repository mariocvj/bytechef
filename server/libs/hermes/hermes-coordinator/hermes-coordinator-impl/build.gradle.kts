dependencies {
    implementation("org.apache.commons:commons-lang3")
    implementation("org.slf4j:slf4j-api")
    implementation("org.springframework:spring-context")
    implementation("org.springframework:spring-tx")
    implementation("org.springframework.boot:spring-boot")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation(project(":server:libs:core:commons:commons-util"))
    implementation(project(":server:libs:hermes:hermes-configuration:hermes-configuration-instance-api"))
    implementation(project(":server:libs:hermes:hermes-coordinator:hermes-coordinator-api"))
    implementation(project(":server:libs:hermes:hermes-file-storage:hermes-file-storage-api"))
    implementation(project(":server:libs:hermes:hermes-worker:hermes-worker-api"))
}
