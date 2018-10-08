from py.thrift.generated import PersonService
from PersonServiceImpl import PersonServiceImpl
from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TCompactProtocol
from thrift.server import TServer

try:
    personServiceHandler = PersonServiceImpl()
    processor = PersonService.Processor(personServiceHandler)

    serverSocket = TSocket.TServerSocket(host="127.0.0.1", port=8899)
    transportFactory = TTransport.TFramedTransportFactory()
    protocolFactory = TCompactProtocol.TCompactProtocolFactory()

    server = TServer.TSimpleServer(processor, serverSocket, transportFactory, protocolFactory)
    print("Python Server Started!")
    server.serve()

except Thrift.TException as tx:
    print('%s' % tx.message)
