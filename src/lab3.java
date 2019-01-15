import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class lab3 {




    public static void main(String[] args) {

        CommonResource commonResource= new CommonResource();
        for (int i = 1; i < 3; i++){

            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread "+ i);
            t.start();
        }

    }
}

class CommonResource{

    int x=0;
    synchronized void increment(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        for (int i = 1; i < 5; i++){
            if(Thread.currentThread().getName().equals("Thread 1"))x++;
            System.out.printf("%s\n",Thread.currentThread().getName());
            date = new Date();
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){}
        }
        System.out.print(dateFormat.format(date));
        System.out.println(" "+x);
    }
}

class CountThread implements Runnable{

    CommonResource res;
    CountThread(CommonResource res){
        this.res=res;
    }

    public void run(){
        res.increment();
    }
}