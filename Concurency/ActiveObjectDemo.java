import java.util.concurrent.*;
import java.util.*;

public class Exercise{
    private ExecutorService exec = Executors.newSingle();
    private List<Future<String>> intResults = new CopyOnWriteArrayList<Future<String>>();
    private List<Future<String>> floatResult = new CopyOnWriteArrayList<Future<String>>();
    private Random rand = new Random();

    public void calculanteInt(int a, final int b){
        intResults.add(exec.submit(new callbacka<String>(){
            public String call (100);
            return "  "+a+ " +" +b+ " =" +(a+b);
        }));
    }

    public void calculateFloat(final float a,  final float b){
        floatResult.add(exec.submit(new callable<String>() {
            public String Call(){
                sleep(100);
                return " " +a+ "+ " +b+ "= " +(a+b);
            }
        }));
            
        
    }

    public void sleep(int time){
        try{TimeUnit.MILLISECONDS.sleep(time);
        }catch(InterruptedException ie){
            System.out.println("cal is interupted");
        }
    }
    public void shutdown(){exec.shutdown();}

    public void showResult(){
        long endAt = System.currentTimeMillis()+5000;
        while(true){
            for(Future<String> r:intResults){
                if(r.isDone()){
                    try{
                        System.out.println(r.get());
                    }catch(Exception e){
                        throw new RunTimeException();
                    }
                    intResults.remove(r);
                }
            }
            for(Future<String> r:floatResult){
                if(r.isDone()){
                    try{
                        System.out.println(r.get());
                    }catch(Exception e){
                        throw new RunTimeException();
                    }
                    floatResult.remove(r);
                }
            }
            if(System.currentTimeMillis() >= endAt){
                break;
            }
            sleep(100);
        }
    }
    public static void main(String args[]){
        Exercise test = new Exercise();
        for (int i = 0; i<10;i++){
            test.calculanteInt(test.rand.nextInt(100), test.rand.nextInt(100));
            test.calculanteInt(test.rand.nextFloat()*test.rand.nextInt(100), (test.rand.nextFloat()*test.rand.nextInt(100)));
        }
        test.showResult();
        test.shutdown();
    }
}