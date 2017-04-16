from flask import Flask , request, render_template
import difflib
app = Flask(__name__)

@app.route('/')
def fun():
    return render_template('index.html',msg="")
    
@app.route('/check/',methods=['POST','GET'])
def check():
    a = checker(request.form['string'])
    return render_template('index.html',msg=a)

def checker(str1):
    a=[]
    data_file=open("data.txt","r+").read()
            
    #a=f.split(".")
    #print a
    #b = str1.split(".")
    #print b
    #print(len(b))
    count = 0
    '''for i in a:
        for j in b:
            if i==j:
                count=count+1
                
    print "count = ",count
    percentage = (float(count)/len(b))*100.0                
    '''
    seq=difflib.SequenceMatcher(None,str1,data_file)
    s1=seq.ratio()*100
    
    print s1
    return s1

if __name__=="__main__":
    app.run()
