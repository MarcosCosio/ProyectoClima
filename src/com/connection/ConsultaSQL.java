package com.connection;

import java.security.PublicKey;
import java.util.Enumeration;
import java.util.Hashtable;

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

    public String hacerUpdate(String tabla, String [] dataUp, String []id)
    {

        query = "UPDATE " + tabla + " SET ";
        for (int i = 0; i < dataUp.length; i++)
            {
                if (i==0)
                {
                    query+=dataUp[0];
                }
                else
                {
                    query+=" , "+dataUp[i];
                }
            }
        query +=" WHERE ";
        for (int i = 0; i < id.length; i++)
        {
            if (i==0)
            {
                query+=dataUp[0];
            }
            else
            {
                query+=" , "+dataUp[i];
            }
        }
            return  query;



    }

    public String select (String tabla,String[]col,String[]where)
    {
        query="SELECT ";
        if (col==null) {
            query += " * ";
        }
        else
        {
            for (int i=0;i<col.length;i++)
            {
                if(i==0) {
                    query += col[0];
                }
                else
                {
                    query += " , "+col[i];
                }
            }
        }
        query+=" FROM "+tabla+" ";
        if (where!=null)
        {
            for (int i=0;i<where.length;i++)
            {
                if(i==0) {
                    query += where[0];
                }
                else
                {
                    query += " , "+where[i];
                }
            }
        }
        return query;
    }
    public String hacerDelete(String tabla, String[]where)
    {
        query="DELETE FROM "+tabla+" WHERE ";
        for(int i=0;i<where.length;i++)
        {
            if(i==0) {
                query += where[0];
            }
            else
            {
                query += " , "+where[i];
            }
        }
        return query;
    }

}
