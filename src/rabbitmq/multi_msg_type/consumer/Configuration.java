package kr.co.rbcmm;

@Configuration
public class RabbitConfiguration {
  
  @Bean
  public Queue q1() {
    return new Queue("q.1", true);
  }
  
  @Bean
  public Queue q2() {
    return new Queue("q.2", true);
  }
  
  @Bean
  public FanoutExchange exchange() {
    return new FanoutExchange("e.name", true, false);
  }
  
  @Bean
  public Binding q1Binding(Queue q1, FanoutExchange exchange) {
    return BindingBuilder.bind(q1).to(exchange);
  }
  
  @Bean
  public Binding q2Binding(Queue q2, FanoutExchange exchange) {
    return BindingBuilder.bind(q2).to(exchange);
  }
  
  @Bean
  public Jackson2JsonMessageConverter jsonMessageConverter() {
    Jackson2JsonMessageConverter jsonConverter = new Jackson2JsonMessageConverter();
    jsonConverter.setClassMapper(classMapper());
    return jsonConverter;
  }
  
  @Bean
  public DefaultClassMapper classMapper() {
    DefaultClassMapper classMapper = new DefaultClassMapper();
    Map<String, Class<?>> idClassMapping = new HashMap<>();
    idClassMapping.put("Regist", Regist.class);
    idClassMapping.put("Update", Update.class);
    classMapping.setIdClassMapping(idClassMapping);
    return classMapper;
  }
}
