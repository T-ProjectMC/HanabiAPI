package dev.m1n1don.hanabiapi.reflection.resolver.minecraft;

import dev.m1n1don.hanabiapi.reflection.minecraft.Minecraft;
import dev.m1n1don.hanabiapi.reflection.resolver.ClassResolver;

/**
 * {@link ClassResolver} for <code>net.minecraft.server.*</code> classes
 */
@SuppressWarnings({"rawtypes"})
public class NMSClassResolver extends ClassResolver
{
    @Override
    public Class resolve(String... names) throws ClassNotFoundException
    {
        for (int i = 0; i < names.length; i++) if (!names[i].startsWith("net.minecraft.server")) names[i] = "net.minecraft.server." + Minecraft.getVersion() + names[i];
        return super.resolve(names);
    }
}