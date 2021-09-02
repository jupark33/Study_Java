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

    public ReqBill() {
    }

    public ReqBill(Param param) {
      this.param = param;
    }

    @Override
    public String call() throws Exception {
      stTime = "시작시간" + new Data() + " ";

      GetResponse gr = new GetResponse();
      Document doc = gr.get(param.getURL());
      Element ele = doc.getElementById("Result");
    }
  }

  private void action() {
    List<Param> params = new Param().getParams();

    ExecutorService WORKER_TH_POOL = Executors.newFixedThreadPool(params.size());
    List<ReqBill> callables = new ArrayList<ReqBill>();
    for (Param param : params) {
      callables.add(new ReqBill(param));
    }

    long lStartTime = System.currentTimeMillis();

  }
} 
