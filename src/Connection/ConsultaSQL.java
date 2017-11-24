package Connection;

public class ConsultaSQL {

    private String query="";
    public String hacerInsert(String tabla,String[]data)
    {
        query="INSERT INTO `Clima`.`"+tabla+"` VALUES (\"";
        for (int i=0;i<data.length;i++)
        {
            if (i==0)query+=data[i];
            else query+="\", \""+data[i];
        }
        query+="\")";
        return query;
    }






}
