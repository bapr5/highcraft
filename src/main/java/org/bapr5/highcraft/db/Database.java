package org.bapr5.highcraft.db;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Database {
    private File dataFile;
    private YamlConfiguration dataConfig;

    public Database() {

        dataFile = new File("playerxp.yml");
        dataConfig = YamlConfiguration.loadConfiguration(dataFile);
    }

    public void savePlayerXP(String playerName, int xp) {
        if (!dataConfig.contains(playerName)) {
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
    public void SetPlayerClass(String playerName, String playerClass) {
        if (!dataConfig.contains(playerName)) {
            if (dataConfig.contains(playerName)) {
                dataConfig.set(playerName + ".class", playerClass);
            }
        }

        try {
            dataConfig.save(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String GetPlayerClass(String playerName) {
        if (dataConfig.contains(playerName)) {
            if (dataConfig.contains(playerName+".class")) {
                String myClass = dataConfig.getString(playerName + ".class");
                return myClass;
            }
        }

        return null;
    }

}
