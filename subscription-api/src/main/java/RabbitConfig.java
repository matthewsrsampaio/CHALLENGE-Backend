import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${app-config.rabbit.exchange.subscription.topic}")
    private String subscriptionTopicExchange;

    @Value("${app-config.rabbit.routingKey.subscription-update}")
    private String subscriptionRoutingKey;

    @Value("${app-config.rabbit.queue.subscription-update}")
    private String subscriptionQueue;

    @Bean
    public TopicExchange subscriptionTopicExchange() {
        return new TopicExchange(subscriptionTopicExchange);
    }
}
