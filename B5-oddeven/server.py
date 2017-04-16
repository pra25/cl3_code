from flask import Flask,request,render_template

app = Flask(__name__)

@app.route('/')
def indexpage():
    return render_template('index.html')

@app.route('/getnum/',methods=['POST','GET'])
def drawUI():
    print request.form['nums']
    return render_template('numbers.html',count=int(request.form['nums']))

@app.route('/sort/',methods=['POST','GET'])
def sortdata():
    a = request.form.getlist('num')
    b=[]
    for i in a:
    	b.append(int(i))
    #print a.sort()
    c=[]
    c=oddevensort(b)
    print c
    return render_template('sort.html',sorteddata=c)    
    
def oddevensort(a):
    mysorted = False
    while not mysorted:
        mysorted = True        
        for i in range(0,len(a)-1,2):
            if a[i] > a[i+1]:
                a[i] , a[i+1] = a[i+1] , a[i]
                mysorted = False
        for i in range(1,len(a)-1,2):
            if a[i] > a[i+1]:
                a[i] , a[i+1] = a[i+1] , a[i]
                mysorted = False
        
    return a
    
if __name__=="__main__":
    app.run()
