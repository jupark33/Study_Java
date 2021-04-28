package kr.co.rbpmm;

@RestController
@RequestMapping(value="/v1")
public class Controller {
  private static Logger logger = LoggerFactory.getLogger(Controller.class);
  
  @Autowired
  private Svc svc;
  
  @RequestMapping(value="/regist", method=RequestMethod.POST)
  public String regist(@RequestBody RegistBody regist) {
    logger.debug("Controller.regist, regist : " + regist);
    svc.sendRegist(regist);
    return "ok";
  }

  @RequestMapping(value="/update", method=RequestMethod.POST)
  public String update(@RequestBody Update update) {
    logger.debug("Controller.update, update : " + update);
    svc.sendUpdate(update);
    return "ok";
  }
}
