package SoftServe.Task_1.IO.Exceptions;

public class SelfFormatException extends Exception {

    public SelfFormatException(ExceptionList exceptionType) {
        switch (exceptionType){
            case INVALID_NAME: {
                System.err.println("Invalid format NAME. Please, enter correct value");
                this.printStackTrace();
            }
            case INVALID_LAST_NAME: {
                System.err.println("Invalid format LAST NAME. Please, enter correct value");
                this.printStackTrace();
            }
            case INVALID_BIRTH_DATE: {
                System.err.println("Invalid format BIRTH DATE. Please, enter correct value");
                this.printStackTrace();
            }
            case INVALID_ANALYZES_TYPE:{
                System.err.println("Invalid format ANALYZES TYPE. Please, enter correct value");
                this.printStackTrace();
            }
            case INVALID_ANALYZES_DATE:{
                System.err.println("Invalid format ANALYZES DATE. Please, enter correct value");
                this.printStackTrace();
            }
            case INVALID_ANALYZES_REPORT:{
                System.err.println("Invalid format ANALYZES REPORT. Please, enter correct value");
                this.printStackTrace();
            }
            case DEFAULT: {
                System.err.println("Invalid format INPUT VALUES. Please, enter correct value");
                this.printStackTrace();
            }
        }
    }
}
