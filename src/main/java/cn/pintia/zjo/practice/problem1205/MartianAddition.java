package cn.pintia.zjo.practice.problem1205;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.ReadOnlyBufferException;

/**
 * @ClassName: CalcMartianAddtion
 * @Description: TODO
 * @Author :lei.zhu
 * @Date 2019/12/16 14:08
 * @Version 1.0
 **/
public class MartianAddition implements Readable {
    /**
     * Attempts to read characters into the specified character buffer.
     * The buffer is used as a repository of characters as-is: the only
     * changes made are the results of a put operation. No flipping or
     * rewinding of the buffer is performed.
     *
     * @param cb the buffer to read characters into
     * @return The number of {@code char} values added to the buffer,
     * or -1 if this source of characters is at its end
     * @throws IOException             if an I/O error occurs
     * @throws NullPointerException    if cb is null
     * @throws ReadOnlyBufferException if cb is a read only buffer
     */
    @Override
    public int read(CharBuffer cb) throws IOException {
        return 0;
    }
}
