from flask import Flask, jsonify, request
import naverCrawl
import ImageSearchController

app = Flask(__name__)

@app.route('/get_data', methods=['POST'])
def doCrawl():
    
    params = request.get_json()
    print('params = ', params)
    query = params['query']
    print(query)
    check = naverCrawl.doCrawling(query)
    
    return jsonify(check = check)

@app.route('/get_image_data', methods=['POST'])
def imageSearch():
    params = request.get_json()
    query = params['query']
    image = params['image']
    
    return ImageSearchController.getData(query, image);

if __name__ == '__main__':
    app.run(host="192.168.56.1", port="9000", debug=True)
    
    