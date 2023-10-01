public class GenASTServiceClient {

    public static void main(String[] args) {
        genAST("E:\\\\project\\\\delegatecall\\\\contracts\\\\Bank.sol");
    }
    public static String genAST(String SolPath){
        System.out.println("客户端启动....");
        TTransport transport = null;
        try {
            transport = new TSocket("localhost", 9898, 30000);
            TProtocol protocol = new TBinaryProtocol(transport);
            GenAST.Client client = new GenAST.Client(protocol);

            transport.open();
            String result = client.genAST(getFile(SolPath));
            System.out.println(result);
            transport.close();
            return result;
        } catch (TTransportException e) {
            e.printStackTrace();
            return "TTransportError";
        } catch (TException e) {
            e.printStackTrace();
            return "TError";
        }
    }
    private static String getFile(String path){
        String out="";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));// 读取sol
            String s  = null;

            while ((s = br.readLine()) != null) {
                out+=s+"\n";
            }
            br.close();
            return out;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }

}

