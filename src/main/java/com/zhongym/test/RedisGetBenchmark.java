package com.zhongym.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhongym.test.vo.PointsPriceVO;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

// Throughput: 整体吞吐量，例如“1秒内可以执行多少次调用”。
// AverageTime: 调用的平均时间，例如“每次调用平均耗时xxx毫秒”。
// SampleTime: 随机取样，最后输出取样结果的分布，例如“99%的调用在xxx毫秒以内，99.99%的调用在xxx毫秒以内”
// SingleShotTime: 以上模式都是默认一次 iteration 是 1s，唯有 SingleShotTime 是只运行一次。往往同时把 warmup 次数设为0，用于测试冷启动时的性能。
@BenchmarkMode(Mode.Throughput)//基准测试类型
@OutputTimeUnit(TimeUnit.SECONDS)//基准测试结果的时间类型
@Threads(2)//测试线程数量
@State(Scope.Thread)//该状态为每个线程独享
@Warmup(iterations = 1)//预热的迭代次数
//度量:iterations进行测试的轮次，time每轮进行的时长，timeUnit时长单位,batchSize批次数量
@Measurement(iterations = 10)
public class RedisGetBenchmark {

    private static JedisPool jedis;

    static {
        jedis = new JedisPool("192.168.2.33", 6379);
//        Jedis resource = jedis.getResource();
        long s = System.currentTimeMillis();
        try (Jedis resource = jedis.getResource()) {
            String v = resource.get("marketing:points:price:config_test");
            PointsPriceVO object = JSON.parseObject(v, PointsPriceVO.class);
            System.out.println(object);
        }
        long e = System.currentTimeMillis();
        System.out.println("----------"+(e - s));

    }

    //run
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RedisGetBenchmark.class.getSimpleName())
                .forks(1)
                //     使用之前要安装hsdis
                //-XX:-TieredCompilation 关闭分层优化 -server
                //-XX:+LogCompilation  运行之后项目路径会出现按照测试顺序输出hotspot_pid<PID>.log文件,可以使用JITWatch进行分析,可以根据最后运行的结果的顺序按文件时间找到对应的hotspot_pid<PID>.log文件
                .jvmArgs("-XX:+UnlockDiagnosticVMOptions") //, "-XX:+LogCompilation", "-XX:+TraceClassLoading", "-XX:+PrintAssembly"
                //  .addProfiler(CompilerProfiler.class)    // report JIT compiler profiling via standard MBeans
                //  .addProfiler(GCProfiler.class)    // report GC time
                // .addProfiler(StackProfiler.class) // report method stack execution profile
                // .addProfiler(PausesProfiler.class)
                /*
                WinPerfAsmProfiler
                You must install Windows Performance Toolkit. Once installed, locate directory with xperf.exe file
                and either add it to PATH environment variable, or set it to jmh.perfasm.xperf.dir system property.
                 */
                //.addProfiler(WinPerfAsmProfiler.class)
                //更多Profiler,请看JMH介绍
                //.output("com.zhongym.test.InstructionsBenchmark.log")//输出信息到文件
                .build();
        new Runner(opt).run();
    }


    //空循环 对照项
    @Benchmark
    public void getString() {
        try (Jedis resource = jedis.getResource()) {
            String v = resource.get("marketing:points:price:config_test");
            PointsPriceVO object = JSON.parseObject(v, PointsPriceVO.class);
        }
    }


}