package designpattern.chainOfResponsibility;

public class ChainMain {
    public static void main(String[] args) {
              LogProcessor logProcessor=new LogInfo(new LogDebug(new LogError(null)));
              logProcessor.log(LogProcessor.ERROR,"Exception Occur");
              logProcessor.log(LogProcessor.DEBUG,"debug the issue");
              logProcessor.log(LogProcessor.INFO,"print the info");

    }
}
