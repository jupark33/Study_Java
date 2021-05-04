import 생략
import groovy.json.*
import HTTPClient.NVPair

/**
 * nGrinder 에서 사용할 REST request , BODY json
 */
@Test
public void test() {
  UUID uuid = UUID.randomUUID()
  grinder.logger.info("test, uuid : " + uuid)
  
  def map = [:]
  map['name'] = 'gdhong'
  def json = new JsonBuilder(map).toString()
  
  HTTPResponse response = request.POST("http://localhost/abc", json.getBytes())
  
  // ...
}
