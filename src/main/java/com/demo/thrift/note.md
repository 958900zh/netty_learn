## Thrift架构


client||service
---|---|---
Your Code || Your Code
FooService.Client || FooService.Processor
Foo.write()/read() |  Foo.read()/write()
TProtocol || TProtocol
TTransport || TTransport

## Thrift传输格式
- #### TBinaryProtocol 二进制格式
- #### TCompactProtocol 压缩格式
- #### TJSONProtocol JSON格式
- #### TSimpleJSONProtocol 提供JSON只写协议，生成的文件很容易通过脚本语言解析
- #### TDebugProtocol 使用易懂的可读的文本格式，以便于debug

## Thrift数据传输方式
- #### TSocket 阻塞式socket
- #### TFramedTransport 以frame为单位进行传输，非阻塞式服务中使用
- #### TFileTransport 以文件形式进行传输
- #### TMemoryTransport 将内存用于I/O，Java实现时内部实际使用了简单的ByteArrayOutStream
- #### TZlibTransport 使用zlib进行压缩，与其他传输方式联合使用

## Thrift支持的服务模型
- #### TSimpleServer 简单的单线程服务模型，常用于测试
- #### TThreadPoolServer 多线程服务模型，使用标准的阻塞式IO
- #### TNonblockingServer 多线程服务模型，使用非阻塞式IO（需使用TFramedTransport数据传输方式）
- #### THsHaServer THsHa引入了线程池去处理，其模型把读写任务放到线程池去处理；Half-sync/Half-async的处理模式，Half-async是在处理IO事件上（accept/read/write io），Half-sync用于handler对rpc的同步处理
