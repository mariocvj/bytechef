group = "com.bytechef.server"
description = "ByteChef server app"

springBoot {
    mainClass.set("com.bytechef.server.ServerApplication")
}

dependencies {
    implementation(libs.org.springdoc.springdoc.openapi.starter.common)
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-config"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-converter"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-repository:atlas-configuration-repository-jdbc"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-repository:atlas-configuration-repository-git"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-repository:atlas-configuration-repository-resource"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-service"))
    implementation(project(":server:libs:atlas:atlas-coordinator:atlas-coordinator-config"))
    implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-repository:atlas-execution-repository-jdbc"))
    implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-config"))
    implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-service"))
    implementation(project(":server:libs:atlas:atlas-file-storage:atlas-file-storage-service"))
    implementation(project(":server:libs:atlas:atlas-worker:atlas-worker-config"))
    implementation(project(":server:libs:automation:automation-configuration:automation-configuration-instance-impl"))
    implementation(project(":server:libs:automation:automation-configuration:automation-configuration-rest:automation-configuration-rest-impl"))
    implementation(project(":server:libs:automation:automation-configuration:automation-configuration-service"))
    implementation(project(":server:libs:automation:automation-connection:automation-connection-rest"))
    implementation(project(":server:libs:automation:automation-workflow:automation-workflow-coordinator"))
    implementation(project(":server:libs:automation:automation-demo-config"))
    implementation(project(":server:libs:automation:automation-workflow:automation-workflow-execution:automation-workflow-execution-rest"))
    implementation(project(":server:libs:automation:automation-workflow:automation-workflow-execution:automation-workflow-execution-service"))
    implementation(project(":server:libs:automation:automation-swagger"))
    implementation(project(":server:libs:core:async-config"))
    implementation(project(":server:libs:core:cache-config"))
    implementation(project(":server:libs:core:category:category-service"))
    implementation(project(":server:libs:core:commons:commons-data"))
    implementation(project(":server:libs:core:data-storage:data-storage-db:data-storage-db-service"))
    implementation(project(":server:libs:core:encryption:encryption-filesystem"))
    implementation(project(":server:libs:core:encryption:encryption-impl"))
    implementation(project(":server:libs:core:environment-config"))
    implementation(project(":server:libs:core:file-storage:file-storage-base64-service"))
    implementation(project(":server:libs:core:file-storage:file-storage-filesystem-service"))
    implementation(project(":server:libs:core:jackson-config"))
    implementation(project(":server:libs:core:jdbc-config"))
    implementation(project(":server:libs:core:liquibase-config"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-amqp"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-jms"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-kafka"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-redis"))
    implementation(project(":server:libs:core:message:message-event:message-event-impl"))
    implementation(project(":server:libs:core:rest:rest-impl"))
    implementation(project(":server:libs:core:tag:tag-service"))
    implementation(project(":server:libs:platform:platform-component:platform-component-registry:platform-component-registry-service"))
    implementation(project(":server:libs:platform:platform-connection:platform-connection-service"))
    implementation(project(":server:libs:platform:platform-configuration:platform-configuration-rest:platform-configuration-rest-impl"))
    implementation(project(":server:libs:platform:platform-configuration:platform-configuration-service"))
    implementation(project(":server:libs:platform:platform-connection:platform-connection-rest:platform-connection-rest-impl"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-coordinator:platform-workflow-coordinator-impl"))
    implementation(project(":server:libs:platform:platform-file-storage:platform-file-storage-service"))
    implementation(project(":server:libs:platform:platform-oauth2:platform-oauth2-service"))
    implementation(project(":server:libs:platform:platform-scheduler:platform-scheduler-impl"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-task-dispatcher:platform-workflow-task-dispatcher-registry:platform-workflow-task-dispatcher-registry-service"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-test:platform-workflow-test-rest"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-test:platform-workflow-test-service"))
    implementation(project(":server:libs:platform:platform-webhook:platform-webhook-impl"))
    implementation(project(":server:libs:platform:platform-webhook:platform-webhook-rest"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-execution:platform-workflow-execution-rest:platform-workflow-execution-rest-impl"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-execution:platform-workflow-execution-service"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-worker:platform-workflow-worker-impl"))
    implementation(project(":server:libs:platform:platform-swagger"))

    implementation(project(":server:libs:modules:components:airtable"))
    implementation(project(":server:libs:modules:components:aws:aws-s3"))
    implementation(project(":server:libs:modules:components:bash"))
    implementation(project(":server:libs:modules:components:csv-file"))
    implementation(project(":server:libs:modules:components:data-mapper"))
    implementation(project(":server:libs:modules:components:data-storage"))
    implementation(project(":server:libs:modules:components:delay"))
    implementation(project(":server:libs:modules:components:dropbox"))
    implementation(project(":server:libs:modules:components:file-storage"))
    implementation(project(":server:libs:modules:components:email"))
    implementation(project(":server:libs:modules:components:example"))
    implementation(project(":server:libs:modules:components:http-client"))
    implementation(project(":server:libs:modules:components:hubspot"))
    implementation(project(":server:libs:modules:components:infobip"))
    implementation(project(":server:libs:modules:components:jira"))
    implementation(project(":server:libs:modules:components:json-file"))
    implementation(project(":server:libs:modules:components:logger"))
    implementation(project(":server:libs:modules:components:filesystem"))
    implementation(project(":server:libs:modules:components:google:google-calendar"))
    implementation(project(":server:libs:modules:components:google:google-drive"))
    implementation(project(":server:libs:modules:components:google:google-mail"))
    implementation(project(":server:libs:modules:components:map"))
    implementation(project(":server:libs:modules:components:mailchimp"))
    implementation(project(":server:libs:modules:components:mysql"))
    implementation(project(":server:libs:modules:components:object-helper"))
    implementation(project(":server:libs:modules:components:ods-file"))
    implementation(project(":server:libs:modules:components:openai"))
    implementation(project(":server:libs:modules:components:petstore"))
    implementation(project(":server:libs:modules:components:pipedrive"))
    implementation(project(":server:libs:modules:components:postgresql"))
    implementation(project(":server:libs:modules:components:quickbooks"))
    implementation(project(":server:libs:modules:components:rabbitmq"))
    implementation(project(":server:libs:modules:components:random-helper"))
    implementation(project(":server:libs:modules:components:resend"))
    implementation(project(":server:libs:modules:components:schedule"))
    implementation(project(":server:libs:modules:components:script"))
    implementation(project(":server:libs:modules:components:text-helper"))
    implementation(project(":server:libs:modules:components:twilio"))
//    implementation(project(":server:libs:modules:components:shopify"))
    implementation(project(":server:libs:modules:components:var"))
    implementation(project(":server:libs:modules:components:xero"))
    implementation(project(":server:libs:modules:components:xlsx-file"))
    implementation(project(":server:libs:modules:components:xml-file"))
    implementation(project(":server:libs:modules:components:xml-helper"))
    implementation(project(":server:libs:modules:components:webhook"))

    implementation(project(":server:libs:modules:task-dispatchers:branch"))
    implementation(project(":server:libs:modules:task-dispatchers:condition"))
    implementation(project(":server:libs:modules:task-dispatchers:each"))
    implementation(project(":server:libs:modules:task-dispatchers:fork-join"))
    implementation(project(":server:libs:modules:task-dispatchers:loop"))
    implementation(project(":server:libs:modules:task-dispatchers:map"))
    implementation(project(":server:libs:modules:task-dispatchers:parallel"))
    implementation(project(":server:libs:modules:task-dispatchers:sequence"))
    implementation(project(":server:libs:modules:task-dispatchers:subflow"))

    runtimeOnly("com.h2database:h2")
    runtimeOnly("com.zaxxer:HikariCP")
    runtimeOnly("org.apache.activemq:artemis-jakarta-server")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly(libs.org.springdoc.springdoc.openapi.starter.webmvc.ui)
    runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")
    runtimeOnly("org.springframework.boot:spring-boot-starter-amqp")
    runtimeOnly("org.springframework.boot:spring-boot-starter-artemis")
    runtimeOnly("org.springframework.boot:spring-boot-starter-cache")
    runtimeOnly("org.springframework.boot:spring-boot-starter-quartz")
    runtimeOnly("org.springframework.kafka:spring-kafka")

    testImplementation(project(":server:libs:test:test-int-support"))
}
