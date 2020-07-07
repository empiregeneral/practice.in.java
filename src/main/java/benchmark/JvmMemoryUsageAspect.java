package benchmark;

import cn.hutool.aop.aspects.SimpleAspect;
import cn.hutool.core.lang.Console;

import java.lang.reflect.Method;


public class JvmMemoryUsageAspect extends SimpleAspect {
    private Runtime runtime = Runtime.getRuntime();
    private Long concurrentMemoryBefore = 0L;
    private Long concurrentMemoryAfter = 0L;

    @Override
    public boolean before(Object o, Method method, Object[] objects) {
        concurrentMemoryBefore = bytesToKB(runtime.totalMemory() -  runtime.freeMemory());
        Console.log("UsedMemory In JVM: [{}] KB", concurrentMemoryBefore );
        return true;
    }

    @Override
    public boolean after(Object target, Method method, Object[] objects) {
        concurrentMemoryAfter = bytesToKB(runtime.totalMemory() - runtime.freeMemory());
        Console.log("UsedMemory In JVM: [{}] KB", concurrentMemoryAfter);
        Console.log("Method [{}.{}] execute spend memories [{}] KB", target.getClass().getName(), method.getName(),   concurrentMemoryAfter - concurrentMemoryBefore);
        return true;
    }

    @Override
    public boolean afterException(Object o, Method method, Object[] objects, Throwable throwable) {
        return false;
    }

    private Long bytesToKB(long bytes) {
        return bytes / 1024 ;
    }
}
