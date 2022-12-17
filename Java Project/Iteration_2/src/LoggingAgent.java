package Iteration_2.src;

import org.apache.logging.log4j.*;

import java.util.logging.Logger;

public class LoggingAgent {
    
    public void LoggerMethod() {
        Logger logger = (Logger) LogManager.getLogger();
        logger.info(getMethodName(1));
    }

	public static String getMethodName(final int depth){
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		return ("Method '" + ste[ste.length - 1 - depth].getMethodName() + "' has been executed.");
	}

}
