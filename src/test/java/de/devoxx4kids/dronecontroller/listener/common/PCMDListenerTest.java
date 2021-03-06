package de.devoxx4kids.dronecontroller.listener.common;

import org.junit.gen5.api.BeforeEach;
import org.junit.gen5.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.core.Is.is;


/**
 * Unit test of {@link PCMDListener}.
 *
 * @author  Tobias Schneider
 */

class PCMDListenerTest {

    private PCMDListener sut;

    private String pcmd;

    @BeforeEach
    void initialize() {

        sut = PCMDListener.pcmdlistener(s -> pcmd = s);
    }


    @Test
    void testTestIsBatteryPacket() {

        byte[] tcpInPacket = new byte[] { -1, -1, -1, -1, -1, -1, -1, 3, 1, 0, -1, 11 };

        boolean test = sut.test(tcpInPacket);
        assertThat(test, is(true));
    }


    @Test
    void testTestIsNoBatteryPacket() {

        byte[] tcpInPacket = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, 127, -1, 11 };

        boolean test = sut.test(tcpInPacket);
        assertThat(test, is(false));
    }


    @Test
    void consume() {

        byte[] tcpInPacket = new byte[] { -1, -1, -1, -1, -1, -1, -1, 0, 5, 1, -1, 11 };

        sut.consume(tcpInPacket);
        assertThat(pcmd, is("11"));
    }
}
