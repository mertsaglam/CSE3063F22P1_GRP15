package Iteration_2.src;

import org.apache.logging.log4j.*;


public class LoggingAgent {
    
    public void LoggerMethod() {
        Logger logger = LogManager.getLogger();
        logger.info(getMethodName(1));
    }
