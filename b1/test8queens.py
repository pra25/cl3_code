import unittest
from queens import chess

class test8queens(unittest.TestCase):
    def testLoadFile(self):
        filename= 'input.json'
        obj = chess(8)
        try:
            obj.getFirstPosition(filename)
        except:
	    print "Invalid Input"
         
            
unittest.main()
