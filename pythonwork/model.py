class model():
  title = ''
  price = ''
  type =''
  fileName =''
  link =''
  filePath = ''

  def __init__(self):
        self.name = '정보 없음'
        self.type = '정보 없음'
        self.address = '정보 없음'
        self.price ='정보 없음'
        self.filePath = '정보 없음'
        self.link = '정보 없음'
        

  def setTitle(self, title):
        self.title = title
  
  def getTitle(self):
      
    return self.title
  
  def setPrice(self, price):
        self.price = price
  
  def getPrice(self):
    
    return self.price
  
  def setType(self, type):
        self.type = type
  
  def getType(self):
    
    return self.type

  def setFileName(self, fileName):
        self.fileName = fileName
  
  def getFileName(self):
    
    return self.fileName
  def setLink(self, link):
        self.link = link
  
  def getLink(self):
    
    return self.link
  def setFilePath(self, filePath):
        self.filePath = filePath
  
  def getFilePath(self):
      
    return self.filePath