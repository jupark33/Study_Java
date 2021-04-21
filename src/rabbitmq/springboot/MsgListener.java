import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MsgListener {

	private static Logger logger = LoggerFactory.getLogger(MsgListener.class);
	
  /**
   * publisher 가 메시지를 큐에 넣으면 아래 함수가 호출되면서 로그 출력됨. 여러번 publish 해도 여러번 아래 함수가 
   */
	@RabbitListener(queues = "queue1")
	public void receiveMessage(final String msg) {
		
		logger.debug("MsgListener.receiveMessage, msg : " + msg);
	}
  
}
