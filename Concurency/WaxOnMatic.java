import java.util.concurrent.*;
import java.util.*;

public class Exercise{
    private static int catCount = 0;
    private static int robotCount = 0;
    private static List<ActiveCarRobot> robots = new ArrayList<ActiveCarRobot>();


    public class Car{
        private final int id = ++carCount;
        private boolean waxOn = false;
        public void waxOn(){
            if(waxOn){System.out.println("error, the wax already on"); return;}
            waxOn = true;
        }
        public void waxOff(){
            if(!waxOff){System.out.println("Error, should waxOn before waxOff!!");return;}
            waxOff = false;
        }
        public String toString(){return "card# +id"}
    }

    public class ActiveCarRobot implements Runable{
        private final int id = ++robotCount;
        private final ExecutorService exce = Executors.new SingleThreadExecutor();
        private List <Future<String>> results = new CopyOnWriteArrayList<Future<String>>();
        private car car;
        public ActiveCarRobot(Car c){car= c; robot.add(this);}
        public String toString(){return "Robot#" +id;}

        public void run (){
            for (int i = 0; i <15;i++){
                results.add(waxOn());
                sleep(10);
                results.add(watchOff());
            }
            showResult();
            shutdown();
        }
        public Future<String> waxOn(){
            return exec.submit(new callable<string>(){ 
                public String call(){
                    sleep(10);
                    car.waxOn();
                    return "  " +car+ " wax on by "+ ActiveCarRobot;
                }
            });
        }
    }
    public void sleep(int time){
        try{
            TimeUnit.MILLISECONDS.sleep(time);
        }catch(InterruptedException e){
            System.out.println(this+ "interupted");
        }
    }
    public void shutdown(){exec.shutdown();}
    public void showResult(){
        long endAt = System.currentTimeMillis()+5000;
        while(true){
            for(Future<String> f:results){
                if(f.isDone()){
                    try{
                        System.out.println(f.get());
                    }catch(Exception e){
                        System.out.println("Error when reading the result!"):
                    }
                }
                results.remove(f);
            }
            if(System.currentTimeMillis() > endAt){break;}
        }
    }


public static void main(String args[]){
    Exercise = test = new Exercise();
    ExecutorService exec = Executor.newCachedThreadPool();
    for(int i = 0; i < 15; i++){
        exec.execute(test.new ActiveCarRobot(test.now Car()));
    }try{
        TimeUnit.Seconts.sleep(5);
    }catch(InterruptedException e){
        System.out.println("Test interupted");
    }
    exec.shutdown();
}
}