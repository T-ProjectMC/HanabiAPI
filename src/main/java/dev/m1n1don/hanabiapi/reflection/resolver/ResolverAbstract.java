package dev.m1n1don.hanabiapi.reflection.resolver;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Abstract resolver class
 *
 * @param <T> resolved type
 * @see ClassResolver
 * @see ConstructorResolver
 * @see FieldResolver
 * @see MethodResolver
 */
public abstract class ResolverAbstract<T>
{
    protected final Map<ResolverQuery, T> resolvedObjects = new ConcurrentHashMap<ResolverQuery, T>();

    /**
     * Same as {@link #resolve(ResolverQuery...)} but throws no exceptions
     *
     * @param queries Array of possible queries
     * @return the resolved object if it was found, <code>null</code> otherwise
     */
    protected T resolveSilent(ResolverQuery... queries)
    {
        try { return resolve(queries); }
        catch (Exception ex) { ex.printStackTrace(); }
        return null;
    }

    /**
     * Attempts to resolve an array of possible queries to an object
     *
     * @param queries Array of possible queries
     * @return the resolved object (if it was found)
     * @throws ReflectiveOperationException if none of the possibilities could be resolved
     * @throws IllegalArgumentException     if the given possibilities are empty
     */
    protected T resolve(ResolverQuery... queries) throws ReflectiveOperationException
    {
        if (queries == null || queries.length <= 0) { throw new IllegalArgumentException("Given possibilities are empty"); }
        for (ResolverQuery query : queries)
        {
            if (resolvedObjects.containsKey(query)) { return resolvedObjects.get(query); }
            try
            {
                T resolved = resolveObject(query);
                resolvedObjects.put(query, resolved);
                return resolved;
            }
            catch (ReflectiveOperationException ex) { ex.printStackTrace(); }
        }
        throw notFoundException(Arrays.asList(queries).toString());
    }

    protected abstract T resolveObject(ResolverQuery query) throws ReflectiveOperationException;

    protected ReflectiveOperationException notFoundException(String joinedNames)
    {
        return new ReflectiveOperationException("Objects could not be resolved: " + joinedNames);
    }

}