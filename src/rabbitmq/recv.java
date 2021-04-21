import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Recv {

	private static Logger logger = LoggerFactory.getLogger(Recv.class);
	
	private final static String EXCHANGE_NAME = "ex1";
	private final static String QUEUE_1 = "queue1";
	
	public static void main(String[] args) {
		
		logger.debug("Recv.main()");
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setUsername("111");
		factory.setPassword("222");
		
		try (Connection connection = factory.newConnection();
			 Channel channel = connection.createChannel() ) {
			
			channel.exchangeDeclare(EXCHANGE_NAME, "fanout", true);
			
			channel.queueDeclare(QUEUE_1, true, false, false, null);
			channel.queueBind(QUEUE_1, EXCHANGE_NAME, "");
			
			// QUEUE_1 소비 
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				String message = new String(delivery.getBody(), "UTF-8");
				logger.debug(" [x] Received : " + message);
			};
			channel.basicConsume(QUEUE_1, true, deliverCallback, consumerTag -> {});
			
			// 프로그램이 종료되지 않고 기다리는지 테스트 -- OK -- 그러나 커맨드 창에 문자 입력하고 엔터 누르면 프로그램 종료됨
			Scanner scanner = new Scanner(System.in);
			String msg = scanner.nextLine();
			
		} catch (IOException | TimeoutException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
