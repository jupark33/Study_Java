public class ResourceJob implements Job {
  
  private static Logger logger = LoggerFactory.getLogger(ResourceJob.class);

  public void execute(JobExecutionContext ctx) throws JobExecutionException {
    double tot = 0;
    
    Sigar sigar = new Sigar();
    try {
      CpuPerc cpu = sigar.getCpuPerc();
      double cpuIdle = cpu.getIdle();

      tot = 1 - cpuIdle;
    } catch (SigarException e) {
      e.printStackTrace();
    }

    logger.debug("CPU Usage : " + getPerc(tot));
  }

  private String getPerc(double val) {
    val = val * 100;
    return String.format("%.2f", val);
  }
}
