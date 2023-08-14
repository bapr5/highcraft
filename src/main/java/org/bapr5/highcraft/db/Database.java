package org.bapr5.highcraft.db;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Database {
    private File dataFile;
    private YamlConfiguration dataConfig;

    public Database() {

        dataFile = new File("data.yml");
        dataConfig = YamlConfiguration.loadConfiguration(dataFile);
    }

    public void savePlayerXP(String playerName, int xp) {
        dataConfig.set(playerName + ".xp", xp);

        try {
            dataConfig.save(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
