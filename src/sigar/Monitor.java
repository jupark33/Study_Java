public class Monitor {
  public Monitor() {
    try {
      startSch();
    } catch (SchedulerException e) {
      e.printStackTrace();
    }
  }

  private void startSch() throws SchedulerException {
    Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    JobDetail job = JobBuilder.newJob(ResourceJob.class)
      .withIdentity("Job1", "Group1")
      .build();

    String cron = "0/1 * * * * ?";
    Trigger trigger = TriggerBuilder.newTrigger()
      .withIdentity("Trigger1", "Group1")
      .startNow()
      .withSchedule(CronScheduleBuilder.cronSchedule(cron))
      .build();

    scheduler.scheduleJob(job, trigger);
    scheduler.start();
  }

  public static void main(String[] args) {
    new Monitor();
  }
}
