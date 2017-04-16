from booths import *
from flask import Flask,request,render_template

app = Flask(__name__)

@app.route('/')
def mainpage():
    return render_template('index.html',product=None)

@app.route('/eval',methods=['POST','GET'])
def multiply():
    z = booth(int(request.form['num1']),int(request.form['num2']))
    return render_template('index.html',product=z)
if __name__=="__main__":
    app.run()
