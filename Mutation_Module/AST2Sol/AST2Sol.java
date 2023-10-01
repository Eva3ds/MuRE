public class AST2Sol { //测试类
    public static void trans(String inPath,String outPath){
        try {
            BufferedReader br = new BufferedReader(new FileReader(inPath));// 读取原始json文件
            try {
                //文件生成路径
                PrintStream ps=new PrintStream(outPath);
                System.setOut(ps);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String s  = null;
            String json="";
            while ((s = br.readLine()) != null) {
                try {
                    json+=s;
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            SourceUnit su= JSON.parseObject(json, SourceUnit.class);
            su.output();
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
