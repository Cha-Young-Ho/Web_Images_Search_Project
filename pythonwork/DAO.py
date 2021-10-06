import pymysql
import model
from typing import Type



def get_db():

    return pymysql.connect(host= "localhost", user="root", password="1234", db="crawl", charset="utf8")

def insertData(getModel: Type[model.model]) :

    
    conn = get_db()
    curs = conn.cursor()
    sql = "insert into model (title, price, link, data_type, image_name, image_path) VALUES ("+ '\''+str(getModel.getTitle()) + '\''', '+ '\''+ str(getModel.getPrice())+'\'' + ', '+ '\''+str(getModel.getLink()) + '\''+', ' + '\''+ str(getModel.getDataType()) + '\''+', '+ '\''+str(getModel.getImageName())+'\''+', '+ '\''+str(getModel.getImagePath())+'\'' + ')'
    curs.execute(sql)

    
    conn.commit()

def selectData(query):
    conn = get_db()
    sql = "select * from model where data_type = \'"+ query + "\'"

    with conn:
        with conn.cursor() as cur:
            cur.execute(sql)
            result = cur.fetchall()
            return result

           
           
    


def close_conn() :
    get_db.close()




    


