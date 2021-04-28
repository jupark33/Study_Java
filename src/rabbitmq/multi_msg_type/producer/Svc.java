package kr.co.rbpmm;

@Service
public class Svc {
  private static Logger logger = LoggerFactory.getLogger(Svc.class);
  
  @Autowired
  private RabbitTemplate template;
  
  @Autowired
  private FanoutExchange fanout;
  
  public void sendRegist(Regist regist) {
    logger.debug("Svc.sendRegist, doc : " + regist);
    template.convertAndSend(fanout.getName(), "", regist);
  }
  
  public void sendUpdate(Update update) {
    logger.debug("Svc.sendUpdate, update : " + update);
    template.convertAndSend(fanout.getName(), "", update);
  }
}
