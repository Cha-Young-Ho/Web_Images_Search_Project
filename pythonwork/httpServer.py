from flask import Flask, jsonify, request
import naverCrawl

app = Flask(__name__)

@app.route('/get_data')
def doCrawl():
    
    query = request.args["query"]

    
    check = naverCrawl.doCrawling(query)
    
    return jsonify(check = check)

if __name__ == '__main__':
    app.run(host="192.168.56.1", port="9000", debug=True)
    
    