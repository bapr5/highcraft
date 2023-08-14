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
        if (!dataConfig.contains(playerName)) {
            // Создание новой записи о игроке с начальным значением PlayerXP
            dataConfig.set(playerName + ".xp", 0);
        }
        xp += dataConfig.getInt(playerName + ".xp");
        dataConfig.set(playerName + ".xp", xp);
        try {
            dataConfig.save(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
