package org.blue;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioSever {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);


        serverSocketChannel.bind(new InetSocketAddress(8888));

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> selectionKeysIterator = selectionKeys.iterator();

            while (selectionKeysIterator.hasNext()) {

                SelectionKey nextKey = selectionKeysIterator.next();

                if (nextKey.isAcceptable()) {
                    SocketChannel acceptChannel = serverSocketChannel.accept();
                    acceptChannel.configureBlocking(false);
                    acceptChannel.register(selector, SelectionKey.OP_READ);

                } else if (nextKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) nextKey.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                    int length = 0;
                    while ((length = socketChannel.read(readBuffer)) > 0) {
                        readBuffer.flip();
                        System.out.println("received: " + new String(readBuffer.array(), 0, length));
                        readBuffer.clear();
                    }

                }

                selectionKeysIterator.remove();
            }
        }

    }

}
