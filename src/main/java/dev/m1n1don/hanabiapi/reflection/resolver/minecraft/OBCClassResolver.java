package dev.m1n1don.hanabiapi.reflection.resolver.minecraft;

import dev.m1n1don.hanabiapi.reflection.minecraft.Minecraft;
import dev.m1n1don.hanabiapi.reflection.resolver.ClassResolver;

/**
 * {@link ClassResolver} for <code>org.bukkit.craftbukkit.*</code> classes
 */
@SuppressWarnings({"rawtypes"})
public class OBCClassResolver extends ClassResolver
{
    @Override
    public Class resolve(String... names) throws ClassNotFoundException
    {
        for (int i = 0; i < names.length; i++) if (!names[i].startsWith("org.bukkit.craftbukkit")) names[i] = "org.bukkit.craftbukkit." + Minecraft.getVersion() + names[i];
        return super.resolve(names);
    }
}