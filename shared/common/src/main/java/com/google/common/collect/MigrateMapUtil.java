package com.google.common.collect;

import com.google.common.base.Function;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class MigrateMapUtil {

    @SuppressWarnings("deprecation")
    public static <K, V> ConcurrentMap<K, V> makeComputingMap(MapMaker maker,
                                                              Function<? super K, ? extends V> computingFunction) {
        return maker.makeComputingMap(computingFunction);
    }

    @SuppressWarnings("deprecation")
    public static <K, V> ConcurrentMap<K, V> makeComputingMap(Function<? super K, ? extends V> computingFunction) {
        return new MapMaker().makeComputingMap(computingFunction);
    }

    @SuppressWarnings("deprecation")
    public static <K, V> ConcurrentMap<K, V> makeComputingMapWithExpire(long duration,
                                                                        TimeUnit unit,
                                                                        Function<? super K, ? extends V> computingFunction) {
        return new MapMaker().expireAfterAccess(duration, unit).makeComputingMap(computingFunction);
    }

    @SuppressWarnings("deprecation")
    public static <K, V> MapMaker makeMapWithExpire(long duration, TimeUnit unit) {
        return new MapMaker().expireAfterAccess(duration, unit);
    }
}
