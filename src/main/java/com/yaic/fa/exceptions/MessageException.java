package com.yaic.fa.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @Author lujicong
 * @Date: 2015-12-23
 * @Version: 1.0
 */
public class MessageException extends RuntimeException {
    private static final long serialVersionUID = -512526081281908583L;
    public static final int UNKNOWN_ERROR = 0;
    public static final String UNKNOWN_ERROR_MSG = "";
    private String errorCode;
    private String traceId;

    public MessageException() {
        this("");
    }

    public MessageException(String message) {
        this(null, message, null);
    }

    public MessageException(String errorCode, String errorMsg, String traceId) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.traceId = traceId;
    }

    public MessageException(String errorCode, String errorMsg) {
        this(errorCode, errorMsg, null);
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream ps) {
        if (getCause() == null) {
            super.printStackTrace(ps);
        } else {
            ps.println(this);
            getCause().printStackTrace(ps);
        }
    }

    public void printStackTrace(PrintWriter pw) {
        if (getCause() == null) {
            super.printStackTrace(pw);
        } else {
            pw.println(this);
            getCause().printStackTrace(pw);
        }
    }

    public Throwable getCause() {
        return null;
    }

    public String getMessage() {
        return super.getMessage();
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getTraceId() {
        return this.traceId;
    }
}