public class Mutant {
    public static ArrayList<Line>lines=new ArrayList<Line>();
    public static ArrayList<Integer>mutateLineNums=new ArrayList<Integer>();//可变异代码 行序号
    public static ArrayList<Integer>mutateLineTypeNums=new ArrayList<Integer>();//可变异代码 使用算子
    public static ArrayList<Integer> mutateLineRepairFromNums =new ArrayList<Integer>();
    //public static ArrayList<Integer> mutateLineSwitchFromNums =new ArrayList<Integer>();
    public static ArrayList<String>mutateLine=new ArrayList<String>();//可变异代码 行内容
    public static String content="";
    public static void clear(){
        lines=new ArrayList<Line>();
        mutateLineNums=new ArrayList<Integer>();
        mutateLineTypeNums=new ArrayList<Integer>();
        mutateLineRepairFromNums =new ArrayList<Integer>();
        mutateLine=new ArrayList<String>();

     //   mutateLineSwitchFromNums =new ArrayList<Integer>();
    }
    public static void Repair(){              //每次注入故障后，将AST修复，等待执行下一个变异体
        String space="";


        for(int i=0;i<mutateLine.size();i++){
            space="";
            for(int j=0;j<lines.get(mutateLineNums.get(i)).getSpace();j++)
                space+="    ";

            mutateLine.set(i,space+mutateLine.get(i)+lines.get(mutateLineNums.get(i)).getContent().substring(mutateLineRepairFromNums.get(i)));
        }
        for(int i=0;i<lines.size();i++){
            space="";

            for(int j=0;j<lines.get(i).getSpace();j++)
                space+="    ";
            lines.get(i).setContent(space+lines.get(i).getContent());
        }
    }

    public static void PrintMutant() {
        String space="";

        for(int i=0;i<lines.size();i++){
            space="";

            for(int j=0;j<lines.get(i).getSpace();j++)
                space+="    ";
            content+=space+lines.get(i).getContent()+"\n";

        }

        try {
            FileWriter writer = new FileWriter(new File("E:\\project\\mutant.txt"));
            writer.write(content);
            System.out.println("写操作");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        //public static void Switch(){}
}
