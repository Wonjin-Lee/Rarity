package io.dapsimni.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Collections;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.bootstrap-servers}")  // ✅ Kafka 서버 주소 가져오기
    private String bootstrapServers;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        return new KafkaAdmin(Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers));
    }

    public void createTopic(String topicName) {
        try (AdminClient adminClient = AdminClient.create(kafkaAdmin().getConfigurationProperties())) {
            NewTopic newTopic = new NewTopic(topicName, 3, (short) 1);  // ✅ 파티션 3개, 복제본 1개
            adminClient.createTopics(Collections.singleton(newTopic));
            System.out.println("✅ 토픽 생성 완료: " + topicName);
        }
    }
}

