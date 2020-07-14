package cn.pintia.zjo.practice.test.problem1951;

import cn.hutool.core.util.ClassLoaderUtil;
import cn.pintia.zjo.practice.problem1951.GFG;
import cn.pintia.zjo.practice.problem1951.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class Problem1951Benchmark {
    private final String pathInTestFile = "";

    @Benchmark
    public void testGFG() throws FileNotFoundException {
        GFG.main(new String[]{"E:\\coding\\src\\main\\java\\cn\\pintia\\zjo\\practice\\problem1951\\TestCases_1951.txt"});
    }

    @Benchmark
    public void testMain() throws FileNotFoundException {
        Main.main(new String[]{"E:\\coding\\src\\main\\java\\cn\\pintia\\zjo\\practice\\problem1951\\TestCases_1951.txt"});    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder().include(Problem1951Benchmark.class.getSimpleName()).
                      output("C:\\Benchmark.log").warmupIterations(1).forks(1).measurementIterations(5).build();
        new Runner(opt).run();

    }


}
