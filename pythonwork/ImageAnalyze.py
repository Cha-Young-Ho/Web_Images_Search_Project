import numpy as np, cv2
from typing import Type

from pymysql import NULL
import model

     # 이미지를 16X16 크기의 평균 해시로 변환하는 함수

def img2hash(img):

    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    gray = cv2.resize(gray, (16, 16))

    avg = gray.mean()

    bi = 1 * (gray > avg)

    return bi

    

# 해밍거리 측정 함수

def hamming_distance(a, b):

    a = a.reshape(1, -1)

    b = b.reshape(1, -1)

    # 같은 자리의 값이 서로 다른 것들의 합

    distance = (a != b).sum()

    return distance

def analyzeImageAndReturnImage(image, data):

    
    # 영상 읽기 및 표시

    try:
        ff = np.fromfile(image, np.uint8)
        img = cv2.imdecode(ff, cv2.IMREAD_UNCHANGED) # img = array
        
        # 입력 영상의 해시 구하기
        query_hash = img2hash(img)

        # 데이터셋 영상 한개를 읽어서 표시

        ff = np.fromfile(data, np.uint8)
        img2 = cv2.imdecode(ff, cv2.IMREAD_UNCHANGED) # img = array


        cv2.waitKey(2)  # 2ms간 대기

        # 데이터셋 영상 한 개의 해시

        a_hash = img2hash(img2)

        # 해밍거리 산출

        dst = hamming_distance(query_hash, a_hash)

        if dst/256 < 0.2:  # 해밍거리 20% 이내만 출력 (80% 이상 닮은꼴)
            return True;

        return False;
    
    except:
        return False;

   
