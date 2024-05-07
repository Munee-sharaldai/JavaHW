package edu.phystech.hw4.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kzlv4natoly
 */
public class CASTicketLock {
    private final AtomicInteger nextTicket = new AtomicInteger(1);
    private final AtomicInteger currentTicket = new AtomicInteger();


    public void lock() {
        int myTicket = nextTicket.getAndIncrement();
        while (currentTicket.get() != myTicket - 1) {
        }
    }

    public void unlock() {
        currentTicket.incrementAndGet();
    }
}
