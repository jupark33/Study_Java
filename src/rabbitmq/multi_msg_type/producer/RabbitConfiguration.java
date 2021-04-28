package kr.co.rbpmm;

@Configuration
public class RabbitConfiguration {

	private static final String EX_NAME = "e.name";
	
	/**
	 * durable : true
	 * auto delete : false
	 * 
	 * @return
	 */
	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange(EX_NAME, true, false);
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
		classMapper.setIdClassMapping(idClassMapping);
		return classMapper;
	}
}
