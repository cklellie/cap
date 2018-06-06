package io.cap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;


/**
 * Store for contextual information stored as key value pairs.
 *
 * Only allows for addition and retrieval, no removal.
 */
public class Context implements Serializable
{
    private static final long serialVersionUID = 1L;

    HashMap<String,Object> map = new HashMap<>();

    /**
     * Add the key value pair to the context.
     * Overwrites already existing keys.
     *
     * @param key key to register
     * @param value value to register to key
     */
    public void put(String key, Object value)
    {
        map.put( key, value );
    }

    /**
     * Merge the given context against the current context.
     * If the given context is null, no change occurs.
     * @param c source context to merge.
     */
    public void merge( Context c )
    {
        if( c == null )
        {
            return;
        }
        map.putAll( c.map );
    }

    /**
     * Check if the key is contained in the context.
     * @param key to check for.
     * @return if the key exists.
     */
    public boolean containsKey(String key)
    {
        return map.containsKey( key );
    }

    /**
     * Size of the keys.
     * @return
     */
    public int size()
    {
        return map.size();
    }

    /**
     * Get the value for the key.
     * An implicit cast is perform to the desired expect type.
     *
     * @param key to find.
     * @param <T> implicitly cast to this type.
     * @return value associated with key or null if not present.
     */
    @SuppressWarnings("unchecked")
    public <T>T get( String key )
    {
        return (T)map.get(key);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Context context = (Context) o;
        return Objects.equals(map, context.map);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(map);
    }

    @Override
    public String toString()
    {
        return "Context"
                 + map;
    }
}
