dependencies {
    implementation("org.apache.commons:commons-lang3")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.cloud:spring-cloud-config-server")

    implementation(project(":ee:server:libs:core:discovery:discovery-redis"))
}
