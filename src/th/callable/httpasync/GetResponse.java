import ...
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Docuement;

public class GetResponse {

  private CloseableHttpAsyncClient getClient() {
    ConnectingIOReactor ioReactor = null;
    try {
      ioReactor = new DefaultConnectingIOReactor();
    } catch (IOReactorException e) {
      e.printStackTrace();
    }

    PoolingNHttpClientConnectionManager cm = new PoolingNHttpClientConnectionManager(ioReactor);
    CloseableHttpAsyncClient client = HttpAsyncClients.custom().setConnectionManager(cm).build();
    return client;
  }

  public Document get(String url) {
    Document result = null;

    CloseableHttpAsyncClient client = getClient();
    client.start();

    HttpGet request = new HttpGet(url);
    HttpContext context = HttpClientContext.create();
    Future<HttpResponse> future = client.execute(request, context, null);

    try {
      HttpResponse response = future.get();
      System.out.println("Result code : " + response.getStatusLine().getStatusCode());

      HttpEntity entity = response.getEntity();
      String content = EntityUtils.toString(entity);
      result = Jsoup.parse(content);
      client.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return result;
  }

  public void getPost(String url, String name) {
    CloseableHttpAsyncClient client = getClient();
    client.start();

    HttpPost request = new HttpPost(url);

    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("name", name);
    request.setEntity(new UrlEncodedFormEntity(params));

    HttpContext context = HttpClientContext.create();
    Future<HttpResponse> future = client.execute(request, context, null);

    try {
      HttpResponse response = future.get();
      System.out.println("Result code : " + response.getStatusLine().getStatusCode());

      HttpEntity entity = response.getEntity();
      String content = EntityUtils.toString(entity);
      System.out.println("Result Content : " + content);
      client.close();   
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
