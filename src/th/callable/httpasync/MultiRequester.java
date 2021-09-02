import ...
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MultiRequester {
  class ReqBill implements Callable<String> {
    private String stTime;
    private Param param;

  }
} 
