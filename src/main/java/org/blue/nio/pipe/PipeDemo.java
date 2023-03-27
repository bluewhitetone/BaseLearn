package org.blue.nio.pipe;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeDemo {

    public static void main(String[] args) throws Exception {
        Pipe pipe = Pipe.open();
        // write
        Pipe.SinkChannel sinkChannel = pipe.sink();

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        byteBuffer1.put("Hello Pipe".getBytes());
        byteBuffer1.flip();

        sinkChannel.write(byteBuffer1);

        // read
        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
        int length = sourceChannel.read(byteBuffer2);

        System.out.println("content: " + new String(byteBuffer2.array(), 0, length));

        // close
        sinkChannel.close();
        sourceChannel.close();
    }


}
