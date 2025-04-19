package designpattern.chainOfResponsibility;

public class LogDebug extends LogProcessor{
    LogDebug(LogProcessor logProcessor){
        super(logProcessor);
    }

    public void log(int level,String message){
        if(level==DEBUG){
            System.out.println("debug: "+message);
        }else {
            super.log(level,message);
        }
    }
}
