  
package kr.co.rbcmm;

@Service
@RabbitListener(queues = "q.1")
public class Svc {
  private static Logger logger = LoggerFactory.getLogger(Svc.class);
  
  @RabbitHandler
  public void handleRegist(Regist regist) {
    logger.debug("Svc.handleRegist, regist : " + regist);
  }
  
  @RabbitHandler
  public void handleUpdate(Update update) {
    logger.debug("Svc.handleUpdate, update : " + update);
  }
  
  @RabbitHandler
  public void handleDefault(Object msg) {
    logger.debug("Svc.handleDefault, msg : " + msg);
  }
}
