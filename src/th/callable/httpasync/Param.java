public class Param {
  
  private String URL;

  public Param() {
  }

  public List<Param> getParams() {
    List<Param> params = new ArrayList<Param>();

    Param param = new Param("http://www.naver.com");
    params.add(param);

    param = new Param("http://www.daum.net");
    params.add(param);
  }

  public Param(String URL) {
    this.URL = URL;
  }

  public String getURL() {
    return URL;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }
}
