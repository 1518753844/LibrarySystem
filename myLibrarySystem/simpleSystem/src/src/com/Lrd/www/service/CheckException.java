package src.com.Lrd.www.service;

/**
 * @date 2020/2/24-8:07
 */
public class CheckException extends Exception {
    private String concreteException = null;

    public CheckException(String concreteException) {
        this.concreteException = concreteException;
    }

    public String getConcreteException() {
        return concreteException;
    }
}
