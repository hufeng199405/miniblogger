package com.blogger.user.web.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  * 设计一个缓存系统
 *  *
 *  *
 *  * @author Administrator
 *  *
 *  
 */
public class CacheDemo {

    private Map<String, Object> cache = new HashMap<String, Object>();

    public static void main(String[] args) {

        String key = "name";
        CacheDemo cacheDemo = new CacheDemo();
        System.out.println(cacheDemo.getData(key)); //从数据库获取数据
        System.out.println(cacheDemo.getData(key)); //从缓存获取数据
        System.out.println(cacheDemo.getData(key)); //从缓存获取数据
    }

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public Object getData(String key) {

        System.out.print("尝试获取锁："+rwl.readLock().tryLock());
        //上读锁
        rwl.readLock().lock();

        Object value = null;

        try {

            //先查询内部存储器中有没有要的值
            value = cache.get(key);

            //如果没有，就去数据库中查询，并将查到的结果存入内部存储器中
            if (value == null) {

                //释放读锁、上写锁
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try {

                    //再次进行判断，防止多个写线程堵在这个地方重复写
                    if (value == null) {
                        System.out.println("read data from database");
                        value = "张三";
                        cache.put(key, value);
                    }
                } finally {

                    //设置完成 释放写锁
                    rwl.writeLock().unlock();
                }
                //恢复读写状态
                rwl.readLock().lock();
            } else {
                System.out.println("read data from cache");
            }
        } finally {

            //释放读锁
            rwl.readLock().unlock();
        }

        return value;
    }
}