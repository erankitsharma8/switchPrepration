package designpattern.chainOfResponsibility;

public class LogError extends LogProcessor{
    LogError(LogProcessor logProcessor){
        super(logProcessor);
    }

    public void log(int level,String message){
        if(level==ERROR){
            System.out.println("Error: "+message);
        }else {
            super.log(level,message);
        }
    }
}
