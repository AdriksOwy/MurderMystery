package com.murder.object;

import com.murder.objects.SynchronizedQueue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SynchronizedQueueTest {
    SynchronizedQueue queue;

    @Before
    public void init(){
        queue = new SynchronizedQueue<Object>();
    }
    @Test
    public void testArePushAndPopWorkProperlyOnOneThread(){
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());
    }
}
