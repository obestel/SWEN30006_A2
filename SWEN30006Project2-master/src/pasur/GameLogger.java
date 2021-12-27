package pasur;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileWriter;
import java.io.IOException;

public class GameLogger implements PropertyChangeListener {
    private final String OUTPUT_FILE = "pasur.log";
    private static FileWriter fileWriter = null;

    public GameLogger(Pasur pasur) {
        pasur.addPropertyChangeListener(this);
    }

    /**
     * Writes information given in event to the log, whenever an event in Pasur is triggered
     * @param evt An event, contains a string to be written to log
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        /** Here, all events basically just result in the string being written to the logger,
         * but we have separated the event signalling the start of the game to illustrate this design could be
         * easily extended with new events and functionality conditional on event types if needed.
         */
        if (propertyName.equals(Pasur.ON_GAME_START)) {
            writeToLogger((String)evt.getNewValue());
        }
        else if (propertyName.equals(Pasur.GENERIC_EVENT)){
            writeToLogger((String)evt.getNewValue());
        }
    }

    /**
     * Writes string to output file, in this case the log
     * @param s String to be written
     */
    public void writeToLogger(Object s) {
        try {
             fileWriter = new FileWriter(OUTPUT_FILE, true);
             fileWriter.write(String.format("%s\n", s));
             fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
