package de.devoxx4kids.dronecontroller.network;

import de.devoxx4kids.dronecontroller.command.Command;
import de.devoxx4kids.dronecontroller.listener.EventListener;

/**
 * @author Tobias Schneider
 */
public interface DroneConnection {

    /**
     * Connect with the drone with the constructor injected credentials.
     *
     * @throws ConnectionException when the connection to the drone could not be
     * established
     */
    void connect() throws Exception;

    /**
     * Disconnects the drone and stops the sender and dispatcher.
     */
    void disconnect();

    /**
     * Sends the given {@link Command} to the drone.
     *
     * @param command to send to drone
     */
    void sendCommand(Command command) throws Exception;

    /**
     * Register the given {@link EventListener} to the {@link DroneConnection}.
     *
     * @param eventListener with the capsuled functionality
     */
    void addEventListener(EventListener eventListener);
}
