import requests #requests 라이브러리 import
import json
import model
from datetime import datetime
import pathlib
import os
from urllib.request import urlretrieve
import DAO



headers = {
    'authority': 'search.shopping.naver.com',
    'sec-ch-ua': '"Google Chrome";v="93", " Not;A Brand";v="99", "Chromium";v="93"',
    'accept': 'application/json, text/plain, */*',
    'sec-ch-ua-mobile': '?0',
    'logic': 'PART',
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36',
    'sec-ch-ua-platform': '"Windows"',
    'sec-fetch-site': 'same-origin',
    'sec-fetch-mode': 'cors',
    'sec-fetch-dest': 'empty',
    'referer': 'https://search.shopping.naver.com/search/all?query=%EB%AA%A8%EC%9E%90&frm=NVSHATC&prevQuery=%EB%AA%A8%EC%9E%90',
    'accept-language': 'ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7',
    'cookie': 'NNB=NOLCMFH6MS3WA; NDARK=Y; _ga=GA1.2.36707839.1627031989; _ga_7VKFYR6RV1=GS1.1.1627031988.1.1.1627032122.60; nx_ssl=2; AD_SHP_BID=23; spage_uid=; BMR=s=1631641124319&r=https%3A%2F%2Fm.blog.naver.com%2FPostView.naver%3FisHttpsRedirect%3Dtrue%26blogId%3Dteenager4282%26logNo%3D220962394004&r2=https%3A%2F%2Fwww.google.com%2F; sus_val=G6C9UIqZv3AcfjeJP38FmfXG',
}






## Function Section ##

# Create Directory
def createDirectory(searchModel): 

    
    
    directory = 'C:/Users/ckdud/pythonwork/imageFiles/' + searchModel
    
    
    os.makedirs(directory, exist_ok=True) 
    os.chdir(directory)

# Save File
def saveFile(imgSrc, searchModel):
      
    path = pathlib.Path(imgSrc)

    if path.suffix == '.gif':
        return '정보 없음'
      
    # filePath 설정
    filePath = 'C:/Users/ckdud/pythonwork/imageFiles/' + searchModel



    # 현재 시간
    time_before = datetime.now()

    # 파일 저장 format으로 변경
    time_after = str(time_before).replace(":","-").replace(".", "-")

    # fileName 설정
    fileName =  searchModel+'_'+str(time_after) + path.suffix

    list = [filePath, fileName]
    urlretrieve(imgSrc, fileName)

    return list



#####################################################################################################################

# Check isExist Data
def isRepeat(previousItemList, itemList) :
    
    #같은 값을 응답받으면 True 리턴
    if previousItemList['shoppingResult']['products'][0]['productName'] == itemList['shoppingResult']['products'][0]['productName']:
        
        return True
    #아니면 False 리턴
    return False

# get Data from web And insert Data to DB
def getAndInsertData(itemList, searchModel) :
    # 추출하려는 값의 key를 입력
    for i in itemList['shoppingResult']['products']:
      title = i['productName']
      price = i['price']
      link = i['crUrl']
      imageSrc = i['imageUrl']
      fileDataList = saveFile(imageSrc, searchModel)
      
      filePath = fileDataList[0] + fileDataList[1]
      fileName = fileDataList[1]

      getModel = model.model()
      getModel.setTitle(title)
      getModel.setPrice(price)
      getModel.setLink(link)
      getModel.setType(searchModel)
      getModel.setFileName(fileName)
      getModel.setFilePath(filePath)
      DAO.insertData(getModel)



# get Json Response
def makeRequestAndGetResponse(number, searchModel) :
    pageingIndex = number
    searchModel = searchModel
    params = (
      ('sort', 'rel'),
      ('pagingIndex', pageingIndex),
      ('pagingSize', '20'),
       ('viewType', 'list'),
       ('productSet', 'total'),
       ('deliveryFee', ''),
      ('deliveryTypeValue', ''),
        ('frm', 'NVSHATC'),
       ('query', searchModel),
       ('origQuery', searchModel),
      ('iq', ''),
      ('eq', ''),
      ('xq', ''),
     )

    
    response = requests.get('https://search.shopping.naver.com/api/search/all', headers=headers, params=params)
    return response


#####################################################################################################################
# 중복 체크를 위한 변수

def doCrawling(searchModel):
    previousItemList = []

    
    number = 1
    createDirectory(searchModel)
    while number < 9 :
        print('number = ',number)
        
        # 네이버를 향한 Request 생성 and 네이버로부터 response 받기
        response = makeRequestAndGetResponse(number,  searchModel)

        # json을 리스트로 받기
        itemList = json.loads(response.text)
        
        # 첫번째 호출에는 list가 비교가 안되니 continue를 한다.
        if number == 1 :
            number = number + 1
            previousItemList = itemList
            getAndInsertData(itemList, searchModel)
            continue
            #아래 if문 비교를 수정해야할 듯 하다..
        
        # 반복 응답 Check Method
        # 응답이 같은 값으로 반복되었는지 확인하는 메서드를 실행한다. True일 경우 중복이라서 break
        if isRepeat(previousItemList, itemList) :
            break
        
        previousItemList = itemList
        
        getAndInsertData(itemList, searchModel)
        number = number + 1

    DAO.close_conn()
    return True








