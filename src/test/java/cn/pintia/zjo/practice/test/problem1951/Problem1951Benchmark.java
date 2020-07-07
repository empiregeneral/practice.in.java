package cn.pintia.zjo.practice.test.problem1951;

import cn.pintia.zjo.practice.problem1951.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class Problem1951Benchmark {

    @Benchmark
    public void testProblem1951Main() throws FileNotFoundException {
        Main.main(new String[]{"C:\\empiregeneral.github\\practice.in.java\\src\\main\\java\\cn\\pintia\\zjo\\practice\\problem1951\\TestCases_1951.txt"});
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder().include(Problem1951Benchmark.class.getSimpleName()).
                      output("C:\\Benchmark.log").warmupIterations(1).forks(1).measurementIterations(2).build();
        new Runner(opt).run();

    }


}
