package com.wang.sharding.algorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Created by wang on 2018/3/6.
 */
public class StudentSingleKeyTableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Integer>{
    public String doEqualSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        for (String each : collection) {
            if (each.endsWith(shardingValue.getValue() % 2 + "")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(collection.size());
        for (Integer value : shardingValue.getValues()) {
            for (String tableName : collection) {
                if (tableName.endsWith(value % 2 + "")) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }

    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(collection.size());
        Range<Integer> range = (Range<Integer>) shardingValue.getValueRange();
        for (Integer i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String each : collection) {
                if (each.endsWith(i % 2 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
