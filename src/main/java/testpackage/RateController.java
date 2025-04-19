package testpackage;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/*
 My rate limit is on number of 10 per sec and it should failed if it time passes
 So basically a new api to get request and send response into this time limit and if exists then
 fail the request.
 */
class RateLimit {

private final int rateLimit;

private final Queue<Long> timestamps;

public RateLimit(int rateLimit){
    this.rateLimit=rateLimit;
    this.timestamps=new LinkedList<>();
}

public synchronized boolean allowRequest(){
    // to take current time
    long currentTime=System.currentTimeMillis();
    while(!timestamps.isEmpty() && ((currentTime -timestamps.peek()) > TimeUnit.MILLISECONDS.toMillis(1000))){
        timestamps.poll();
    }
    if(timestamps.size()<rateLimit){
        timestamps.offer(currentTime);
        return true;
    }else{
        return false;
    }

}

}

public class RateController{

    private final RateLimit rateLimit;

    public RateController(){
        this.rateLimit=new RateLimit(10);
    }

    public String handleRequest(){
        if(rateLimit.allowRequest()){
            return "handled request successfully";
        }
        return "Rate limit exceed! Please try after sometime";
    }

    public static void main(String[] args) throws InterruptedException {
        RateController rateController=new RateController();
        for(int i=0;i<1000;i++) {
            System.out.println(rateController.handleRequest());
            Thread.sleep(50);
        }
    }
}


