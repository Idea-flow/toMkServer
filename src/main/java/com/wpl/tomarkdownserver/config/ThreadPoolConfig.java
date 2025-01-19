package com.wpl.tomarkdownserver.config;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @Author wangpenglong
 * @Date 2024/9/3
 * @Description
 */
@Component
public class ThreadPoolConfig {
   public static ExecutorService getThreadPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNamePrefix("下载线程-").build();
       return new ThreadPoolExecutor(32, 64,
               0L, TimeUnit.MILLISECONDS,
               new LinkedBlockingQueue<Runnable>(255), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }
}
