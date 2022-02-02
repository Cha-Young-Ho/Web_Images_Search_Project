import DAO
import model as mm
import ImageAnalyze
from typing import Type, List
import json




def modelToJson(modelList: List[Type[mm.model]]):

    jsonStr = '{ \"products\" : ['
    print(len(modelList))
    i = 0
    for model in modelList:
        if i == len(modelList) - 1 :
            jsonStr = jsonStr + json.dumps(model.__dict__, ensure_ascii=False)
            break


        jsonStr = jsonStr + json.dumps(model.__dict__, ensure_ascii=False) +','
        i = i + 1

    jsonStr = jsonStr + ']}'

    
    return jsonStr

def getSimilarImage(query, image) :
    list = DAO.selectData(query)

    modelList = []


    for data in list:
        getmodel = mm.model()
        getmodel.setTitle(data[0])
        getmodel.setPrice(data[1])
        getmodel.setLink(data[2])
        getmodel.setImagePath(data[3])
        getmodel.setDataType(data[4])
        getmodel.setImageName(data[5])
       
        
       
        if(ImageAnalyze.analyzeImageAndReturnImage(image, data[3])):

         modelList.append(getmodel)

    return modelToJson(modelList)



    
    

