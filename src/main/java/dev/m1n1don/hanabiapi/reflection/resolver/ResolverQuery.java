package dev.m1n1don.hanabiapi.reflection.resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Container class for resolver-queries Used by {@link MethodResolver}
 */
public class ResolverQuery
{
    private String     name;
    private Class<?>[] types;

    public ResolverQuery(String name, Class<?>... types)
    {
        this.name = name;
        this.types = types;
    }

    public ResolverQuery(String name)
    {
        this.name = name;
        this.types = new Class[0];
    }

    public ResolverQuery(Class<?>... types)
    {
        this.types = types;
    }

    public String getName()
    {
        return name;
    }

    public Class<?>[] getTypes()
    {
        return types;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResolverQuery that = (ResolverQuery) o;

        if (!Objects.equals(name, that.name)) return false;
        return Arrays.equals(types, that.types);

    }

    @Override
    public int hashCode()
    {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (types != null ? Arrays.hashCode(types) : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "ResolverQuery{" +
                "name='" + name + '\'' +
                ", types=" + Arrays.toString(types) +
                '}';
    }

    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder class for {@link ResolverQuery} Access using {@link ResolverQuery#builder()}
     */
    public static class Builder
    {
        private List<ResolverQuery> queryList = new ArrayList<ResolverQuery>();

        public Builder with(String name, Class<?>[] types)
        {
            queryList.add(new ResolverQuery(name, types));
            return this;
        }

        public Builder with(String name)
        {
            queryList.add(new ResolverQuery(name));
            return this;
        }

        public Builder with(Class<?>[] types)
        {
            queryList.add(new ResolverQuery(types));
            return this;
        }

        public ResolverQuery[] build()
        {
            return queryList.toArray(new ResolverQuery[queryList.size()]);
        }
    }
}