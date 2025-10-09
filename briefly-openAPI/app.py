from flask import Flask, jsonify
from services.stock_news_service import get_us_stock_news

app = Flask(__name__)

@app.route('/')
def home():
    return '📈 Briefly News API is running!'

@app.route('/api/news')
def news():
    data = get_us_stock_news()
    return jsonify(data)

if __name__ == '__main__':
    app.run(debug=True)