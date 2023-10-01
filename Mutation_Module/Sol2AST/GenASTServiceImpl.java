public class GenASTServiceImpl implements GenAST.Iface{
    public String genAST(String sol) throws TException {
        System.out.println("receive: "+sol);
        return "result:"+sol;
    }
}
