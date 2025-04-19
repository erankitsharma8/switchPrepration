package designpattern.chainOfResponsibility;

public class LogInfo extends LogProcessor{

    LogInfo(LogProcessor logProcessor){
        super(logProcessor);
    }

    public void log(int level,String message){
      if(level==INFO){
          System.out.println("Info: "+message);
      }else {
          super.log(level,message);
      }
   }
}
