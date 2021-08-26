public class ThCallable {
    class MyCallable implements Callable<String> {
        private String stTime;

        @Override
        public String call() throws Exception {
            String result = "Called at " + new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date()).toString();
            stTime = result;
            return result;
        }

        @Override
        public String toString() {
            return stTime;
        }
    }

    private void action() {
        ExecutorService WORKER_THREAD_POOL = Executors.newFixedThreadPool(2);
        List<MyCallable> callables = Arrays.asList(
            new MyCallable(),
            new MyCallable()
        );

        try {
            List<Future<String>> futures = WORKER_THREAD_POOL.invokeAll(callables);

            for (Future<String> future : futures) {
                System.out.println("ThCallable.action(), future : " + future.get());
            }
            
            WORKER_THREAD_POOL.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();         
        }
        System.out.println("Job Completed"):
    }

    public static void main(String[] args) {
        new ThCallable().action();
    }
}
