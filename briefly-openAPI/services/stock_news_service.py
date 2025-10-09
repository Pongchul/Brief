import os
import requests

def get_us_stock_news():
    url = "https://financialmodelingprep.com/api/v3/stock_news"
    params = {
        "limit": 10,
        "apikey": os.getenv("API_KEY")
    }

    response = requests.get(url, params=params)
    if response.status_code == 200:
        data = response.json()
        return [
            {
                "title": item["title"],
                "site": item["site"],
                "publishedDate": item["publishedDate"],
                "text": item["text"]
            }
            for item in data
        ]
    else:
        return {"error": "Failed to fetch news"}