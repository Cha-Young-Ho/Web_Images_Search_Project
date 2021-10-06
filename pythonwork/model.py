class model():
  title = ''
  price = ''
  data_type =''
  image_name =''
  link =''
  image_path = ''

  def __init__(self):
        self.title = '정보 없음'
        self.data_type = '정보 없음'
        self.image_name = '정보 없음'
        self.price ='정보 없음'
        self.image_path = '정보 없음'
        self.link = '정보 없음'
        

  def setTitle(self, title):
        self.title = title
  
  def getTitle(self):
      
    return self.title
  
  def setPrice(self, price):
        self.price = price
  
  def getPrice(self):
    
    return self.price
  
  def setDataType(self, data_type):
        self.data_type = data_type
  
  def getDataType(self):
    
    return self.data_type

  def setImageName(self, image_name):
        self.image_name = image_name
  
  def getImageName(self):
    
    return self.image_name
  def setLink(self, link):
        self.link = link
  
  def getLink(self):
    
    return self.link
  def setImagePath(self, image_path):
        self.image_path = image_path
  
  def getImagePath(self):
      
    return self.image_path