package dev.m1n1don.hanabiapi;

import org.bukkit.plugin.java.JavaPlugin;

public class HanabiAPI extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getLogger().info("API Enable.");
    }

    @Override
    public void onDisable()
    {
        getLogger().info("API Disable.");
    }
}