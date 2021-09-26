import pymysql
import model
from typing import Type


def get_db():

    return pymysql.connect(host= "localhost", user="root", password="1234", db="crawl", charset="utf8")

def insertData(getModel: Type[model.model]) :

    
    conn = get_db()
    curs = conn.cursor()
    sql = "insert into model (title, price, link, data_type, fileName, imagePath) VALUES ("+ '\''+str(getModel.getTitle()) + '\''', '+ '\''+ str(getModel.getPrice())+'\'' + ', '+ '\''+str(getModel.getLink()) + '\''+', ' + '\''+ str(getModel.getType()) + '\''+', '+ '\''+str(getModel.getFileName())+'\''+', '+ '\''+str(getModel.filePath)+'\'' + ')'
    curs.execute(sql)

    
    conn.commit()
    
    

def close_conn() :
    conn.close()



    


