public class Generate { //测试类
    public static void main(String[]args) {
       /* try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\belikout\\\\Desktop\\\\ast.json"));// 读取原始json文件

            String s  = null;
            String json="";
            while ((s = br.readLine()) != null) {
                try {
                    json+=s;
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }*/
       String proName="cryptofin-solidity";
       String proConPath="contracts\\basic";
        File file = new File("C:\\Users\\zhuka\\Desktop\\all_object\\"+proName+"\\"+proConPath);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isFile()) {
                    String fileName = file2.getName().substring(0,file2.getName().length()-4);
                    String json = GenASTServiceClient.genAST("C:\\Users\\zhuka\\Desktop\\all_object\\" + proName + "\\" + proConPath + "\\" + fileName + ".sol");
                    //stateMutability: pure constant payable view
                    String outPath = "C:\\Users\\zhuka\\Desktop\\all\\" + proName + "\\" + proConPath.substring(9) + "\\";
                    SourceUnit su = JSON.parseObject(json, SourceUnit.class);
                    ArrayList<MuType> type = new ArrayList<MuType>();
                    String[] typeslist = {"AOR", "AOI", "ROR", "COR", "LOR", "ASR", "SDL", "RVR", "CSC", "FSC", "FVC", "DLR", "VTR", "PKD", "DKD", "GVC", "MFR", "AVR", "EUR", "TUR", "RSD", "RSC", "ASD", "ASC"};
                    type.add(MuType.AOR);
                    type.add(MuType.ASR);
                    type.add(MuType.ROR);
                    type.add(MuType.COR);
                   /* type.add(MuType.FSC);
                    type.add(MuType.FVC);
                    type.add(MuType.PKD);
                    type.add(MuType.RSD);*/
                    type.add(MuType.RSC);
                    //type.add(MuType.CSC);
                   // type.add(MuType.EUR);
                    type.add(MuType.TFR);
                    Mutant.clear();
                    su.output();
                    su.addToMutant(type);
                    System.out.println(Mutant.lines.size());
                    Mutant.Repair();
                    for (int i = 0; i < Mutant.mutateLine.size(); i++) {
                        try {
                            String content = "";
                            for (int j = 0; j < Mutant.lines.size(); j++) {
                                if (j != Mutant.mutateLineNums.get(i)) {
                                    content += Mutant.lines.get(j).getContent() + "\n";
                                } else {
                                    content += Mutant.mutateLine.get(i) + "\n";
                                }
                            }
                            FileWriter fileWritter = new FileWriter(outPath + fileName + "#" + i + "_" + typeslist[Mutant.mutateLineTypeNums.get(i)] + "_" + Mutant.mutateLineNums.get(i) + ".sol");
                            fileWritter.write(content);
                            fileWritter.close();


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
            }
    }
    /*public void generateMutant(Object mutypes){
        System.out.println("okkkkkkkkkkkkkkkkk");
        System.out.println(mutypes==null);
        ArrayList<ArrayList> arr=new ArrayList<ArrayList>();
        JSONArray res=new JSONArray();
        JSONArray oriLine=new JSONArray();
        JSONArray mutLine=new JSONArray();
        JSONArray mutLineNum=new JSONArray();
        JSONArray mutLinetype=new JSONArray();
        res.add(oriLine);
        res.add(mutLine);
        res.add(mutLineNum);
        res.add(mutLinetype);

    }*/

