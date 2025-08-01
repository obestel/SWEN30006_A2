package config;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Configuration
{
    private static final String SEED_KEY = "Seed";
    private static final String ANIMATE_KEY = "Animate";
    private static final String PLAYER0_KEY = "Player0";
    private static final String PLAYER1_KEY = "Player1";

    private static Configuration configuration = null;

    private int seed;
    private boolean animate;
    private String player0class;
    private String player1class;

    public static Configuration getInstance()
    {
        if(configuration == null)
        {
            configuration = new Configuration();

            try {
                configuration.setUp();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return configuration;
    }

    private void setUp() throws IOException 
    {
        // Default properties

        // Read properties
        Properties properties = new Properties();
        FileReader inStream = null;
        try {
            inStream = new FileReader("pasur.properties");
            properties.load(inStream);
        } finally {
            if (inStream != null) {
                inStream.close();
            }
        }
        try {
            FileWriter out = new FileWriter("pasur.log");
            // Seed
            seed = Integer.parseInt(properties.getProperty(SEED_KEY));
          //  System.out.println("#Seed: " + seed);
            out.write("#Seed: " + seed + "\n");

            // Animate
            animate = Boolean.parseBoolean(properties.getProperty(ANIMATE_KEY));
           // System.out.println("#Animate: " + animate);
            out.write("#Animate: " + animate + "\n");


            // Player0
            player0class = properties.getProperty(PLAYER0_KEY);
         //   System.out.println("#Player0: " + player0class);
            out.write("#Player0: " + player0class + "\n");


            // Player1
            player1class = properties.getProperty(PLAYER1_KEY);
          //  System.out.println("#Player1: " + player1class);
            out.write("#Player1: " + player1class + "\n");

            out.close();

        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int getSeed()
    {
        return seed;
    }

    public boolean isAnimate()
    {
        return animate;
    }

    public String getPlayer0class()
    {
        return player0class;
    }

    public String getPlayer1class()
    {
        return player1class;
    }
}
