package dev.m1n1don.hanabiapi.particle;

@SuppressWarnings("serial")
public class ParticleException extends RuntimeException
{
    public ParticleException(String message)
    {
        super(message);
    }

    public ParticleException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ParticleException(Throwable cause)
    {
        super(cause);
    }

    public ParticleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}